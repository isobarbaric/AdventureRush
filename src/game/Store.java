package game;

import assets.ReaderWriter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import mainmenu.User;

public class Store extends Menu {

    // attributes specific to a Store object
    private ArrayList<Sprite> storeItems;
    private ReaderWriter IOHandler;

    /**
     * Default constructor
     */
    public Store() {
        super();
        storeItems = new ArrayList();
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    /**
     * Primary constructor
     * @param menuName 
     */
    public Store(String menuName) {
        super(menuName);
        storeItems = new ArrayList();
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    /**
     * Secondary constructor 
     * @param menuName
     * @param storeItems 
     */
    public Store(String menuName, ArrayList<Sprite> storeItems) {
        this(menuName);
        this.storeItems = (ArrayList<Sprite>) storeItems.clone();
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    /**
     * Primary accessor for the storeItems attribute
     * @return 
     */
    public ArrayList<Sprite> getStoreItems() {
        return storeItems;
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
    
    public static String stringManipulator(String currentString, int changeIndex) {
        return currentString.substring(0, changeIndex-1) + "1" + currentString.substring(changeIndex);
    }

    /**
     * Make the purchase of the current Sprite
     * @param storeIndex
     * @param buyer
     * @return 
     */
    public void makePurchase(int storeIndex, User buyer) {
        Sprite currentSprite = storeItems.get(storeIndex);
        buyer.setCurrencyPossessed(buyer.getCurrencyPossessed() - currentSprite.getCostToPurchase());
        buyer.addSprite(currentSprite.clone());
 
        // update content in file 
        String currentSpriteSelection = IOHandler.readSpecificLine(buyer.getCurrentFileLine());
        IOHandler.replaceLine(buyer.getCurrentFileLine(), stringManipulator(currentSpriteSelection, storeIndex+1));
        IOHandler.replaceLine(buyer.getCurrentFileLine()-1, Integer.toString(buyer.getCurrencyPossessed()));        
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
//        Store testStore = new Store();
//        // testing the sorting procedure
//        for (int i = 10; i >= 1; i--)
//            testStore.addStoreItem(new Sprite(i));
//        testStore.sortStoreItems();
//        System.out.println(testStore.getStoreItems());
    }
    
}
