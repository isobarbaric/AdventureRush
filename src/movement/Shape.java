package movement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class Shape {

    // declaring attributes
    private double leftx;
    private double rightx;
    private double topy;
    private double bottomy;
    private String path;
    private ImageIcon sprite;
    private Color shapeColor;

    /**
     * Primary Constructor
     */
    public Shape() {
        leftx = 25;
        rightx = 100;
        topy = 25;
        bottomy = 250;
        path = "";
        shapeColor = Color.GREEN;
    }

    /**
     * Secondary Constructor - Must have a left and right x value, top and
     * bottom y value, and a file path for the sprite image
     * @param leftx - The left most x value of the shape
     * @param rightx - The right most x value of the shape
     * @param topy - The y value of the top of the shape
     * @param bottomy - The y value of the bottom of the shape
     * @param path - The file path of the sprite image
     */
    public Shape(double leftx, double rightx, double topy, double bottomy, String path, Color shapeColor) {
        this.leftx = leftx;
        this.rightx = rightx;
        this.topy = topy;
        this.bottomy = bottomy;
        this.path = path;
        this.shapeColor = shapeColor;
    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        Color currentColor = g2d.getColor();
        g2d.setColor(shapeColor);
        
        g2d.fillRect((int) leftx, (int) topy, (int) (rightx - leftx), (int) (bottomy - topy));
        g2d.setColor(currentColor);
    }
    
    public Color getColor() {
        return shapeColor;
    }
    
    public void setColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
    
    /**
     * Accessor for the left x value
     * @return the left x value
     */
    public double getLeft() {
        return leftx;
    }

    /**
     * Accessor for the right x value
     * @return the right x value
     */
    public double getRight() {
        return rightx;
    }

    /**
     * Accessor for the top y value
     * @return the top y value
     */
    public double getTop() {
        return topy;
    }

    /**
     * Accessor for the bottom y value
     * @return the bottom y value
     */
    public double getBottom() {
        return bottomy;
    }

    /**
     * Accessor for the file path
     * @return the file path
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Accessor for the sprite image
     * @return - The image icon of the sprite
     */
    public ImageIcon getImage() {
        //Looks for the image
        URL url = Shape.class.getResource(path);
        //Creates the image from the file path
        ImageIcon pic = new ImageIcon(url);
        return pic; //Returns the imageIcon sprite
    }

    /**
     * Mutator for the left x value
     * @param leftx - The left x value
     */
    public void setLeft(double leftx) {
        this.leftx = leftx;
    }

    /**
     * Mutator for the right x value
     * @param rightx
     */
    public void setRight(double rightx) {
        this.rightx = rightx;
    }

    /**
     * Mutator for the top y value
     * @param topy
     */
    public void setTop(double topy) {
        this.topy = topy;
    }

    /**
     * Mutator for the bottom y value
     * @param bottomy
     */
    public void setBottom(double bottomy) {
        this.bottomy = bottomy;
    }

    /**
     * Mutator for the file path
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Mutator for the sprite image icon
     * @param sprite - The sprite image icon
     */
    public void setImage(ImageIcon sprite) {
        this.sprite = sprite;
    }
        
    /**
     * Standard Java equals() method 
     * @param other
     * @return 
     */
    public boolean equals(Shape other) {
        return leftx == other.getLeft() && rightx == other.getRight() && topy == other.getTop() && bottomy == other.getBottom() && path.equals(other.getPath()) && sprite == other.getImage();
    }

    /**
     * Standard Java clone() method
     * @return an object that is cloned to the given object
     */
    public Shape clone() {
        return new Shape(leftx, rightx, topy, bottomy, path, shapeColor);
    }
    
    /**
     * Standard Java toString() method
     * @return a String containing the left and right x values, the top and bottom y values, and the file path of the shape
     */
    public String toString() {
        return "Left x-value: " + leftx + "\nRight x-value: " + rightx + "\nTop y-value: " + topy + "\nBottom y-value: " + bottomy + "\nFile Path: " + path;
    }

}