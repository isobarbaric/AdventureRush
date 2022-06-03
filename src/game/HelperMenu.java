package game;

import adventurerush.Menu;

public class HelperMenu extends Menu { // extends Menu

    // attributes of a HelperMenu object
    private String textToBeDisplayed;
    
    /**
     * Default constructor
     */
    public HelperMenu() {
        textToBeDisplayed = new String();
    }
    
    /**
     * Primary constructor
     * @param textToBeDisplayed 
     */
    public HelperMenu(String textToBeDisplayed) {
        this();
    }

    /**
     * Accessor for the textToBeDisplayed attribute
     * @return 
     */
    public String getTextToBeDisplayed() {
        return textToBeDisplayed;
    }

    /**
     * Mutator for the textToBeDisplayed attribute
     * @param textToBeDisplayed 
     */
    public void setTextToBeDisplayed(String textToBeDisplayed) {
        this.textToBeDisplayed = textToBeDisplayed;
    }
    
    /**
     * Standard Java equals() method
     * @param otherHelperMenu
     * @return 
     */
    public boolean equals(HelperMenu otherHelperMenu) {
        return textToBeDisplayed.equals(otherHelperMenu.getTextToBeDisplayed());
    }
    
    /**
     * Standard Java toString() method
     * @return 
     */
    @Override
    public String toString() {
        return "HelperMenu: " + textToBeDisplayed;
    }
    
    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public HelperMenu clone() {
        HelperMenu clonedObj = new HelperMenu(textToBeDisplayed);
        return clonedObj;
    }
    
}