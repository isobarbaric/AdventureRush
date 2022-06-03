package game;

import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
   
    private ImageIcon spriteCharacter;
    private String filePath;
    private double xCoord, yCoord;
    private double xSpeed, ySpeed;
    private int spriteHeight, spriteWidth;
    private int costToPurchase;
    private boolean purchasedAlready;
    private Sprite standingVers, walkingVers, jumpingVers;

    public Sprite() {
        // spriteCharacter = something
        // todo: get some default image for the sprites to prevent a NullPointerException
        filePath = new String();
        xCoord = 0; 
        yCoord = 0;
        spriteHeight = 10; 
        spriteWidth = 10;
        costToPurchase = 0;
        purchasedAlready = false;
    }
        
    public Sprite(String filePath) {
        this();
        this.filePath = filePath;
//        spriteCharacter = new ImageIcon(getClass().getResource(filePath));
    }
    
    public Sprite(String filePath, double xCoord, double yCoord) {
        this(filePath);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
   
    public Sprite(String filePath, double xCoord, double yCoord, int spriteHeight, int spriteWidth) {
        this(filePath, xCoord, yCoord);  
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
    }

    public Sprite(String filePath, double xCoord, double yCoord, double xSpeed, double ySpeed, int spriteHeight, int spriteWidth, int costToPurchase, boolean purchasedAlready) {
        this(filePath, xCoord, yCoord, spriteWidth, spriteHeight); 
        this.purchasedAlready = purchasedAlready;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // remove below constructor after testing purposes have been satisfied, only for testing purposes
    public Sprite(int costToPurchase) {
        this();
        this.costToPurchase = costToPurchase;
    }
    
    // getters 

    public ImageIcon getSpriteCharacter() {
        return spriteCharacter;
    }
    
    public String getFilePath() {
        return filePath; 
    }

    public double getXCoord() {
        return xCoord;
    }

    public double getYCoord() {
        return yCoord;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public int getCostToPurchase() {
        return costToPurchase;
    }

    public boolean getPurchasedAlready() {
        return purchasedAlready;
    }
    
    public double getXSpeed() {
        return xSpeed;
    }
    
    public double getYSpeed() {
        return ySpeed;
    }

    // setters

    public void setSpriteCharacter(ImageIcon spriteCharacter) {
        this.spriteCharacter = spriteCharacter;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setXCoord(double xCoord) {
       this.xCoord = xCoord;   
    }

    public void setYCoord(double yCoord) {
        this.yCoord = yCoord;
    }

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
    
    // behavior
    
    // implement the compareTo() method for the Sprite class (override the compareTo() method)
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

  

    // implement a equals method
    public boolean equals(Sprite otherSprite) {
        return spriteCharacter.equals(otherSprite.getSpriteCharacter()) && filePath.equals(otherSprite.getFilePath()) && xCoord == otherSprite.getXCoord() && yCoord == otherSprite.getYCoord() && spriteHeight == otherSprite.getSpriteHeight() && spriteWidth == otherSprite.getSpriteWidth() && costToPurchase == otherSprite.getCostToPurchase() && purchasedAlready == otherSprite.getPurchasedAlready();
    }

    // implement a clone method
    public Sprite clone() {
        return new Sprite(filePath, xCoord, yCoord, xSpeed, ySpeed, spriteHeight, spriteWidth, costToPurchase, purchasedAlready);
    }
    
    /**
     * The toString containing the sprite information
     * @return a string containing the information about the sprite
     */
    public String toString() {
        return "Sprite: " + spriteCharacter + " " + filePath + " " + xCoord + " " + yCoord + " " + spriteHeight + " " + spriteWidth + " " + costToPurchase + " " + purchasedAlready;
    }
}
