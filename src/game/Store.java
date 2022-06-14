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
        // calling the constructor of the superclass
        super();
        storeItems = new ArrayList();
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    /**
     * Primary constructor
     * @param menuName 
     */
    public Store(String menuName) {
        // calling the constructor of the superclass
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
        // calling the constructor of the superclass
        this(menuName);
        this.storeItems = (ArrayList<Sprite>) storeItems.clone();
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    // getters 
    
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
    
    public void sortStoreItems() {
        mergeSort(0, storeItems.size()-1);
    }
    
    /**
     * Performs the merge sort algorithm and sorts all elements within two inclusive pointers using the merge sort algorithm in ascending order
     * @param l - the left pointer for which sorting needs to be done
     * @param r - the right pointer for which sorting needs to be done
     * @return numTimesLooped - the number of times the algorithm loops
     */
    private void mergeSort(int l, int r) {
        // if an invalid state is reached, then return without executing any code
        if (l >= r) {
            return;
        }
        // determine the middle point between the left pointer and right pointer
        int m = (l + r) / 2;
        // call MergeSort on the two halves of the ArrayList to sort both haves 
        mergeSort(l, m);
        mergeSort(m + 1, r);
        // merge the current section of the ArrayList under consideration, namely 'i' in [l, r]
        merge(l, r, m);
    }

    /**
     * Merges two partitions of the array bounded by two pointers (helper function for the merge sort algorithm) in ascending order
     * @param l - the left pointer for which sorting needs to be done
     * @param r - the right pointer for which sorting needs to be done
     * @param m - the middle value between the left and right pointer
     * @return numTimesLooped - the number of times the algorithm loops
     */
    private void merge(int l, int r, int m) {
        // initialized two ArrayLists to track elements in both halves for easy analysis 
        ArrayList<Sprite> firstHalf = new ArrayList<>();
        ArrayList<Sprite> secondHalf = new ArrayList<>();
        // adding both halves of the array to both ArrayLists initialized previously 
        for (int i = l; i <= m; i++) {
            firstHalf.add(storeItems.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            secondHalf.add(storeItems.get(i));
        }
        // initialized and declared a new ArrayList to store the sorted result of the merge of the two halves of the ArrayList 
        ArrayList<Sprite> combined = new ArrayList<>();
        // loop while there are elements in both ArrayLists remaining to be added to the combined ArrayList with two pointers while there are still elements left in either of them 
        for (int i = 0, j = 0; i < firstHalf.size() || j < secondHalf.size(); ) {
            // if all of the elements in the first ArrayList have been added to the combined ArrayList, then simply work upon the second ArrayList
            if (i == firstHalf.size()) {
                // add the element at the 'j'th index in the second ArrayList to the combined list of values    
                combined.add(secondHalf.get(j));
                // increment the 'j' pointer to indicate that the value at the 'j'th pointer in the second ArrayList has been added to the combined ArrayList
                j++;
                // continue statement prevents any code below to execute
                continue;
            }
            // if all of the elements in the second ArrayList have been added to the combined ArrayList, then simply work upon the first ArrayList
            if (j == secondHalf.size()) {
                // add the element at the 'i'th index in the first ArrayList to the combined list of values 
                combined.add(firstHalf.get(i));
                // increment the 'i' pointer to indicate that the value at the 'i'th pointer in the second ArrayList has been added to the combined ArrayList 
                i++;
                // continue statement prevents any code below to execute
                continue;
            }
            // the sorting process differs based on whether the sorting is to be done in ascending order of descending order 
            // the situation in the descending case is identical to the ascending one, just that the conditions are all reversed 
            if (firstHalf.get(i).getCostToPurchase() < secondHalf.get(j).getCostToPurchase()) {
                combined.add(firstHalf.get(i));
                i++;
            } else {
                combined.add(secondHalf.get(j));
                j++;
            }
        }
        // based on the results of the sorting and the elements added to the combined ArrayList, perform the necessary changes to the local copy of the array under consideration, i.e. localArray
        for (int i = l, ptr = 0; i <= r; i++, ptr++) {
            storeItems.set(i, combined.get(ptr));
        }
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
        boolean firstReplacement = IOHandler.replaceLine(buyer.getCurrentFileLine(), stringManipulator(currentSpriteSelection, storeIndex+1));
        boolean secondReplacement = IOHandler.replaceLine(buyer.getCurrentFileLine()-1, Integer.toString(buyer.getCurrencyPossessed()));  
        assert(firstReplacement && secondReplacement);
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
//    public static void main(String[] args) {
//        Store testStore = new Store();
//        // testing the sorting procedure
//        int max = 50, min = 10;
//        for (int i = 10; i >= 1; i--)
//            testStore.addStoreItem(new Sprite((int) (Math.floor(Math.random()*(max-min+1)+min))));
//        testStore.sortStoreItems();
//        System.out.println(testStore.getStoreItems());
//    }
    
}
