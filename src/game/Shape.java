package game;

import java.net.URL;
import javax.swing.ImageIcon;

public class Shape {

    //Declaring attributes
    private double leftx;
    private double rightx;
    private double topy;
    private double bottomy;
    private String path;
    private ImageIcon sprite;

    /**
     * Primary Constructor
     */
    public Shape() {

        leftx = 0;
        rightx = 0;
        topy = 0;
        bottomy = 0;
        path = "";

    }

    /**
     * Secondary Constructor - Must have a left and right x value, top and
     * bottom y value, and a file path for the sprite image
     *
     * @param leftx - The left most x value of the shape
     * @param rightx - The right most x value of the shape
     * @param topy - The y value of the top of the shape
     * @param bottomy - The y value of the bottom of the shape
     * @param path - The file path of the sprite image
     */
    public Shape(double leftx, double rightx, double topy, double bottomy, String path) {

        this.leftx = leftx;
        this.rightx = rightx;
        this.topy = topy;
        this.bottomy = bottomy;
        this.path = path;

    }

    /**
     * Accessor for the left x value
     *
     * @return the left x value
     */
    public double getLeft() {

        return leftx;
    }

    /**
     * Accessor for the right x value
     *
     * @return the right x value
     */
    public double getRight() {

        return rightx;
    }

    /**
     * Accessor for the top y value
     *
     * @return the top y value
     */
    public double getTop() {

        return topy;
    }

    /**
     * Accessor for the bottom y value
     *
     * @return the bottom y value
     */
    public double getBottom() {

        return bottomy;
    }

    /**
     * Accessor for the file path
     *
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
     *
     * @param leftx - The left x value
     */
    public void setLeft(double leftx) {

        this.leftx = leftx;

    }

    /**
     * Mutator for the right x value
     *
     * @param leftx - The right x value
     */
    public void setRight(double rightx) {

        this.rightx = rightx;

    }

    /**
     * Mutator for the top y value
     *
     * @param leftx - The top y value
     */
    public void setTop(double topy) {

        this.topy = topy;

    }

    /**
     * Mutator for the bottom y value
     *
     * @param leftx - The bottom y value
     */
    public void setBottom(double bottomy) {

        this.bottomy = bottomy;

    }

    /**
     * Mutator for the file path
     *
     * @param leftx - The file path
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
     * toString containing the information of the shape
     * @return a String containing the left and right x values, the top and bottom y values, and the file path of the shape
     */
    public String toString() {
        
        return "Left x-value: " + leftx + "\nRight x-value: " + rightx + "\nTop y-value: " + topy + "\nBottom y-value: " + bottomy + "\nFile Path: " + path;
        
    }
}
