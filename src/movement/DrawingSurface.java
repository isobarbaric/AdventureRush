package movement;

import game.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import level.Level;

public class DrawingSurface extends JPanel implements KeyListener, Runnable {

    private MovingObject currentObject;
    private Thread animator;
    private final int DELAY = 25;
    private boolean wPressed, aPressed, sPressed, dPressed;
    private boolean jumping;
    private Sprite currentSprite;
    private int begX, begY;
    private double radius;
    private ArrayList<Shape> shapes;
    private Level outerAttribute;
    private ImageIcon backgroundImage;
    
    private static Color platformColor, lavaColor, doorColor;
    
    static {
        platformColor = new Color(0, 153, 51);
        lavaColor = new Color(207, 16, 32);
        doorColor = Color.YELLOW;
    }
    
    public Color getPlatformColor() {
        return platformColor;
    }
    
    public Color getLavaColor() {
        return lavaColor;
    }
    
    public Color getDoorColor() {
        return doorColor;
    }
    
    public DrawingSurface(Sprite currentSprite, int begX, int begY) {
        jumping = true;
        this.currentSprite = currentSprite.clone();
        currentObject = new MovingObject(begX, begY, currentSprite.getSpriteHeight(), currentSprite, 0, 0);
        this.begX = begX;
        this.begY = begY;
        
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        
        shapes = new ArrayList();
        radius = currentObject.getRadius();
       
        backgroundImage = new ImageIcon("src/assets/background.png");
    }
    
    public void setOuterAttribute(Level outerAttribute) {
        this.outerAttribute = outerAttribute;
    }
    
    // temporary setters and getters, will update later
    
    public void addShape(Shape shapeToBeAdded) {
        shapes.add(shapeToBeAdded);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        currentObject.draw(g2d, currentSprite.getSpriteCharacter());
    }

    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//does the necessary work to prepare the panel for drawing
        doDrawing(g);
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).doDrawing(g);
        }
    }

    public void moveBall() {
        currentObject.update();
        
        if (wPressed) {
            wPress();
        }

        if (aPressed) {
            aPress();
        }

        if (sPressed) {
            sPress();
        }

        if (dPressed) {
            dPress();
        }
        
        System.out.println("(" + currentObject.getX() + ", " + currentObject.getY() + ")");

        if (!jumping) {
            currentObject.setySpeed(currentObject.getySpeed() + 0.25);
        }

        //make the ball bounce in the X dimension
        //Changes Frames
        if (currentObject.getX() + currentObject.getRadius() > getWidth()) {
            currentObject.setxSpeed(0);
            currentObject.setX(getWidth() - currentObject.getRadius() - 1);
        }

        //Changes Frames
        if (currentObject.getX() < 0) {
            currentObject.setxSpeed(0);
            currentObject.setX(1);
        }

        //make the ball bounce in the Y dimension
        jumping = false;

        if (currentObject.getY() + currentObject.getRadius() > getHeight()) {
            currentObject.setySpeed(0);
            currentObject.setY(getHeight() - currentObject.getRadius() - 1);
            jumping = true;
        }

        if (currentObject.getY() < 0) {
            currentObject.setySpeed(currentObject.getySpeed() * -1);

        }

        //check if it is inside of the box
        for (int i = 0; i < shapes.size(); i++) {
            boolean collisionHappened = checkColl(shapes.get(i));
            if (collisionHappened && shapes.get(i).getColor().equals(lavaColor)) {
                currentObject.setX(begX);
                currentObject.setY(begY);
            } else if (collisionHappened && shapes.get(i).getColor().equals(doorColor)) {
                // level is complete
                outerAttribute.loadLevelMenu();
            }
        }

    }

    public boolean checkColl(Shape object) {
        //GetLeft
        //GetBottom
        //GetRight
        //GetBottom
        
        boolean collisionOccurred = false;

        if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom()) {
            if (currentObject.getX() + currentObject.getRadius() > object.getLeft() && currentObject.getX() < object.getRight()) {
                //Check which box they are in

                //Top
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() + 10 && currentObject.getX() < object.getRight() - 10) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getTop() + 1) {
                        if (jumping == false) {
                            currentObject.setySpeed(0);
                            currentObject.setY(object.getTop() - currentObject.getRadius() - 1);
                            jumping = true;
                            collisionOccurred = true;
                        }

                    }
                }
                //Left
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() && currentObject.getX() < object.getLeft() + 1) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom() ) {
                        currentObject.setxSpeed(0);
                        currentObject.setX(object.getLeft() - currentObject.getRadius() - 1);
                        collisionOccurred = true;
                    }
                }

                //Right
                if (currentObject.getX() + currentObject.getRadius() > object.getRight() - 1 && currentObject.getX() < object.getRight()) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom()) {
                        currentObject.setxSpeed(0);
                        currentObject.setX(object.getRight() + 1);
                        collisionOccurred = true;
                    }
                }

                //Bottom
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() +10 && currentObject.getX() < object.getRight() - 10) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getBottom() - 1 && currentObject.getY() < object.getBottom()) {
                        currentObject.setySpeed(0);
                        jumping = false;
                        currentObject.setY(object.getBottom() + 1);
                        collisionOccurred = true;
                    }
                }
            }
        }
        
        return collisionOccurred;
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

        while (true) {
            //this loop runs once ever 25 ms (the DELAY)
            
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
        if (jumping) {
            currentObject.setySpeed(-9);
            jumping = false;
        }
    }

    public void aPress() {
        currentObject.setxSpeed(-4);
    }

    public void sPress() {
        //  theBalls.get(0).setySpeed(4);
    }

    public void dPress() {
        currentObject.setxSpeed(4);
    }

    //the methods below are required by the MouseListener interface, but we aren't adding any actions to them
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
            currentObject.setxSpeed(0);
        }
        if (code == KeyEvent.VK_S) {
            sPressed = false;
            currentObject.setySpeed(0);
        }
        if (code == KeyEvent.VK_D) {
            dPressed = false;
            currentObject.setxSpeed(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }
    
    public double getSpriteBuffer() {
        return currentObject.getRadius(); 
    }
    
}