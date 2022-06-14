package game;

public abstract class Menu {

    // attributes of a Menu object
    private String menuName;

    // constructors 

    /**
     * Default constructor
     */
    public Menu() {
        menuName = new String();
    }
 
    /**
     * Primary constructor
     * @param menuName name of the Menu object
     */
    public Menu(String menuName) {
        // chaining of constructors
        this(); 
        this.menuName = menuName;
    }

    // getters

    /**
     * Getter for the name of the Menu object
     * @return the name of the Menu object
     */
    public String getMenuName() {
        return menuName;
    }

    // setters
    
    /**
     * Setter for the name of the Menu object
     * @param menuName the name of the Menu object
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    // standard methods

    /**
     * Standard Java toString() methods
     * @return toDisplay a string containing information about the current Menu object
     */
    public String toString() {
        return "Menu Name: " + menuName + ", Menu Type: ";
    }
    
    /**
     * Standard Java equals() method
     * @param otherMenu the object to be compared to the current Menu object
     * @return true if the current Menu object is equal to the Menu object passed as a parameter
     */
    protected boolean equals(Menu otherMenu) {
        return menuName.equals(otherMenu.getMenuName());
    }
    
  }
