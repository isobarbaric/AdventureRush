package mainmenu;

import adventurerush.Menu;

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
     * @param buttonPressed
     */
    public MainMenu(boolean buttonPressed){
        this.buttonPressed = buttonPressed;
    }
     
    /**
     * Getter for the buttonPressed attribute
     * @return 
     */
    public boolean getButtonPressed(){
        return buttonPressed;
    }
   
    /**
     * Setter for the buttonPressed attribute
     * @param buttonPressed 
     */
    public void setButtonPressed(boolean buttonPressed){
        this.buttonPressed = buttonPressed;
    }
    
}