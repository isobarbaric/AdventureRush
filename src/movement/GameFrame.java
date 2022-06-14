package movement;

import game.Sprite;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import level.Level;

public class GameFrame extends JFrame {

    // declaring the attributes
    private int gameLevelNumber;
    private DrawingSurface currentFrame;
    private int frameHeight, frameWidth;
    private Level currentLevel;

    // constructors
    
    /**
     * Primary Constructor
     * @param currentSprite - The current sprite
     * @param gameLevelNumber - The game level number
     * @param begX - The beginning x value
     * @param begY - The beginning y value
     */
    public GameFrame(Sprite currentSprite, int gameLevelNumber, int begX, int begY) {
        // initializing gameLevelNumber
        this.gameLevelNumber = gameLevelNumber;
        // initializing currentFrame
        this.currentFrame = new DrawingSurface(currentSprite, begX, begY);
        // initializing frameWidth
        frameWidth = 900;
        // initializing frameHeight
        frameHeight = 562;
        // adding a KeyListener to the currentFrame to help exit the frame when escape is pressed
        currentFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // if the current key is pressed
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    // stop functionality associated with current level
                    currentLevel.getPreviousWindow().stop();
                    // load the level menu after the current 
                    currentLevel.loadLevelMenu();
                }
            }
        });
    }

    // getters
    
    /**
     * Accessor for the current game level number
     * @return 
     */
    public int getCurrentGameLevelNumber() {
        return gameLevelNumber;
    }

    /**
     * Accessor for the current drawing surface
     * @return the current frame
     */
    public DrawingSurface getCurrentFrame() {
        return currentFrame;
    }

    /**
     * Accessor for the height
     * @return the height
     */
    public int getFrameHeight() {
        return frameHeight;
    }

    /**
     * Accessor for the width
     * @return the frame width
     */
    public int getFrameWidth() {
        return frameWidth;
    }
    
    // setters
    
    /**
     * Mutator for the current game level number
     * @param gameLevelNumber - The given game level number
     */
    public void setCurrentGameLevelNumber(int gameLevelNumber) {
        this.gameLevelNumber = gameLevelNumber;
    }
    
    /**
     * Mutator for the current level
     * @param currentLevel - The current level
     */
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Mutator for the current frame
     * @param currentFrame - The given drawing surface frame
     */
    public void setCurrentFrame(DrawingSurface currentFrame) {
        this.currentFrame = currentFrame;
    }

    /**
     * Mutator for the height
     * @param frameHeight - The given height
     */
    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
    
    /**
     * Mutator for the frame width
     * @param frameWidth - The given width
     */
    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    // behavior methods
    
    /**
     * Loads the frame
     */
    public void loadFrame() {
        // create the User interface
        initUI();
        //Sets the frame to visible
        setVisible(true); 
    }

    /**
     * Closes the frame
     */
    public void closeFrame() {
        //Sets the frame to invisible
        setVisible(false);
    }

    // create the custom JFrame
    private void initUI() {
        // set title of the JFrame
        setTitle("Adventure Rush - Level " + gameLevelNumber);

        // need to add the helper menu to this, or might just leave out if need be
        // add a custom JPanel to draw on
        add(currentFrame);

        // set the size of the window to full screen
        setSize(frameWidth, frameHeight);
        setResizable(false);

        // tell the JFrame what to do when closed
        // this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // standard methods
    
    /**
     * toString for the GameFrame class
     *
     * @return a string containing the GameFrame statistics
     */
    public String toString() {
        return "Level number: " + gameLevelNumber + "\nFrame Height: " + frameHeight + "\nFrame Width: " + frameWidth;
    }
    
}
