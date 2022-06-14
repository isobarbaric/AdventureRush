package game;

public class HelperMenu extends Menu {

    // attributes of a HelperMenu object
    private String textToBeDisplayed;
    
    // constructors
    
    /**
     * Default constructor
     */
    public HelperMenu() {
        textToBeDisplayed = new String();
    }
    
    /**
     * Primary constructor
     * @param textToBeDisplayed the text to be displayed
     */
    public HelperMenu(String textToBeDisplayed) {
        this();
    }

    // getters
    
    /**
     * Accessor for the textToBeDisplayed attribute
     * @return the text to be displayed
     */
    public String getTextToBeDisplayed() {
        return textToBeDisplayed;
    }
    
    // setters

    /**
     * Mutator for the textToBeDisplayed attribute
     * @param textToBeDisplayed the text to be displayed
     */
    public void setTextToBeDisplayed(String textToBeDisplayed) {
        this.textToBeDisplayed = textToBeDisplayed;
    }
    
    // standard methods
    
    /**
     * Standard Java toString() method
     * @return a String containing information about the HelperMenu object
     */
    @Override
    public String toString() {
        return "HelperMenu: " + textToBeDisplayed;
    }
        
    /**
     * Standard Java equals() method
     * @param otherHelperMenu the other HelperMenu object being compared to
     * @return whether the two HelperMenu objects are identical or not
     */
    public boolean equals(HelperMenu otherHelperMenu) {
        return textToBeDisplayed.equals(otherHelperMenu.getTextToBeDisplayed());
    }
    
    /**
     * Standard Java clone() method
     * @return a new HelperMenu object that is a clone of the current HelperMenu object
     */
    @Override
    public HelperMenu clone() {
        return new HelperMenu(textToBeDisplayed);
    }
    
}