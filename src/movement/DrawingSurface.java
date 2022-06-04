package movement;

import game.Sprite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingSurface extends JPanel implements KeyListener, Runnable {

    // attributes of a DrawingSurface object
    private boolean wPressed;
    private boolean aPressed;
    private boolean sPressed;
    private boolean dPressed;
    private boolean jumpA;
    
    private ArrayList<Ball> theBalls = new ArrayList();
    private Thread animator;
    private int DELAY = 25;
    private Sprite currentSprite;

    public DrawingSurface(Sprite currentSprite) {
        // initializing the currentSprite attribute
        this.currentSprite = currentSprite.clone();
        theBalls.add(new Ball(200, 300, currentSprite.getSpriteHeight(), currentSprite, 0, 0)); 
        
        // setting misc settings to true
        jumpA = true;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();             
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // draw each ball in the list
        for (int i = 0; i < theBalls.size(); i++) {
            theBalls.get(i).draw(g2d, new ImageIcon(currentSprite.getSpriteCharacter()));
        }
        g2d.fillRect(800, 800, 200, 200);
    }

    // overrides paintComponent in JPanel class
    // performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        // does the necessary work to prepare the panel for drawing
        super.paintComponent(g);
        doDrawing(g);
    }

    // update the position of the ball and make it bounce
    // (we could do more complex game updates here)
    public void moveBall() {
        // check for bouncing on each ball
        for (int i = 0; i < theBalls.size(); i++) {
            
            // update location of the ball
            theBalls.get(i).update(); 
            
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
            if (jumpA == false) {
                theBalls.get(i).setySpeed(theBalls.get(i).getySpeed() + 0.25);
            }
            
            // changes Frames
            if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > getWidth()) {
                theBalls.get(i).setxSpeed(0);
                theBalls.get(i).setX(getWidth() - theBalls.get(i).getRadius() - 1);
            }
            
            // changes Frames
            if (theBalls.get(i).getX() < 0) {
                theBalls.get(i).setxSpeed(0);
                theBalls.get(i).setX(1);
            }
            
            // make the ball bounce in the Y dimension 
            
            jumpA = false;
            if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > getHeight()) {
                theBalls.get(i).setySpeed(0);
                theBalls.get(i).setY(getHeight() - theBalls.get(i).getRadius() - 1);
                jumpA = true;            
            }
            
            if (theBalls.get(i).getY() < 0) {
                theBalls.get(i).setySpeed(theBalls.get(i).getySpeed() * -1);
            }

            // check if it is inside of the box
            if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getY() < 1000) {
                if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getX() < 1000) {
                    // check which box they are in
                    // top
                    if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getX() < 1000) {
                        if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getY() < 801) {
                            if (jumpA == false) {
                                theBalls.get(i).setySpeed(0);
                                theBalls.get(i).setY(800 - theBalls.get(i).getRadius() - 1);
                                jumpA = true;
                            }
                        }
                    }
                    // left
                    if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getX() < 801) {
                        if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getY() < 1000) {
                            theBalls.get(i).setxSpeed(0);
                            theBalls.get(i).setX(800-theBalls.get(i).getRadius()-1);
                        }
                    }
                    // right
                    if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > 999 && theBalls.get(i).getX() < 1000) {
                        if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getY() < 1000) {
                            theBalls.get(i).setxSpeed(0);
                            theBalls.get(i).setX(1000+1);
                        }
                    }
                    // bottom
                    if (theBalls.get(i).getX() + theBalls.get(i).getRadius() > 800 && theBalls.get(i).getX() < 1000) {
                        if (theBalls.get(i).getY() + theBalls.get(i).getRadius() > 999 && theBalls.get(i).getY() < 1000) {
                            theBalls.get(i).setySpeed(0);
                            jumpA = false;
                            theBalls.get(i).setY(1000+1);
                        }
                    }
                }
            }
        }
    }

    // this method is called after the JPanel is added to the JFrame
    // we can perform start up tasks here
    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    // this method is called only once, when the Thread starts
    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        // get the current time
        beforeTime = System.currentTimeMillis();

        // this loop runs once ever 25 ms (the DELAY)
        while (true) { 
            // update the balls position
            moveBall();
            // redraws the screen (calling the paint component method)
            repaint();
            // calculate how much time has passed since the last call
            // this allows smooth updates and our ball will move at a constant speed (as opposed to being dependent on processor availability)
            timeDiff = System.currentTimeMillis() - beforeTime;
            // calculate how much time to wait before the next call
            sleep = DELAY - timeDiff;
            // always wait at least 2 ms
            if (sleep < 0) {
                sleep = 2;
            }
            // try to actually wait
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                // threads can be interrupted from other threads
                JOptionPane.showMessageDialog(this, "Thread interrupted: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            // get the new current time
            beforeTime = System.currentTimeMillis();
        }
    }

    public void wPress() {
        int i = 0;
        if (jumpA == true) {
            theBalls.get(i).setySpeed(-15);
            jumpA = false;
        }
        System.out.println(jumpA);
    }

    public void aPress() {
        int i = 0;
        theBalls.get(i).setxSpeed(-4);
    }

    public void sPress() {
        int i = 0;
    }

    public void dPress() {
        int i = 0;
        theBalls.get(i).setxSpeed(4);
    }

    // the methods below are required by the MouseListener interface, but we aren't adding any actions to them
    @Override
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
            theBalls.get(0).setxSpeed(0);
        }
        if (code == KeyEvent.VK_S) {
            sPressed = false;
            theBalls.get(0).setySpeed(0);
        }
        if (code == KeyEvent.VK_D) {
            dPressed = false;
            theBalls.get(0).setxSpeed(0);
        }
    }

    // todo: add code for keyTyped()
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
