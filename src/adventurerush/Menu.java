package adventurerush;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public abstract class Menu {

    // attributes of a Menu object
    private String menuName;
    private JFrame menuContent;
    private ArrayList<ImageIcon> assets;

    // constructors 

    /**
     * Default constructor
     */
    public Menu() {
        menuName = new String();
        menuContent = new JFrame();
        assets = new ArrayList<>();
    }
 
    /**
     * Primary constructor
     * @param menuName name of the Menu object
     */
    public Menu(String menuName) {
        this(); 
        this.menuName = menuName;
    }

    /**
     * Secondary constructor
     * @param menuName name of the Menu object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     */
    public Menu(String menuName, JFrame menuContent) {
        this(menuName);
        this.menuContent = menuContent;
    }

    /**
     * Tertiary constructor
     * @param menuName name of the Menu object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     * @param assets an ArrayList containing the images to be used in displaying this Menu
     */
    public Menu(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        this(menuName, menuContent);
        this.assets = assets;
    }

    // getters

    /**
     * Getter for the name of the Menu object
     * @return the name of the Menu object
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Getter for the JFrame containing the graphical content of the Menu object
     * @return the JFrame containing the graphical content of the Menu object
     */
    public JFrame getMenuContent() {
        return menuContent;
    }

    /**
     * Getter for the ArrayList containing the images to be used in displaying this Menu
     * @return the ArrayList containing the images to be used in displaying this Menu
     */ 
    public ArrayList<ImageIcon> getAssets() {
        return assets;
    }

    /**
     * Alternate getter for the ArrayList containing the images to be used in displaying this Menu
     * @param index the index of the image to be returned
     * @return image at the index in the ArrayList
     * */
    public ImageIcon getAssets(int index) {
        return assets.get(index);
    }

    // setters
    
    /**
     * Setter for the name of the Menu object
     * @param menuName the name of the Menu object
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * Setter for the JFrame containing the graphical content of the Menu object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     */
    public void setMenuContent(JFrame menuContent) {
        this.menuContent = menuContent;
    }

    /**
     * Setter for the ArrayList containing the images to be used in displaying this Menu
     * @param assets the ArrayList containing the images to be used in displaying this Menu
     */
    public void setAssets(ArrayList<ImageIcon> assets) {
        this.assets = assets;
    }

    /**
     * Alternate setter for the ArrayList containing the images to be used in displaying this Menu:w
     * @param asset the image to be added to the ArrayList containing the images to be used in displaying this Menu
     */
    public void addAsset(ImageIcon asset) {
        assets.add(asset);
    }

    // standard methods

    /**
     * Standard Java toString() methods
     * @return toDisplay a string containing information about the current Menu object
     */
    public String toString() {
        String toDisplay = "Menu Name: " + menuName + ", Menu Type: ";
        return toDisplay;
    }
    
    /**
     * Standard Java equals() method
     * @param otherMenu the object to be compared to the current Menu object
     * @return true if the current Menu object is equal to the Menu object passed as a parameter
     */
    protected boolean equals(Menu otherMenu) {
        return menuName.equals(otherMenu.getMenuName()) && menuContent.equals(otherMenu.getMenuContent()) && assets.equals(otherMenu.getAssets());
    }
    
    // add in abstract class down below

}
