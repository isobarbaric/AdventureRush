package movement;

import game.GameLevel;
import game.Sprite;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private Sprite currentSprite;
    private JFrame helperMenu;
    private int gameLevelNumber;
    private ArrayList<Shape> shapes;
    private int height;
    private int width;
    private GameLevel outerGameLevel;
    private boolean key; 
    private Shape door;
   
    

    /**
     * Primary Constructor
     *
     * @param currentSprite - The sprite of the character
     * @param outerGameLevel - The outer game level
     */
    public GameFrame(Sprite currentSprite, GameLevel outerGameLevel) {
        this.currentSprite = currentSprite.clone();
        this.outerGameLevel = outerGameLevel;
        gameLevelNumber = 0;
        height = 0;
        width = 0;

    }

    /**
     * Secondary Constructor - Must have a currentSprite, a helperMenu,
     * gameLevelNumber, outerGameLevel, a height and a width
     *
     * @param currentSprite - The sprite
     * @param helperMenu - The JFrame for the helper menu
     * @param gameLevelNumber - The game level number
     * @param outerGameLevel - The outer game level
     * @param height - The height of the JFrame
     * @param width - the width of the JFrame
     */
    public GameFrame(Sprite currentSprite, JFrame helperMenu, int gameLevelNumber, GameLevel outerGameLevel, int height, int width) {
        this(currentSprite, outerGameLevel); //Primary chaining
        this.helperMenu = helperMenu;
        this.gameLevelNumber = gameLevelNumber;
        this.outerGameLevel = outerGameLevel;
        this.height = height;
        this.width = width;

        // create the User interface
        initUI();
    }

    // todo: add setters and getters
    public void changeToNextWindow() {
        outerGameLevel.switchWindows();
        outerGameLevel.setCurrentFrameNumber(outerGameLevel.getCurrentFrameNumber() + 1);
    }

    // create the custom JFrame
    private void initUI() {
        // set title of the JFrame

        int displayFrame = outerGameLevel.getCurrentFrameNumber() + 1;
        System.out.println(gameLevelNumber + " " + displayFrame);
        setTitle("Adventure Rush - Level " + gameLevelNumber + ", Frame " + displayFrame);

        // need to add the helper menu to this, or might just leave out if need be
        // add a custom JPanel to draw on
        add(new DrawingSurface(currentSprite, this));

        // set the size of the window to full screen
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7));

        // tell the JFrame what to do when closed
        // this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Setter for the currentSPrite attribute
     *
     * @param userCharacter
     */
    public void setUserCharacter(Sprite currentSprite) {
        this.currentSprite = currentSprite;
    }

    /**
     * Setter for the helperMenu attribute
     *
     * @param helperMenu
     */
    public void setHelperMenu(JFrame helperMenu) {
        this.helperMenu = helperMenu;
    }

    /**
     * Mutator for the shape array list. Adds a shape to the array list
     *
     * @param temp - The given shape
     */
    public void setShape(Shape temp) {

        shapes.add(temp);

    }

    /**
     * Getter for the currentSprite attribute
     *
     * @return the current sprite
     */
    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    /**
     * Getter for the helperMenu attribute
     *
     * @return
     */
    public JFrame getHelperMenu() {
        return helperMenu;
    }

    /**
     * Accessor for the shape
     *
     * @param index - The index of the shape for the array list
     * @return
     */
    public Shape getShape(int index) {

        return shapes.get(index);

    }
    
    /**
     * Accessor for the key
     * @return a boolean. True if they have the key and false if they don't
     */
    public boolean getKey() {
        
        return key;
        
    }
    
    /**
     * Mutator for the key
     * @param key a boolean, true if they have the key and false if they don't
     */
    public void setKey(boolean key) {
        
        this.key = key;
        
    }
    
    /**
     * Accessor for the door
     * @return the door
     */
    public Shape getDoor() {
        
        return door;
        
    }
    
    /**
     * Mutator for the door
     * @param door - The given door
     * @return 
     */
    public void setDoor(Shape door) {
        
        this.door = door;
        
    }

    /**
     * Standard Java clone() method
     *
     * @return
     */
    public GameFrame clone() {

        return new GameFrame(currentSprite, helperMenu, gameLevelNumber, outerGameLevel, height, width);
    }

    /**
     * The toString. Returns a string that contains the statistics for the game frame
     *
     * @return a string containing the statistics for the game frame
     */
    public String toString() {

        return "Game level number: " + gameLevelNumber + "\nHeight: " + height + "\nWidth: " + width;

    }

}
