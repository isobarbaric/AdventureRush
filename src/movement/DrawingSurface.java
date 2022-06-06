package movement;

import m2.Shape;
import game.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingSurface extends JPanel implements KeyListener, Runnable {

    private Ball drawingSprite;
    private Thread animator;
    private final int DELAY = 25;
    private boolean wPressed;
    private boolean aPressed;
    private boolean sPressed;
    private boolean dPressed;
    private boolean jumpRn;
    private Sprite currentSprite;
    private Shape testingShape;

    public DrawingSurface(Sprite currentSprite) { //constructor for the panel

        //spawn a bunch of random ball objects
        Color c;
        
        jumpRn = true;

        //random color
        c = new Color(125, 125, 125);
        
        //make the new ball
        this.currentSprite = currentSprite.clone();
        
        Ball b = new Ball(200, 300, currentSprite.getSpriteHeight(), currentSprite);
        //random speed
        b.setxSpeed(0);
        b.setySpeed(0);
        drawingSprite = b; //add ball to the list

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();             
        
        // testing a shape
        testingShape = new Shape();
    }

    private void doDrawing(Graphics g) {
        //the Graphics2D class is the class that handles all the drawing
        //must be casted from older Graphics class in order to have access to some newer methods
        Graphics2D g2d = (Graphics2D) g;
        //draw each ball in the list
        drawingSprite.draw(g2d, new ImageIcon(currentSprite.getSpriteCharacter()));
        Color a;
//        a = new Color(0, 240, 0);
//        g2d.setColor(a);
//        g2d.fillRect((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        testingShape.doDrawing(g2d);
    }

    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        // does the necessary work to prepare the panel for drawing
        super.paintComponent(g); 
        doDrawing(g);
    }

    //update the position of the ball and make it bounce
    //(we could do more complex game updates here)
    public void moveBall() {
            drawingSprite.update(); //update location of the ball
            if (wPressed == true) {
                wPress();
            }
            if (aPressed == true) {
                aPress();
            }
            if (sPressed == true) {
                sPress();
            }
            if (dPressed == true) {
                dPress();
            }

            if (jumpRn == false) {
                drawingSprite.setySpeed(drawingSprite.getySpeed() + 0.25);
            }

            //make the ball bounce in the X dimension
            
            //Changes Frames
            if (drawingSprite.getX() + drawingSprite.getRadius() > getWidth()) {
                drawingSprite.setxSpeed(0);
                drawingSprite.setX(getWidth() - drawingSprite.getRadius() - 1);
            }

            //Changes Frames
            if (drawingSprite.getX() < 0) {
                drawingSprite.setxSpeed(0);
                drawingSprite.setX(1);
            }
           
            //make the ball bounce in the Y dimension            
            jumpRn = false;
            if (drawingSprite.getY() + drawingSprite.getRadius() > getHeight()) {
                drawingSprite.setySpeed(0);
                drawingSprite.setY(getHeight() - drawingSprite.getRadius() - 1);
                jumpRn = true;
            }
            
            if (drawingSprite.getY() < 0) {
                drawingSprite.setySpeed(drawingSprite.getySpeed() * -1);
            }
            //check if it is inside of the box
            if (drawingSprite.getY() + drawingSprite.getRadius() > 800 && drawingSprite.getY() < 1000) {
                if (drawingSprite.getX() + drawingSprite.getRadius() > 800 && drawingSprite.getX() < 1000) {
                    //Check which box they are in
                    //Top
                    if (drawingSprite.getX() + drawingSprite.getRadius() > 800 && drawingSprite.getX() < 1000) {
                        if (drawingSprite.getY() + drawingSprite.getRadius() > 800 && drawingSprite.getY() < 801) {
                            if (jumpRn == false) {
                                drawingSprite.setySpeed(0);
                                drawingSprite.setY(800 - drawingSprite.getRadius() - 1);
                                jumpRn = true;
                            }
                        }
                    }
                    //Left
                    if (drawingSprite.getX() + drawingSprite.getRadius() > 800 && drawingSprite.getX() < 801) {
                        if (drawingSprite.getY() + drawingSprite.getRadius() > 800 && drawingSprite.getY() < 1000) {
                            drawingSprite.setxSpeed(0);
                            drawingSprite.setX(800-drawingSprite.getRadius()-1);
                        }
                    }

                    //Right
                    if (drawingSprite.getX() + drawingSprite.getRadius() > 999 && drawingSprite.getX() < 1000) {
                        if (drawingSprite.getY() + drawingSprite.getRadius() > 800 && drawingSprite.getY() < 1000) {
                            drawingSprite.setxSpeed(0);
                            drawingSprite.setX(1000+1);
                        }
                    }

                    //Bottom
                    if (drawingSprite.getX() + drawingSprite.getRadius() > 800 && drawingSprite.getX() < 1000) {
                        if (drawingSprite.getY() + drawingSprite.getRadius() > 999 && drawingSprite.getY() < 1000) {
                            drawingSprite.setySpeed(0);
                            jumpRn = false;
                            drawingSprite.setY(1000+1);
                        }
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

    public void wPress() {
        if (jumpRn == true) {
            drawingSprite.setySpeed(-15);
            jumpRn = false;
        }
    }

    public void aPress() {
        drawingSprite.setxSpeed(-4);

    }

    public void sPress() {
        //  drawingSprite.setySpeed(4);
    }

    public void dPress() {
        drawingSprite.setxSpeed(4);
    }

    //the methods below are required by the MouseListener interface, but we aren't adding any actions to them
//    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            sPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            dPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = false;
            drawingSprite.setxSpeed(0);
        }
        if (code == KeyEvent.VK_S) {
            sPressed = false;
            drawingSprite.setySpeed(0);
        }
        if (code == KeyEvent.VK_D) {
            dPressed = false;
            drawingSprite.setxSpeed(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing 
    }

}