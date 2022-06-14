package mainmenu;

import game.Menu;

public class MainMenu extends Menu {
  
    // attributes of a MainMenu object
    private boolean buttonPressed;
    
    /**
     * Default constructor 
     */
    public MainMenu() {
        buttonPressed = false;
    }
    
    /**
     * Tertiary constructor
     * @param buttonPressed whether the button is pressed or not
     */
    public MainMenu(boolean buttonPressed){
        this.buttonPressed = buttonPressed;
    }
     
    /**
     * Getter for the buttonPressed attribute
     * @return whether the button is pressed or not
     */
    public boolean getButtonPressed(){
        return buttonPressed;
    }
   
    /**
     * Setter for the buttonPressed attribute
     * @param buttonPressed whether the button is pressed or not
     */
    public void setButtonPressed(boolean buttonPressed){
        this.buttonPressed = buttonPressed;
    }
    
}