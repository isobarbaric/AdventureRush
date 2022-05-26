package adventurerush;

import java.util.ArrayList;

public class MainMenu {
  
    private String menuName;
    private JFrame menuContent;
    private ArrayList<ImageIcon> assets;
    private boolean buttonPressed;
    
    
    public MainMenu(String menuName){
        this.menuName = menuName;
        
    }
    
    public MainMenu(String menuName, JFrame menuContent){
        this(menuName);
        this.menuContent = menuContent;
    }
  
    public MainMenu(String menuName, JFrame menuContent, ArrayList<imageIcon> assets){
        this(menuName, menuContent);
        this.assets = assets;
    }
     
    public boolean getButtonPressed(){
        return buttonPressed;
    }
   
    public void setButtonPressed(boolean buttonPressed){
        this.buttonPressed = buttonPressed;
    }
    
    public int loadUserEntry(boolean buttonPressed){
        
    }
    
}
