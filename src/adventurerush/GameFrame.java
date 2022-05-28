package adventurerush;

import javax.swing.JFrame;

public class GameFrame {

    // attributes for a GameFrame object
    private Sprite userCharacter;
    private JFrame helperMenu;
    private JFrame gameDisplay;

    /**
     * Default constructor 
     */
    public GameFrame() {
       userCharacter = new Sprite();
       helperMenu = new JFrame();
       gameDisplay = new JFrame();
    }
    
    /**
     * Primary constructor
     * @param gameDisplay 
     */
    public GameFrame(JFrame gameDisplay) {
        this();
        this.gameDisplay = gameDisplay;
    }

    /**
     * Secondary constructor
     * @param gameDisplay
     * @param userCharacter 
     */
    public GameFrame(JFrame gameDisplay, Sprite userCharacter) {
        this(gameDisplay);
        this.userCharacter = userCharacter;
    }
    
    /**
     * Tertiary constructor
     * @param gameDisplay
     * @param userCharacter
     * @param helperMenu 
     */
    public GameFrame(JFrame gameDisplay, Sprite userCharacter, JFrame helperMenu) {
        this(gameDisplay, userCharacter);
        this.helperMenu = helperMenu;
    }

    /**
     * Setter for the gameDisplay attribute 
     * @param gameDisplay 
     */
    public void setGameDisplay(JFrame gameDisplay) {
        this.gameDisplay = gameDisplay;
    }

    /**
     * Setter for the userCharacter attribute
     * @param userCharacter 
     */
    public void setUserCharacter(Sprite userCharacter) {
        this.userCharacter = userCharacter;
    }

    /**
     * Setter for the helperMenu attribute
     * @param helperMenu 
     */
    public void setHelperMenu(JFrame helperMenu){
        this.helperMenu = helperMenu;
    }
    
    /**
     * Getter for the gameDisplay attribute
     * @return 
     */
    public JFrame getGameDisplay(){
        return gameDisplay;
    }

    /**
     * Getter for the userCharacter attribute
     * @return 
     */
    public Sprite getUserCharacter(){
        return userCharacter;
    }
    
    /**
     * Getter for the helperMenu attribute 
     * @return 
     */
    public JFrame getHelperMenu(){
        return helperMenu;
    }
    
    /**
     * Loads the gameDisplay JFrame
     * @param otherWindow 
     */
    public void loadGameScreen(JFrame otherWindow){
        otherWindow.setVisible(false);
        gameDisplay.setVisible(true);
    }
    
    /**
     * Loads the helperMenu JFrame
     */
    public void loadHelperScreen() {
        gameDisplay.setVisible(false);
        helperMenu.setVisible(true);
    }
    
}
