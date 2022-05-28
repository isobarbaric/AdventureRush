package game;

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
        
    public Sprite(ImageIcon spriteCharacter, String filePath) {
        this();
        this.spriteCharacter = spriteCharacter;
        this.filePath = filePath;
    }
    
    public Sprite(ImageIcon spriteCharacter, String filePath, int xCoord, int yCoord) {
        this(spriteCharacter, filePath);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
   
    public Sprite(ImageIcon spriteCharacter, String filePath, int xCoord, int yCoord, int spriteHeight, int spriteWidth) {
        this(spriteCharacter, filePath, xCoord, yCoord);  
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
    }

    public Sprite(ImageIcon spriteCharacter, String filePath, int xCoord, int yCoord, int spriteHeight, int spriteWidth, int costToPurchase, boolean purchasedAlready) {
        this(spriteCharacter, filePath, xCoord, yCoord, spriteWidth, spriteHeight); 
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
    
    public String getFilePath() {
        return filePath; 
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
    
    // public boolean compareTo(Sprite otherSprite) {
    //     if (costToPurchase == otherSprite.costToPurchase)
    // }
    
    // implement the compareTo() method for the Sprite class (override the compareTo() method)
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

    // implement a quickSort algorithm to sort an array of sprites
    public static void quickSort(Sprite[] sprites) {
        quickSort(sprites, 0, sprites.length - 1);
    }

    // implement a quickSort algorithm to sort an array of sprites
    public static void quickSort(Sprite[] sprites, int low, int high) {
        if (low < high) {
            int pivot = partition(sprites, low, high);
            quickSort(sprites, low, pivot - 1);
            quickSort(sprites, pivot + 1, high);
        }
    }

    // implement a partition algorithm to sort an array of sprites
    public static int partition(Sprite[] sprites, int low, int high) {
        Sprite pivot = sprites[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (sprites[j].compareTo(pivot) < 0) {
                i++;
                swap(sprites, i, j);
            }
        }
        swap(sprites, i + 1, high);
        return i + 1;
    }

    // implement a swap algorithm to sort an array of sprites
    public static void swap(Sprite[] sprites, int i, int j) {
        Sprite temp = sprites[i];
        sprites[i] = sprites[j];
        sprites[j] = temp;
    }

}
