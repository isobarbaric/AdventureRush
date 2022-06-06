package m2;

import game.Sprite;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingSurface extends JPanel implements KeyListener, Runnable {

    private MovingObject drawingSprite;
    private Thread animator;
    private final int DELAY = 25;
    private Sprite currentSprite;
    private Shape testingShape;
    
    private boolean wKey, aKey, sKey, dKey;
    private boolean jumping;

    public DrawingSurface(Sprite currentSprite) { //constructor for the panel
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();             

        this.currentSprite = currentSprite.clone();
        
        MovingObject b = new MovingObject(200, 300, currentSprite.getSpriteHeight(), currentSprite, 0, 0);
        drawingSprite = b;

        testingShape = new Shape();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawingSprite.draw(g2d, new ImageIcon(currentSprite.getSpriteCharacter()));
    }

    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        // does the necessary work to prepare the panel for drawing
        super.paintComponent(g); 
        doDrawing(g);
    }

    public void wPress() {
        if (jumping == true) {
            drawingSprite.setySpeed(-15);
            jumping = false;
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
    
    public void moveBall() {
        drawingSprite.update(); //update location of the ball
        if (wKey) {
            wPress();
        }
        
        if (aKey) {
            aPress();
        }
        
        if (sKey) {
            sPress();
        }
        
        if (dKey) {
            dPress();
        }
        
        if (jumping == false) {
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
        jumping = false;
        
        if (drawingSprite.getY() + drawingSprite.getRadius() > getHeight()) {
            drawingSprite.setySpeed(0);
            drawingSprite.setY(getHeight() - drawingSprite.getRadius() - 1);
            jumping = true;
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
                        if (jumping == false) {
                            drawingSprite.setySpeed(0);
                            drawingSprite.setY(800 - drawingSprite.getRadius() - 1);
                            jumping = true;
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
                        jumping = false;
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
        // get the current time
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
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                wKey = true;
            case KeyEvent.VK_A:
                aKey = true;
            case KeyEvent.VK_S:
                sKey = true;
            case KeyEvent.VK_D:
                dKey = true;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                wKey = false;
            case KeyEvent.VK_A:
                aKey = false;
            case KeyEvent.VK_S:
                sKey = false;
            case KeyEvent.VK_D:
                dKey = false;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

}