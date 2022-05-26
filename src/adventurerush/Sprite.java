package adventurerush;

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
        // get some default image for the sprites
        filePath = new String();
        xCoord = 0; 
        yCoord = 0;
        spriteHeight = 10; 
        spriteWidth = 10;
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

    public Sprite(ImageIcon spriteCharacter, String filePath, int xCoord, int yCoord, int spriteHeight, int spriteWidth, boolean purchasedAlready) {
        this(spriteCharacter, filePath, xCoord, yCoord, spriteWidth, spriteHeight); 
        this.purchasedAlready = purchasedAlready;
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

    public void quickSort(Sprite[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public int partition(Sprite[] array, int low, int high) {
        int pivot = array[high].costToPurchase;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].costToPurchase <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }


    public void swap(Sprite[] array, int i, int j) {
        Sprite temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(Sprite[] array) {
        quickSort(array, 0, array.length - 1);
    }

}
