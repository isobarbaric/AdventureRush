package game;

import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
   
    // attributes of a Sprite object
    private ImageIcon spriteCharacter;
    private String filePath;
    private int spriteHeight, spriteWidth;
    private int costToPurchase;

    /**
     * Default constructor
     */
    public Sprite() {
        filePath = "src/assets/sprite-6.png";
        costToPurchase = 0;
        spriteCharacter = new ImageIcon(filePath);
        spriteHeight = spriteCharacter.getIconHeight(); 
        spriteWidth = spriteCharacter.getIconWidth();
    }
        
    /**
     * Primary constructor
     * @param filePath 
     */
    public Sprite(String filePath) {
        this();
        this.filePath = filePath;
        spriteCharacter = new ImageIcon(filePath);
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
     * @param spriteHeight
     * @param spriteWidth 
     */
    public Sprite(String filePath, int spriteHeight, int spriteWidth) {
        this(filePath);  
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
    }
    
    /***
     * Quaternary constructor
     * @param filePath
     * @param spriteHeight
     * @param spriteWidth
     * @param costToPurchase
     */
    public Sprite(String filePath, int spriteHeight, int spriteWidth, int costToPurchase) {
        this(filePath, spriteWidth, spriteHeight); 
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
        spriteCharacter = new ImageIcon(filePath);
    }
   
    /**
     * Mutator for the spriteHeight attribute
     * @param spriteHeight 
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public void setCostToPurchase(int costToPurchase) {
        this.costToPurchase = costToPurchase;
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
        return filePath.equals(otherSprite.getFilePath());
    }

    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public Sprite clone() {
        return new Sprite(filePath, spriteHeight, spriteWidth, costToPurchase);
    }
    
    /**
     * Standard Java toString() method
     * @return a string containing the information about the sprite
     */
    @Override
    public String toString() {
        return "Sprite: " + filePath + " " + costToPurchase;
    }

}