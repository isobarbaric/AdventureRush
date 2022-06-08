package game;

import adventurerush.Menu;
import adventurerush.User;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Store extends Menu {

    // attributes specific to a Store object
    private ArrayList<Sprite> storeItems;

    /**
     * Default constructor
     */
    public Store() {
        super();
        storeItems = new ArrayList();
    }
    
    /**
     * Primary constructor
     * @param menuName 
     */
    public Store(String menuName) {
        super(menuName);
        storeItems = new ArrayList();
    }
    
    /**
     * Secondary constructor 
     * @param menuName
     * @param storeItems 
     */
    public Store(String menuName, ArrayList<Sprite> storeItems) {
        this(menuName);
        this.storeItems = (ArrayList<Sprite>) storeItems.clone();
    }
    
    /**
     * Primary accessor for the storeItems attribute
     * @return 
     */
    public ArrayList<Sprite> getStoreItems() {
        return storeItems;
    }
    
    public int getSpecificCost(int index) {
        
        return storeItems.get(index).getCostToPurchase();
        
    }
    
    /**
     * Secondary accessor for the sprite image
     * @param storeIndex - The index of the sprite
     * @return the image icon of the sprite
     */
    public ImageIcon getImage(int storeIndex) {
        return storeItems.get(storeIndex).getSpriteCharacter();
    }
    
    public Sprite getSpecificStoreItem(int itemIndex) {
        return storeItems.get(itemIndex);
    }
    
    /**
     * Primary mutator for the storeItems attribute
     * @param storeItems 
     */
    public void setStoreItems(ArrayList<Sprite> storeItems) {
        this.storeItems = storeItems;
    }
   
    /**
     * Secondary mutator for the storeItems attribute
     * @param storeIndex
     * @param newStoreItem 
     */
    public void setSpecificStoreItems(int storeIndex, Sprite newStoreItem) {
        storeItems.set(storeIndex, newStoreItem);
    }
    
    /**
     * Tertiary mutator for the storeItems attribute
     * @param newStoreItem 
     */
    public void addStoreItem(Sprite newStoreItem) {
        storeItems.add(newStoreItem);
    }
    
    // todo: add more comments to the methods involved in sorting
    
    /**
     * Implements the Merge Sort Algorithm for Store items
     */
    public void sortStoreItems() {
        // if the array is empty or has one element, it is sorted
        if (storeItems.size() <= 1) {
            return;
        }
        // otherwise, split the array in half and sort both halves
        int middle = storeItems.size() / 2;
        ArrayList<Sprite> left = new ArrayList();
        ArrayList<Sprite> right = new ArrayList();
        for (int i = 0; i < middle; i++) {
            left.add(storeItems.get(i));
        }
        for (int i = middle; i < storeItems.size(); i++) {
            right.add(storeItems.get(i));
        }
        sortStoreItemsIntermediate(left);
        sortStoreItemsIntermediate(right);
        // merge the two sorted halves
        mergeStoreItems(left, right);
    }

    /**
     * Merge two sorted halves produced by recursive calls to merge sort
     * @param left 
     * @param right 
     */
    public void mergeStoreItems(ArrayList<Sprite> left, ArrayList<Sprite> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int storeIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getCostToPurchase() < right.get(rightIndex).getCostToPurchase()) {
                storeItems.set(storeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                storeItems.set(storeIndex, right.get(rightIndex));
                rightIndex++;
            }
            storeIndex++;
        }
        // add the remaining elements
        while (leftIndex < left.size()) {
            storeItems.set(storeIndex, left.get(leftIndex));
            leftIndex++;
            storeIndex++;
        }
        while (rightIndex < right.size()) {
            storeItems.set(storeIndex, right.get(rightIndex));
            rightIndex++;
            storeIndex++;
        }
    }

    /**
     * An intermediate sorting algorithm that sorts an array 
     * @param storeItems 
     */
    public void sortStoreItemsIntermediate(ArrayList<Sprite> storeItems) {
        // if the array is empty or has one element, it is sorted
        if (storeItems.size() <= 1) {
            return;
        }
        // otherwise, split the array in half and sort both halves
        int middle = storeItems.size() / 2;
        ArrayList<Sprite> left = new ArrayList();
        ArrayList<Sprite> right = new ArrayList();
        for (int i = 0; i < middle; i++) {
            left.add(storeItems.get(i));
        }
        for (int i = middle; i < storeItems.size(); i++) {
            right.add(storeItems.get(i));
        }
        sortStoreItemsIntermediate(left);
        sortStoreItemsIntermediate(right);
        // merge the two sorted halves
        mergeStoreItems(left, right);
    }  

    /**
     * Make the purchase of the current Sprite
     * @param storeIndex
     * @param buyer
     * @return 
     */
    public boolean makePurchase(int storeIndex, User buyer) {
        Sprite currentSprite = storeItems.get(storeIndex);
        if (buyer.getCurrencyPossessed() < currentSprite.getCostToPurchase()) {
            return false;
        }
        buyer.setCurrencyPossessed(buyer.getCurrencyPossessed() - currentSprite.getCostToPurchase());
        currentSprite.setPuchasedAlready(true);
        return true;
    }
   
    /**
     * Standard Java toString() method 
     */
    @Override
    public String toString() {
        return super.toString() + "Store, " + "storeItems=" + storeItems + '}';
    }
    
    /**
     * Standard Java equals() method 
     * @param otherStore
     */
    public boolean equals(Store otherStore) {
        return super.equals(otherStore) && storeItems.equals(otherStore.getStoreItems());
    }
    
    /**
     * Standard Java clone() method 
     */
    @Override
    public Store clone() {
       Store clonedObj = new Store(getMenuName(), storeItems);
       return clonedObj;
    }
    
    // testing code, remove after testing is over
    public static void main(String[] args) {
        Store testStore = new Store();
        // testing the sorting procedure
        for (int i = 1; i <= 10; i++)
            testStore.addStoreItem(new Sprite(i));
        testStore.sortStoreItems();
        System.out.println(testStore.getStoreItems());
    }
    
}
