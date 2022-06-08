package game;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
   
    // attributes of a Sprite object
    private ImageIcon spriteCharacter;
    private String filePath;
    private double xCoord, yCoord;
    private double xSpeed, ySpeed;
    private int spriteHeight, spriteWidth;
    private int costToPurchase;
    private boolean purchasedAlready;
    
    // private Sprite standingVers, walkingVers, jumpingVers;

    /**
     * Default constructor
     */
    public Sprite() {
        // spriteCharacter = something
        // todo: get some default image for the sprites to prevent a NullPointerException
        filePath = new String();
        xCoord = 0; 
        yCoord = 0;
        spriteHeight = 100; 
        spriteWidth = 100;
        costToPurchase = 0;
        purchasedAlready = false;
    }
        
    /**
     * Primary constructor
     * @param filePath 
     */
    public Sprite(String filePath) {
        this();
        this.filePath = filePath;
        setFilePath(filePath);
    }
    
    /**
     * Secondary constructor
     * @param filePath
     * @param costToPurchase
     */
    public Sprite(String filePath, int costToPurchase) {
        this(filePath);
        this.costToPurchase = costToPurchase;
    }
   
    /**
     * Tertiary constructor
     * @param filePath
     * @param xCoord
     * @param yCoord
     * @param spriteHeight
     * @param spriteWidth 
     */
    public Sprite(String filePath, double xCoord, double yCoord, int spriteHeight, int spriteWidth) {
        this(filePath);  
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
    }
    
    /***
     * Quaternary constructor
     * @param filePath
     * @param xCoord
     * @param yCoord
     * @param xSpeed
     * @param ySpeed
     * @param spriteHeight
     * @param spriteWidth
     * @param costToPurchase
     * @param purchasedAlready 
     */
    public Sprite(String filePath, double xCoord, double yCoord, double xSpeed, double ySpeed, int spriteHeight, int spriteWidth, int costToPurchase, boolean purchasedAlready) {
        this(filePath, xCoord, yCoord, spriteWidth, spriteHeight); 
        this.purchasedAlready = purchasedAlready;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // todo: remove below constructor after testing purposes have been satisfied, only for testing purposes
    public Sprite(int costToPurchase) {
        this();
        this.costToPurchase = costToPurchase;
    }
    
    /**
     * Accessor for the spriteCharacter attribute
     * @return 
     */
    public ImageIcon getSpriteCharacter() {
        return spriteCharacter;
    }
    
    /**
     * Accessor for the filePath attribute
     * @return 
     */
    public String getFilePath() {
        return filePath; 
    }
    
    /**
     * Accessor for the xCoord attribute
     * @return 
     */
    public double getXCoord() {
        return xCoord;
    }
    
    /**
     * Accessor for the yCoord attribute
     * @return 
     */
    public double getYCoord() {
        return yCoord;
    }

    /**
     * Accessor for the spriteHeight attribute
     * @return 
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * Accessor for the spriteWidth attribute
     * @return 
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * Accessor for the costToPurchase attribute
     * @return 
     */
    public int getCostToPurchase() {
        return costToPurchase;
    }

    /**
     * Accessor for the purchasedAlready attribute
     * @return 
     */
    public boolean getPurchasedAlready() {
        return purchasedAlready;
    }
    
    /**
     * Accessor for the xSpeed attribute
     * @return 
     */
    public double getXSpeed() {
        return xSpeed;
    }
    
    /**
     * Accessor for the ySpeed attribute
     * @return 
     */
    public double getYSpeed() {
        return ySpeed;
    }

    /**
     * Mutator for the spriteCharacter attribute
     * @param spriteCharacter 
     */
    public void setSpriteCharacter(ImageIcon spriteCharacter) {
        this.spriteCharacter = spriteCharacter;
    }

    /**
     * Mutator for the filePath attribute
     * @param filePath 
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        
        //Creates a temporary image icon from the file path
        ImageIcon inter = new ImageIcon(filePath);
        Image image = inter.getImage(); // transform it 
        Image finalImg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        inter = new ImageIcon(finalImg);  // transform it back

        //Sets the sprite character to the temporary image icon
        setSpriteCharacter(inter);   
    }
   
    /**
     * Mutator for the xCoord attribute
     * @param xCoord 
     */
    public void setXCoord(double xCoord) {
       this.xCoord = xCoord;   
    }

    /**
     * Mutator for the yCoord attribute
     * @param yCoord 
     */
    public void setYCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * Mutator for the spriteHeight attribute
     * @param spriteHeight 
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public void setSpriteWidht(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public void setCostToPurchase(int costToPurchase) {
        this.costToPurchase = costToPurchase;
    }

    public void setPuchasedAlready(boolean purchasedAlready) {
        this.purchasedAlready = purchasedAlready;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    /**
     * Implements the compareTo() method for the Sprite class (override the compareTo() method)
     * @param otherSprite
     * @return 
     */
    @Override
    public int compareTo(Sprite otherSprite) {
        if (costToPurchase > otherSprite.costToPurchase) {
            return 1;
        } else if (costToPurchase < otherSprite.costToPurchase) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Standard Java equals() method
     * @param otherSprite
     * @return 
     */
    public boolean equals(Sprite otherSprite) {
        return spriteCharacter.equals(otherSprite.getSpriteCharacter()) && filePath.equals(otherSprite.getFilePath()) && xCoord == otherSprite.getXCoord() && yCoord == otherSprite.getYCoord() && spriteHeight == otherSprite.getSpriteHeight() && spriteWidth == otherSprite.getSpriteWidth() && costToPurchase == otherSprite.getCostToPurchase() && purchasedAlready == otherSprite.getPurchasedAlready();
    }

    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public Sprite clone() {
        return new Sprite(filePath, xCoord, yCoord, xSpeed, ySpeed, spriteHeight, spriteWidth, costToPurchase, purchasedAlready);
    }
    
    /**
     * Standard Java toString() method
     * @return a string containing the information about the sprite
     */
    @Override
    public String toString() {
        return "Sprite: " + spriteCharacter + " " + filePath + " " + xCoord + " " + yCoord + " " + spriteHeight + " " + spriteWidth + " " + costToPurchase + " " + purchasedAlready;
    }

}