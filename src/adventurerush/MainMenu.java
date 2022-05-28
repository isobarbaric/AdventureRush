package adventurerush;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainMenu {
  
    // attributes of a MainMenu object
    private String menuName;
    private JFrame menuContent;
    private ArrayList<ImageIcon> assets;
    private boolean buttonPressed;
    
    /**
     * Default constructor 
     */
    public MainMenu() {
        menuName = new String();
        menuContent = new JFrame();
        assets = new ArrayList();
        buttonPressed = false;
    }
    
    /**
     * Primary constructor
     * @param menuName 
     */
    public MainMenu(String menuName){
        this.menuName = menuName;    
    }
    
    /**
     * Secondary constructor
     * @param menuName
     * @param menuContent 
     */
    public MainMenu(String menuName, JFrame menuContent){
        this(menuName);
        this.menuContent = menuContent;
    }
  
    /**
     * Tertiary constructor
     * @param menuName
     * @param menuContent
     * @param assets 
     */
    public MainMenu(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets){
        this(menuName, menuContent);
        this.assets = assets;
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
    
//    public int loadUserEntry(boolean buttonPressed){
//        
//    }
    
}