/*
 * B Cutten
    May 2022
    A class which allows drawing, because it extends JPanel, by way of the 
    Graphics2D class
    A timer is added to the constructor so that the panel is repainted regulary
    and can be animated
 */
package ballmovement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingSurface extends JPanel implements MouseListener, Runnable {

    //an arraylist grows as we add items to it
    private ArrayList<Ball> theBalls = new ArrayList();
    private Thread animator;
    private final int DELAY = 25;
    private int clicks = 0;

    public DrawingSurface() { //constructor for the panel

        //spawn a bunch of random ball objects
        int x, y, rad;
        Color c;
        Ball b;
        //spawn 150 random balls

        //random position on the screen
        x = 900;
        y = 1000;
        //random size
        rad = 50;
        //random color
        c = new Color(120, 120, 0);
        //make the new ball
        b = new Ball(x, y, rad);
        //set the color
        b.setColor(c);
        //random speed
        b.setxSpeed(5);
        b.setySpeed(0);
        theBalls.add(b); //add ball to the list

        //attach the mouse listener to the panel and give it "focus"
        this.addMouseListener(this);
        this.setFocusable(true);
        this.requestFocus();

    }

    //does the actual drawing
    private void doDrawing(Graphics g) {
        //the Graphics2D class is the class that handles all the drawing
        //must be casted from older Graphics class in order to have access to some newer methods
        Graphics2D g2d = (Graphics2D) g;
        //draw each ball in the list
        for (int i = 0; i < theBalls.size(); i++) {
            theBalls.get(i).draw(g2d);
        }
        Color a = new Color(0, 240, 0);
        g2d.setColor(a);
        g2d.fillRect(0, getHeight() - 100, getWidth(), getHeight() - (getHeight() - 100));

        g2d.fillRect(500, 800, 200, 200);

    }

    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//does the necessary work to prepare the panel for drawing
        doDrawing(g);
    }

    //update the position of the ball and make it bounce
    //(we could do more complex game updates here)
    public void moveBall() {
        //check for bouncing on each ball
        for (int i = 0; i < theBalls.size(); i++) {
            theBalls.get(i).update(); //update location of the ball
            //make the ball bounce in the X dimension
            if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > getWidth() || theBalls.get(i).getX() < 0) {
                theBalls.get(i).setxSpeed(theBalls.get(i).getxSpeed() * -1);
            }
            //make the ball bounce in the Y dimension
            if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > getHeight() - 100) {
                theBalls.get(i).setySpeed(theBalls.get(i).getySpeed() * -1);

                theBalls.get(i).setySpeed(0);
                theBalls.get(i).setySpeed(theBalls.get(i).getySpeed() - 3);
            }
            if (theBalls.get(i).getY() < 0) {
                theBalls.get(i).setySpeed(theBalls.get(i).getySpeed() * -1);
            }

            if (700 > theBalls.get(i).getX() + theBalls.get(i).getRadius() && theBalls.get(i).getX() + theBalls.get(i).getRadius() > 500) {
                if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getX() + theBalls.get(i).getRadius() < 1000) {

                   

                }

            }
        }
    }

    //this method is called after the JPanel is added to the JFrame
    //we can perform start up tasks here
    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    //this method is called only once, when the Thread starts
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;
        //get the current time
        beforeTime = System.currentTimeMillis();

        while (true) { //this loop runs once ever 25 ms (the DELAY)

            //update the balls position
            moveBall();
            //redraws the screen (calling the paint component method)
            repaint();

            //calculate how much time has passed since the last call
            //this allows smooth updates and our ball will move at a constant speed (as opposed to being dependent on processor availability)
            timeDiff = System.currentTimeMillis() - beforeTime;

            //calculate how much time to wait before the next call
            sleep = DELAY - timeDiff;

            //always wait at least 2 ms
            if (sleep < 0) {
                sleep = 2;
            }

            //try to actually wait
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                //threads can be interrupted from other threads
                JOptionPane.showMessageDialog(this, "Thread interrupted: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //get the new current time
            beforeTime = System.currentTimeMillis();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        int i = 0;
        //go through each ball in the list

        //  theBalls.get(i).setxSpeed(2);
        theBalls.get(i).setySpeed(-10);

    }

    //the methods below are required by the MouseListener interface, but we aren't adding any actions to them
    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }
}
