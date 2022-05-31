/*
 * B Cutten
    April 2016
    Represents a ball
 */
package ballmovement;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
    //attributes of a Ball
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private int radius;
    private Color c;

    /**
     * Create a new ball
     * @param x - the x location of the ball
     * @param y - the y location of the ball
     * @param radius - the size of the ball
     */
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        //set defaults
        c = Color.BLUE;
        xSpeed = 5;
        ySpeed = 2;
    }

    
    /**
     * updates the location of the ball based on the speed
     */
    public void update(){
        
        x+=xSpeed;
        y+=ySpeed;
    }
    
    /**
     * Draws the ball based on the state of the attributes
     * @param g2d - the Graphics obj which does the drawing
     */
    public void draw(Graphics2D g2d){
        g2d.setColor(c);
        g2d.fillOval(x,y,radius,radius);
    }
    
    /**
     * Getter for the x attribute
     * @return the x position of the ball
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for the x attribute
     * @param x the new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for the y attribute
     * @return the y position of the ball
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for the y attribute
     * @param y the new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter for the x speed attribute
     * @return the x speed of the ball
     */
    public int getxSpeed() {
        return xSpeed;
    }
 
    /**
     * Setter for the x speed
     * @param xSpeed the new speed
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Getter for the y speed attribute
     * @return the y speed of the ball
     */
    public int getySpeed() {
        return ySpeed;
    }

    /**
     * Setter for the y speed
     * @param ySpeed the new speed
     */
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Getter for the radius
     * @return the radius of the ball
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Setter for the radius attribute
     * @param radius - the new radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
  
    /**
     * Getter for the color
     * @return the color of the ball
     */
    public Color getColor() {
        return c;
    }

    /**
     * Setter for the color attribute
     * @param c - the new Color
     */
    public void setColor(Color c) {
        this.c = c;
    }

    /**
     * Get a String representation of the ball
     * @return All of the attributes of the Ball in a String
     */
    public String toString() {
        return "Ball{" + "x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ", radius=" + radius + ", c=" + c + '}';
    }

    /**
     * Checks if another ball is the same as this one
     * @param other the other ball to compare to this one
     * @return true if they are the same, false otherwise
     */
    public boolean equals(Ball other) {
        //same objects?
        if (this == other) {
            return true;
        }
        //ensure the other ball has been created
        if (other == null) {
            return false;
        }        
        //are the radius' different?
        if (this.radius != other.radius) {
            return false;
        }
        //different colors?
        if (!this.c.equals(other.c)) {
            return false;
        }
        //if all the above checks pass, then the balls are the same
        return true;
    }
    
    /**
     * Make an exact copy of this Ball and return it
     * @return the new Ball
     */
    public Ball clone(){
        //instantiate new Ball
        Ball dolly = new Ball(x,y,radius);
        //set remaining attributes
        dolly.setColor(c);
        dolly.setxSpeed(xSpeed);
        dolly.setySpeed(ySpeed);
        //return the clone!
        return dolly;
    }
    
    
    
    
}
