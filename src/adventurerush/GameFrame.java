package adventurerush;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GameFrame {

    private Sprite userCharacter;
    private JFrame helperMenu;
    private JFrame gameDisplay;

    public GameFrame(JFrame gameDisplay) {
        gameDisplay = new JFrame();
        userCharacter = new Sprite();
        helperMenu = new JFrame();
        this.gameDisplay = gameDisplay;
    }

    public GameFrame(JFrame gameDisplay, Sprite userCharacter) {
        this(gameDisplay);
        this.userCharacter = userCharacter;
    }

    public GameFrame(JFrame gameDisplay, Sprite userCharacter, JFrame helperMenu) {
        this(gameDisplay, userCharacter);
        this.helperMenu = helperMenu;
    }

    public void setGameDisplay(JFrame gameDisplay) {
        this.gameDisplay = gameDisplay;
    }

    public void setUserCharacter(Sprite userCharacter) {
        this.userCharacter = userCharacter;
    }

    public void setHelperMenu(JFrame helperMenu){
        this.helperMenu = helperMenu;
    }
    
    public JFrame getGameDisplay(){
        return gameDisplay;
    }

    public Sprite getUserCharacter(){
        return userCharacter;
    }
    
    public JFrame getHelperMenu(){
        return helperMenu;
    }
    
    public void loadGameScreen(){
        
    }
    
}
