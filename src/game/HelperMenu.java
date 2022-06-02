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
        this.textToBeDisplayed = textToBeDisplayed;
    }

    // getters
    public String getTextToBeDisplayed() {
        return textToBeDisplayed;
    }

    // setters
    public void setTextToBeDisplayed(String textToBeDisplayed) {
        this.textToBeDisplayed = textToBeDisplayed;
    }
    
    // Standard equals() method
    public boolean equals(HelperMenu otherHelperMenu) {
        return textToBeDisplayed.equals(otherHelperMenu.getTextToBeDisplayed());
    }
    
    // Standard Java toString() method
    @Override
    public String toString() {
        return "HelperMenu: " + textToBeDisplayed;
    }
    
    // Standard Java clone() method
    @Override
    public HelperMenu clone() {
        HelperMenu clonedObj = new HelperMenu(textToBeDisplayed);
        return clonedObj;
    }
    
}