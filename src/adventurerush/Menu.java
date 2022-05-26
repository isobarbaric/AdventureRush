package adventurerush;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public abstract class Menu {

    private String menuName;
    private JFrame menuContent;
    private ArrayList<ImageIcon> assets;

    public Menu() {
        menuName = new String();
        menuContent = new JFrame();
        assets = new ArrayList<ImageIcon>();
    }

    public Menu(String menuName) {
        this(); 
        this.menuName = menuName;
    }

    public Menu(String menuName, JFrame menuContent) {
        this(menuName);
        this.menuContent = menuContent;
    }

    public Menu(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        this(menuName, menuContent);
        this.assets = assets;
    }

    //Getters
    public String getMenuName() {
        return menuName;
    }

    public JFrame getMenuContent() {
        return menuContent;
    }

    public ArrayList<ImageIcon> getAssets() {
        return assets;
    }

//    public ImageIcon getSpecificAsset(int assetIndex) {
//
//    }

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
    // public abstract void loadMenuFunctionality();
    
    public void quitMenu(){
        
    }
        
    //standard methods
    
    // public boolean equals(Menu otherMenu){
        
    // }

    // standard Java toString() method
    public String toString() {
        return "menuName=" + menuName + ", menuContent=" + menuContent + ", assets=" + assets;
    }
    
}
