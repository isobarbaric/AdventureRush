package adventurerush;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public abstract class Menu {

    private String menuName;
    private JFrame menuContent;
    private ArrayList<ImageIcon> assets;

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    public Menu(String menuName, JFrame menuContent) {
        this.menuContent = menuContent;
    }

    public Menu(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        this.assets = assets;
    }

    //Getters
    public String getMenuName() {
        return menuName;
    }

    public JFrame getmenucontent() {
        return menuContent;
    }

    public ArrayList<ImageIcon> getAssets() {
        return assets;
    }

    public ImageIcon getSpecificAsset(int assetIndex) {

    }

    //Setters
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuContent(JFrame menuContent) {
        this.menuContent = menuContent;
    }

    public void setAssets(ArrayList<ImageIcon> assets) {
        this.assets = assets;
    }

    public void setSpecificAsset(int assetIndex, ImageIcon newAsset){
        
    }

    //behaviors
    public abstract void loadMenuFunctionality();
    
    public void quitMenu(){
        
    }
        
    //standard methods
    public String toString(){
        String phase = "";
        return phase;
    }
    
    public boolean equals(Menu otherMenu){
        
    }
    
    public Sprite clone(){
        
    }
}

