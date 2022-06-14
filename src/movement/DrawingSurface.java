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

    //Declaring the attributes
    private MovingObject currentObject;
    private Thread animator;
    private final int DELAY = 25;
    private boolean wPressed, aPressed, dPressed;
    private boolean jumping;
    private int begX, begY;
    private double radius;
    private ArrayList<Shape> shapes;
    private Level outerAttribute;
    private ImageIcon backgroundImage;

    //Declaring the static attributes
    private static Color platformColor, lavaColor, doorColor;

    //Setting the static values
    static {
        platformColor = new Color(0, 153, 51);
        lavaColor = new Color(207, 16, 32);
        doorColor = Color.YELLOW;
    }

    /**
     * Accessor for the platform colour
     *
     * @return the platform colour
     */
    public Color getPlatformColor() {
        return platformColor;
    }

    /**
     * Accessor for the lava colour
     *
     * @return the lava colour
     */
    public Color getLavaColor() {
        return lavaColor;
    }

    /**
     * Accessor for the door colour
     *
     * @return the door colour
     */
    public Color getDoorColor() {
        return doorColor;
    }

    /**
     * Primary Constructor
     *
     * @param currentSprite - The current sprite
     * @param begX - The beginning x value
     * @param begY - The beginning y value
     */
    public DrawingSurface(Sprite currentSprite, int begX, int begY) {
        jumping = true; //Sets jumping equal to true
        currentObject = new MovingObject(begX, begY, currentSprite.getSpriteHeight(), currentSprite, 0, 0);
        this.begX = begX;
        this.begY = begY;

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        //Initalizing the array list
        shapes = new ArrayList();
        radius = currentObject.getRadius();

        //The background image equals the image icon of the background png
        backgroundImage = new ImageIcon("src/assets/background.png");
    }

    /**
     * Mutator for the outer attributes
     *
     * @param outerAttribute - The outer attributes
     */
    public void setOuterAttribute(Level outerAttribute) {
        this.outerAttribute = outerAttribute;
    }

    /**
     * Mutator for the shape
     *
     * @param shapeToBeAdded - Adds the shape
     */
    public void addShape(Shape shapeToBeAdded) {
        shapes.add(shapeToBeAdded);
    }

    /**
     * Draws the background
     *
     * @param g - The graphics object
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        currentObject.draw(g2d, outerAttribute.getCurrentSprite().getSpriteCharacter());
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

    /**
     * The method for the movement. Takes in the users input through the
     * keyboard
     */
    public void moveBall() {
        currentObject.update();

        //If the w key is pressed
        if (wPressed) {
            wPress();
        }

        //If the a key is pressed
        if (aPressed) {
            aPress();
        }

        //If the d key is pressed
        if (dPressed) {
            dPress();
        }

        //If the user isn't jumping
        if (!jumping) {

            //Sets the y speed
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

        //If the y value plus the radius is greater than the height
        if (currentObject.getY() + currentObject.getRadius() > getHeight()) {
            currentObject.setySpeed(0); //If the sprite y value is 0
            currentObject.setY(getHeight() - currentObject.getRadius() - 1);
            jumping = true; //The user is jumping
        }

        //If the current object's y value is less than 0
        if (currentObject.getY() < 0) {
            currentObject.setySpeed(0); //Sets the y speed to 0
            currentObject.setY(1);
            jumping = false; //The user isn't jumping
        }

        //Check if it is inside of the box
        for (int i = 0; i < shapes.size(); i++) {
            boolean collisionHappened = checkColl(shapes.get(i));
            if (collisionHappened && shapes.get(i).getColor().equals(lavaColor)) {
                currentObject.setX(begX);
                currentObject.setY(begY);
            } else if (collisionHappened && shapes.get(i).getColor().equals(doorColor)) {
                outerAttribute.getPreviousWindow().endCurrentLevel();
                // level is complete
                outerAttribute.loadLevelMenu();
            }
        }

    }

    /**
     * The method that checks for collision
     *
     * @param object - The given shape object
     * @return A boolean, true if it's colliding and false if it's not colliding
     */
    public boolean checkColl(Shape object) {

        boolean collisionOccurred = false; //Collision hasn't occured, it's set to false

        //If the object's y value plus the radius is greater than the top and the y value is less than the bottom value.
        if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom()) {
            if (currentObject.getX() + currentObject.getRadius() > object.getLeft() && currentObject.getX() < object.getRight()) {
                //Check which box they are in

                //If the x value plus the radius is greater than the object's left value plus 10, and the object's x value is less than the object's right value minus 10
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() + 10 && currentObject.getX() < object.getRight() - 10) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getTop() + 1) {
                        if (jumping == false) {
                            currentObject.setySpeed(0); //Sets the y speed to 0
                            currentObject.setY(object.getTop() - currentObject.getRadius() - 1);
                            jumping = true; //Jumping has occured
                            collisionOccurred = true; //Collision has occured
                        }

                    }
                }

                //If the current object's x value plus it's radius is greater than the object's left value and the current object's left value plus 1
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() && currentObject.getX() < object.getLeft() + 1) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom()) {
                        currentObject.setxSpeed(0); //Sets the x speed to 0
                        currentObject.setX(object.getLeft() - currentObject.getRadius() - 1);
                        collisionOccurred = true; //Collision has occured
                    }
                }

                //If the current object's x value plus it's radius is greater than the object's right value minus 1 and the current object's x value is less than the object's right valur
                if (currentObject.getX() + currentObject.getRadius() > object.getRight() - 1 && currentObject.getX() < object.getRight()) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getTop() && currentObject.getY() < object.getBottom()) {
                        currentObject.setxSpeed(0); //Sets the x speed to 0
                        currentObject.setX(object.getRight() + 1);
                        collisionOccurred = true; //Collision has occured
                    }
                }

                //If the current object's x value plus the current object's radius is greater than the object's left value plus 1- and the current object's x value is less than the object's right value minus 10
                if (currentObject.getX() + currentObject.getRadius() > object.getLeft() + 10 && currentObject.getX() < object.getRight() - 10) {
                    if (currentObject.getY() + currentObject.getRadius() > object.getBottom() - 1 && currentObject.getY() < object.getBottom()) {
                        currentObject.setySpeed(0); //Sets the y speed to 0
                        jumping = false; //Jumping hasn't occured
                        currentObject.setY(object.getBottom() + 1);
                        collisionOccurred = true; //Collision has occured
                    }
                }
            }
        }

        return collisionOccurred; //Returns the boolean
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

    /**
     * Runs when the w key is pressed
     */
    public void wPress() {

        //If the sprite is jumping
        if (jumping) {
            currentObject.setySpeed(-10); //Decreeases the y speed
            jumping = false; //Jumping is disabled
        }
    }

    /**
     * Runs when the a key is pressed
     */
    public void aPress() {
        currentObject.setxSpeed(-4); //Decreases the x speed
    }

    /**
     * Runs when the d key is pressed
     */
    public void dPress() {
        currentObject.setxSpeed(4); //Increases the x speed
    }

    /**
     * Key pressed method
     *
     * @param e - The KeyEvent object
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            dPressed = true;
        }
    }

    /**
     * When the key is released
     *
     * @param e - The KeyEvent object
     */
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = false;
            currentObject.setxSpeed(0);
        }

        if (code == KeyEvent.VK_D) {
            dPressed = false;
            currentObject.setxSpeed(0);
        }
    }

    /**
     * When a key is typed
     *
     * @param e - The KeyEvent object
     */
    public void keyTyped(KeyEvent e) {
        return;
    }

    /**
     * Accessor for the sprite buffer
     *
     * @return the current object's radius
     */
    public double getSpriteBuffer() {
        return currentObject.getRadius();
    }

}
