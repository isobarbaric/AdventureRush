package game;

import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
   
    // attributes of a Sprite object
    private ImageIcon spriteCharacter;
    private String filePath;
    private int spriteHeight, spriteWidth;
    private int costToPurchase;
    
    // static attributes 
    private static String defaultSpritePath;
    
    // static block for safe initialization
    static {
        defaultSpritePath = "src/assets/sprite-8.png";
    }
    
    /**
     * Default constructor
     */
    public Sprite() {
        // initializes filePath
        filePath = defaultSpritePath;

        // initializes costToPurchase
        costToPurchase = 0;

        // initializes spriteCharacter
        spriteCharacter = new ImageIcon(filePath);

        // initializes spriteHeight
        spriteHeight = spriteCharacter.getIconHeight(); 

        // initializes spriteWidth
        spriteWidth = spriteCharacter.getIconWidth();
    }
        
    /**
     * Primary constructor
     * @param filePath file path of the Sprite ImageIcon
     */
    public Sprite(String filePath) {
        // chaining of constructors
        this();

        // initializes filePath with the provided filePath parameter
        this.filePath = filePath;

        // initializes spriteCharacter with the provided filePath parameter
        spriteCharacter = new ImageIcon(filePath);
    }
    
    /**
     * Secondary constructor
     * @param filePath file path of the Sprite ImageIcon
     * @param costToPurchase cost to purchase the Sprite in the Store
     */
    public Sprite(String filePath, int costToPurchase) {
        // chaining of constructors
        this(filePath);

        // initializes costToPurchase with the provided costToPurchase parameter
        this.costToPurchase = costToPurchase;
    }
   
    /**
     * Tertiary constructor
     * @param filePath file path of the Sprite ImageIcon
     * @param spriteHeight the height of the Sprite
     * @param spriteWidth the width of the Sprite
     */
    public Sprite(String filePath, int spriteHeight, int spriteWidth) {
        // chaining of constructors
        this(filePath);  

        // initializes spriteHeight with the provided spriteHeight parameter
        this.spriteHeight = spriteHeight;

        // initializes spriteWidth with the provided spriteWidth parameter
        this.spriteWidth = spriteWidth;
    }
    
    /***
     * Quaternary constructor
     * @param filePath file path of the Sprite ImageIcon
     * @param spriteHeight the height of the Sprite
     * @param spriteWidth the width of the Sprite
     * @param costToPurchase cost to purchase the Sprite in the Store
     */
    public Sprite(String filePath, int spriteHeight, int spriteWidth, int costToPurchase) {
        // chaining of constructors
        this(filePath, spriteWidth, spriteHeight); 

        // initializes costToPurchase with the provided costToPurchase parameter
        this.costToPurchase = costToPurchase;
    }
    
    // getters

    /**
     * Accessor for the spriteCharacter attribute
     * @return the ImageIcon associated with the Sprite
     */
    public ImageIcon getSpriteCharacter() {
        return spriteCharacter;
    }
    
    /**
     * Accessor for the filePath attribute
     * @return file path of the Sprite ImageIcon
     */
    public String getFilePath() {
        return filePath; 
    }
    
    /**
     * Accessor for the spriteHeight attribute
     * @return the height of the Sprite
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * Accessor for the spriteWidth attribute
     * @return the width of the Sprite
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * Accessor for the costToPurchase attribute
     * @return cost to purchase the Sprite in the Store
     */
    public int getCostToPurchase() {
        return costToPurchase;
    }
    
    // setters 
    
    /**
     * Mutator for the spriteCharacter attribute
     * @param spriteCharacter the ImageIcon associated with the Sprite
     */
    public void setSpriteCharacter(ImageIcon spriteCharacter) {
        this.spriteCharacter = spriteCharacter;
    }

    /**
     * Mutator for the filePath attribute
     * @param filePath file path of the Sprite ImageIcon
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        spriteCharacter = new ImageIcon(filePath);
    }
   
    /**
     * Mutator for the spriteHeight attribute
     * @param spriteHeight the height of the Sprite
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    /**
     * Mutator for the spriteWidth attribute
     * @param spriteWidth the width of the Sprite
     */
    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    /**
     * Mutator for the costToPurchase attribute
     * @param costToPurchase cost to purchase the Sprite in the Store
     */
    public void setCostToPurchase(int costToPurchase) {
        this.costToPurchase = costToPurchase;
    }

    /**
     * Implements the compareTo() method for the Sprite class (override the compareTo() method)
     * @param otherSprite the other Sprite being compared to
     * @return the ordering based on both the Sprite's costToPurchase attribute
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
     * @param otherSprite the other Sprite object being compared to
     * @return whether the two Sprite objects are identical or not
     */
    public boolean equals(Sprite otherSprite) {
        return filePath.equals(otherSprite.getFilePath());
    }

    /**
     * Standard Java clone() method
     * @return a new Sprite object that is a clone of the current Sprite object
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