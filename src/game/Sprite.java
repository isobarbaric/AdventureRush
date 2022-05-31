package game;

import java.net.URL;
import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
   
    private ImageIcon spriteCharacter;
    private String filePath;
    private int xCoord, yCoord;
    private int spriteHeight, spriteWidth;
    private int costToPurchase;
    private boolean purchasedAlready;

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
        this.spriteCharacter = spriteCharacter;
        this.filePath = filePath;
    }
    
    public Sprite(String filePath, int xCoord, int yCoord) {
        this(filePath);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
   
    public Sprite(String filePath, int xCoord, int yCoord, int spriteHeight, int spriteWidth) {
        this(filePath, xCoord, yCoord);  
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
    }

    public Sprite(String filePath, int xCoord, int yCoord, int spriteHeight, int spriteWidth, int costToPurchase, boolean purchasedAlready) {
        this(filePath, xCoord, yCoord, spriteWidth, spriteHeight); 
        this.purchasedAlready = purchasedAlready;
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
    
    public ImageIcon getFilePath() {
        return spriteCharacter; 
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
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
    
    public String getPath() {
        
        URL url = .class.getResource(filePath);
        
        //create the image from the file location
        ImageIcon pic = new ImageIcon(url);

    }

    // setters

    public void setSpriteCharacter(ImageIcon spriteCharacter) {
        this.spriteCharacter = spriteCharacter;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setXCoord(int xCoord) {
       this.xCoord = xCoord;   
    }

    public void setYCoord(int yCoord) {
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

    // implement a toString method
    public String toString() {
        return "Sprite: " + spriteCharacter + " " + filePath + " " + xCoord + " " + yCoord + " " + spriteHeight + " " + spriteWidth + " " + costToPurchase + " " + purchasedAlready;
    }

    // implement a equals method
    public boolean equals(Sprite otherSprite) {
        if (spriteCharacter.equals(otherSprite.spriteCharacter) && filePath.equals(otherSprite.filePath) && xCoord == otherSprite.xCoord && yCoord == otherSprite.yCoord && spriteHeight == otherSprite.spriteHeight && spriteWidth == otherSprite.spriteWidth && costToPurchase == otherSprite.costToPurchase && purchasedAlready == otherSprite.purchasedAlready) {
            return true;
        } else {
            return false;
        }
    }

    // implement a clone method
    public Sprite clone() {
        return new Sprite(spriteCharacter, filePath, xCoord, yCoord, spriteHeight, spriteWidth, costToPurchase, purchasedAlready);
    }

}
