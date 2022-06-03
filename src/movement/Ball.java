package movement;

import game.Sprite;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {
    
    // attributes of a Ball
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;
    private double xAcc;
    private double yAcc;
    private double radius;
    private Sprite currentSprite;
    
    /**
     * Create a new ball
     * @param x - the x location of the ball
     * @param y - the y location of the ball
     * @param radius - the size of the ball
     * @param currentSprite
     */
    public Ball(double x, double y, double radius, Sprite currentSprite) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        //set defaults
        xSpeed = 5;
        ySpeed = 2;
        xAcc = 0;
        yAcc = 1;
        this.currentSprite = currentSprite;
    }
    
    /**
     * Updates the location of the ball based on the speed
     */
    public void update() {
        x += xSpeed;
        y += ySpeed;        
    }
    
    /**
     * Draws the ball based on the state of the attributes
     * @param g2d
     * @param spriteImage
     */
    public void draw(Graphics2D g2d, ImageIcon spriteImage) {
        Image spriteIcon = spriteImage.getImage();
        g2d.drawImage(spriteIcon, (int) x, (int) y, null);
    }
    
    /**
     * Getter for the x attribute
     * @return the x position of the ball
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for the x attribute
     * @param x the new x position
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for the y attribute
     * @return the y position of the ball
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for the y attribute
     * @param y the new y position
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for the x speed attribute
     * @return the x speed of the ball
     */
    public double getxSpeed() {
        return xSpeed;
    }
 
    /**
     * Setter for the x speed
     * @param xSpeed the new speed
     */
    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Getter for the y speed attribute
     * @return the y speed of the ball
     */
    public double getySpeed() {
        return ySpeed;
    }

    /**
     * Setter for the y speed
     * @param ySpeed the new speed
     */
    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public double getxAcc() {
        return xAcc;
    }
 
    /**
     * Setter for the x speed
     * @param xAcc the new speed
     */
    public void setxAcc(double xAcc) {
        this.xAcc = xAcc;
    }

    /**
     * Getter for the y speed attribute
     * @return the y speed of the ball
     */
    public double getyAcc() {
        return yAcc;
    }

    /**
     * Setter for the y speed
     * @param yAcc the new speed
     */
    public void setyAcc(double yAcc) {
        this.yAcc = yAcc;
    }

    /**
     * Getter for the radius
     * @return the radius of the ball
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for the radius attribute
     * @param radius - the new radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
  
    /**
     * Get a String representation of the ball
     * @return All of the attributes of the Ball in a String
     */
    public String toString() {
        return "Ball{" + "x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ", radius=" + radius + '}';
    }

    /**
     * Checks if another ball is the same as this one
     * @param other the other ball to compare to this one
     * @return true if they are the same, false otherwise
     */
    public boolean equals(Ball other) {
        // same objects?
        if (this == other) {
            return true;
        }
        // ensure the other ball has been created
        if (other == null) {
            return false;
        }
        // are the radius' different?
        return this.radius == other.radius;
        // if all the above checks pass, then the balls are the same
    }
    
    /**
     * Make an exact copy of this Ball and return it
     * @return the new Ball
     */
    public Ball clone(){
        // instantiate new Ball
        Ball dolly = new Ball(x, y, radius, currentSprite);
        dolly.setxSpeed(xSpeed);
        dolly.setySpeed(ySpeed);
        // return the clone!
        return dolly;
    }
    
}