package game;

import adventurerush.Menu;
import adventurerush.User;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Store extends Menu {

    // attributes specific to a Store object
    private ArrayList<Sprite> storeItems;

    // constructors 
    
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
     * @param menuContent
     * @param assets 
     */
    public Store(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        super(menuName, menuContent, assets);
        storeItems = new ArrayList();
    }
    
    /**
     * Tertiary constructor
     * @param menuName
     * @param menuContent
     * @param assets
     * @param storeItems 
     */
    public Store(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets, ArrayList<Sprite> storeItems) {
        this(menuName, menuContent, assets);
        this.storeItems = storeItems;
    }
    
    // getters
    
    public ArrayList<Sprite> getStoreItems() {
        return storeItems;
    }
    
    public Sprite getSpecificStoreItem(int storeIndex) {
        return storeItems.get(storeIndex);
    }
    
    // setters
    
    public void setStoreItems(ArrayList<Sprite> storeItems) {
        this.storeItems = storeItems;
    }
    
    public void setSpecificStoreItems(int storeIndex, Sprite newStoreItem) {
        storeItems.set(storeIndex, newStoreItem);
    }
    
    public void addStoreItem(Sprite newStoreItem) {
        storeItems.add(newStoreItem);
    }
    
    // behavior methods
    
    // implement the merge sort algorithm for the store items
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

    // merge the two sorted halves
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

    // allow multiple purchases of same item?
    public boolean makePurchase(int storeIndex, User buyer) {
        Sprite currentSprite = storeItems.get(storeIndex);
        if (buyer.getCurrencyPossessed() < currentSprite.getCostToPurchase()) {
            return false;
        }
        buyer.setCurrencyPossessed(buyer.getCurrencyPossessed() - currentSprite.getCostToPurchase());
        currentSprite.setPuchasedAlready(true);
        return true;
    }
    
    // standard methods

    @Override
    public String toString() {
        return super.toString() + "Store, " + "storeItems=" + storeItems + '}';
    }
    
    public boolean equals(Store otherStore) {
        return super.equals(otherStore) && storeItems.equals(otherStore.getStoreItems());
    }
    
    // fix clone method later
//    public Sprite clone() {
//        Sprite clonedObj = new Sprite(getMenuName(), getMenuContent(), getAssets(), storeItems);
//        return clonedObj;
//    }
    
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