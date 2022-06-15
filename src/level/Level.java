package level;

import assets.ReaderWriter;
import game.LevelSelectWindow;
import game.Sprite;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import movement.DrawingSurface;
import movement.GameFrame;
import movement.Shape;

public abstract class Level {

    // declaring the attributes
    private LevelSelectWindow previousWindow;
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private double height, width;
    private int begX, begY, levelNumber;
    private Sprite currentSprite;
    private ReaderWriter IOHandler;
    private boolean levelCompleted;
    
    // declaring the static attributes
    private static Color platformColor, lavaColor, doorColor;
    public static int numCoinsAssociated = 15;

    
    // a static-block for safe initialization
    static {
        numCoinsAssociated = 15;
    }

    // constructors
    
    /**
     * Primary Constructor
     * @param previousWindow - The previous window
     * @param currentSprite - The sprite object containing the current sprite
     * @param levelNumber - The level number
     * @param begX - The beginning x coordinate
     * @param begY - The beginning y coordinate
     * @param levelCompleted - The number of levels completed
     */
    public Level(LevelSelectWindow previousWindow, Sprite currentSprite, int levelNumber, int begX, int begY, boolean levelCompleted) {
        // initializing previousWindow
        this.previousWindow = previousWindow;
        
        // initializing currentLevel
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber, begX, begY);

        // calling the setCurrentLevel setter on the GameFrame object just created
        currentLevel.setCurrentLevel(this);
        
        // initializing levelCompleted
        this.levelCompleted = levelCompleted;

        // initializing begX
        this.begX = begX;

        // initializing begY
        this.begY = begY;

        // initializing currentSprite
        this.currentSprite = currentSprite;

        // initializing levelNumber
        this.levelNumber = levelNumber;

        // initializing drawingWithGameFrame with a call to a getter on the GameFrame object created earlier
        drawingWithGameFrame = currentLevel.getCurrentFrame();

        // initializing drawingWithGameFrame with a call to a getter on the GameFrame object created earlier
        drawingWithGameFrame.setOuterAttribute(this);

        // initializing currentLevelShapes
        currentLevelShapes = new ArrayList();

        // initializing height
        height = this.currentLevel.getFrameHeight();
        
        // initializing width
        width = this.currentLevel.getFrameWidth();

        // initializing platformColor
        platformColor = drawingWithGameFrame.getPlatformColor();

        // initializing lavaColor
        lavaColor = drawingWithGameFrame.getLavaColor();

        // initializing doorColor
        doorColor = drawingWithGameFrame.getDoorColor();

        // initializing IOHandler
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");

        // calling the addShapesToDrawing method to add the shapes of 
        addShapesToDrawing();
    }

    // creating an abstract method for each Level object to overload according to the shapes involved in it
    abstract void processShapesForAddition();

    // getters and setters
    
    /**
     * Accessor for the platform colour
     * @return the colour of the platform
     */
    public Color getPlatformColor() {
        return platformColor;
    }

    /**
     * Accessor for the lava colour
     * @return the colour of the lava
     */
    public Color getLavaColor() {
        return lavaColor;
    }

    /**
     * Accessor for the door colour
     * @return the colour of the door
     */
    public Color getDoorColor() {
        return doorColor;
    }

    /**
     * Accessor for the number of levels completed
     * @return the number of levels completed
     */
    public boolean getLevelCompleted() {
        return levelCompleted;
    }

    /**
     * Accessor for the previous window
     * @return the previous window
     */
    public LevelSelectWindow getPreviousWindow() {
        return previousWindow;
    }

    /**
     * Accessor for the current sprite
     * @return the current sprite
     */
    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    /**
     * Mutator for the current sprite
     * @param newSprite - The given sprite
     */
    public void setCurrentSprite(Sprite newSprite) {
        currentSprite = newSprite;
    }
        /**
     * Accessor for the game frame
     * @return the game frame
     */
    public GameFrame getGameFrame() {
        return currentLevel;
    }

    /**
     * Accessor for the shapes in the level
     * @return the shapes in the level
     */
    public ArrayList<Shape> getCurrentLevelShapes() {
        return currentLevelShapes;
    }

    /**
     * Mutator for the shapes. Adds a given shape to the level
     * @param currentShape - The given shapes
     */
    public void addShapeToLevel(Shape currentShape) {
        currentLevelShapes.add(currentShape);
    }

    /**
     * Accessor for the JFrame height
     * @return the height
     */
    public double getGameFrameHeight() {
        return height;
    }

    /**
     * Accessor for the JFrame width
     * @return the width
     */
    public double getGameFrameWidth() {
        return width;
    }

    /**
     * Mutator for the number of levels completed
     * @param levelCompleted - The number of levels completed
     */
    public void setLevelCompleted(boolean levelCompleted) {
        this.levelCompleted = levelCompleted;
    }
    
    
    // behavior methods
    
    public void endCurrentLevel() {
        // if the current level 
        if (levelCompleted) {
            
            // returning as this method is not to be run if the current level has already ended
            return;
        }

        // stops the music as the music being played is over
        previousWindow.stop();

        // declare and initialize a variable to keep track of the user's current number of coins
        int currentUserBalance = previousWindow.getPreviousWindow().getCurrentUser().getCurrencyPossessed();

        // increment this number with the same standard number of points assigned to each level
        previousWindow.getPreviousWindow().getCurrentUser().setCurrencyPossessed(currentUserBalance + Level1.numCoinsAssociated);

        // updating the currency count in the data file
        IOHandler.replaceLine(previousWindow.getPreviousWindow().getCurrentUser().getCurrentFileLine() - 1, Integer.toString(previousWindow.getPreviousWindow().getCurrentUser().getCurrencyPossessed()));        

        // sets the level completed to true
        levelCompleted = true; 

        // closes the JFrame
        currentLevel.closeFrame(); 

        // captures the current location of the currentWindow
        final Rectangle bounds = previousWindow.getBounds();

        // setting the location of the previousWindow to the location of the current Level object
        previousWindow.setLocation(bounds.x, bounds.y);
        
        // setting the previousWindow to be visible
        previousWindow.setVisible(true);
    }

     /**
     * Sets the JFrame to visible
     * @param visible - A boolean, true if it's visible and false if it isn't
     */
    public void setGameFrameVisible(boolean visible) {
        // if the JFrame is visible
        if (visible) {
            currentLevel.loadFrame(); //Loads the frame
        } else { // if the JFrame isn't visible
            currentLevel.closeFrame(); //Closes the JFrame
        }
    }

    /**
     * Mutator for the game frame location
     * @param bounds - the boundries for the rectangle
     */
    public void setGameFrameLocation(Rectangle bounds) {
        currentLevel.setLocation(bounds.x, bounds.y);
    }

    /**
     * Adds the shapes to draw
     */
    private void addShapesToDrawing() {
        // calling the abstract method
        processShapesForAddition();
        
        // loops through the shapes and adds them ot
        for (int i = 0; i < currentLevelShapes.size(); i++) {
            
            // adding the current shape to the appropriate surface
            drawingWithGameFrame.addShape(currentLevelShapes.get(i));
        }
    }

    /**
     * Ends the level without performing the necessary steps for ending a current level by beating it
     */
    public void escapeLevel() {
        // stops the music as the music being played is over
        previousWindow.stop();

        // closes the JFrame
        currentLevel.closeFrame(); 

        // open main menu again
        previousWindow.setVisible(true);
    }
    
}
