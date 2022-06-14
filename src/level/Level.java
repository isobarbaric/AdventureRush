package level;

import game.LevelSelectWindow;
import game.Sprite;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import movement.DrawingSurface;
import movement.GameFrame;
import movement.Shape;

public abstract class Level {

    //Declaring the attributes
    private LevelSelectWindow previousWindow;
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private double height, width;
    private int begX, begY, levelNumber;
    private Sprite currentSprite;

    //Declaring the static attributes
    private static Color platformColor, lavaColor, doorColor;
    public static int numCoinsAssociated = 15;

    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect
    private boolean levelCompleted;

    static {
        numCoinsAssociated = 15;
    }

    /**
     * Primary Constructor
     *
     * @param previousWindow - The previous window
     * @param currentSprite - The sprite object containing the current sprite
     * @param levelNumber - The level number
     * @param begX - The beginning x coordinate
     * @param begY - The beginning y coordinate
     * @param levelCompleted - The number of levels completed
     */
    public Level(LevelSelectWindow previousWindow, Sprite currentSprite, int levelNumber, int begX, int begY, boolean levelCompleted) {
        this.previousWindow = previousWindow;
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber, begX, begY);
        currentLevel.setCurrentLevel(this);
        this.levelCompleted = levelCompleted;
        this.begX = begX;
        this.begY = begY;
        this.currentSprite = currentSprite;
        this.levelNumber = levelNumber;
        drawingWithGameFrame = currentLevel.getCurrentFrame();
        drawingWithGameFrame.setOuterAttribute(this);
        currentLevelShapes = new ArrayList();
        height = this.currentLevel.getFrameHeight();
        width = this.currentLevel.getFrameWidth();
        platformColor = drawingWithGameFrame.getPlatformColor();
        lavaColor = drawingWithGameFrame.getLavaColor();
        doorColor = drawingWithGameFrame.getDoorColor();
        addShapesToDrawing();
    }

    abstract void processShapesForAddition();

    /**
     * Accessor for the platform colour
     *
     * @return the colour of the platform
     */
    public Color getPlatformColor() {
        return platformColor;
    }

    /**
     * Accessor for the lava colour
     *
     * @return the colour of the lava
     */
    public Color getLavaColor() {
        return lavaColor;
    }

    /**
     * Accessor for the door colour
     *
     * @return the colour of the door
     */
    public Color getDoorColor() {
        return doorColor;
    }

    /**
     * Accessor for the number of levels completed
     *
     * @return the number of levels completed
     */
    public boolean getLevelCompleted() {
        return levelCompleted;
    }

    /**
     * Accessor for the previous window
     *
     * @return the previous window
     */
    public LevelSelectWindow getPreviousWindow() {
        return previousWindow;
    }

    /**
     * Accessor for the current sprite
     *
     * @return the current sprite
     */
    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    /**
     * Mutator for the current sprite
     *
     * @param newSprite - The given sprite
     */
    public void setCurrentSprite(Sprite newSprite) {
        currentSprite = newSprite;
    }

    /**
     * Accessor for the numCoinsAssociated
     *
     * @return the number of numCoinsAssociated
     */
    public int getNumCoinsAssociated() {
        return numCoinsAssociated;
    }

    /**
     * Mutator for the numCoinsAssociated
     *
     * @param numCoinsAssociated - The given amount of numCoinsAssociated
     */
    public void setNumCoinsAssociated(int numCoinsAssociated) {
        this.numCoinsAssociated = numCoinsAssociated;
    }

    /**
     * Loads the menu
     */
    public void loadLevelMenu() {
        levelCompleted = true; //Sets the level completed to true
        currentLevel.closeFrame(); //Closes the JFrame
        final Rectangle bounds = previousWindow.getBounds();
        previousWindow.dispose();
        previousWindow = new LevelSelectWindow(previousWindow.getPreviousWindow());
        previousWindow.setLocation(bounds.x, bounds.y);
        previousWindow.setVisible(true); //Sets the JFrame to visible
    }

     /**
     * Sets the JFrame to visible
     *
     * @param visible - A boolean, true if it's visible and false if it isn't
     */
    public void setGameFrameVisible(boolean visible) {
        
        //If the JFrame is visible
        if (visible) {
            currentLevel.loadFrame(); //Loads the frame

            //If the JFrame isn't visible
        } else {
            currentLevel.closeFrame(); //Closes the JFrame
            
        }
    }

    /**
     * Mutator for the game frame location
     *
     * @param bounds - the boundries for the rectangle
     */
    public void setGameFrameLocation(Rectangle bounds) {
        currentLevel.setLocation(bounds.x, bounds.y);
    }

    /**
     * Adds the shapes to draw
     */
    private void addShapesToDrawing() {
        processShapesForAddition();
        
        //Loops for the number of shapes
        for (int i = 0; i < currentLevelShapes.size(); i++) {
            drawingWithGameFrame.addShape(currentLevelShapes.get(i));
        }
    }

    /**
     * Accessor for the game frame
     *
     * @return the game frame
     */
    public GameFrame getGameFrame() {
        return currentLevel;
    }

    /**
     * Accessor for the shapes in the level
     *
     * @return the shapes in the level
     */
    public ArrayList<Shape> getCurrentLevelShapes() {
        return currentLevelShapes;
    }

    /**
     * Mutator for the shapes. Adds a given shape to the level
     *
     * @param currentShape - The given shapes
     */
    public void addShapeToLevel(Shape currentShape) {
        currentLevelShapes.add(currentShape);
    }

    /**
     * Accessor for the JFrame height
     *
     * @return the height
     */
    public double getGameFrameHeight() {
        return height;
    }

    /**
     * Accessor for the JFrame width
     *
     * @return the width
     */
    public double getGameFrameWidth() {
        return width;
    }

    /**
     * Mutator for the number of levels completed
     *
     * @param levelCompleted - The number of levels completed
     */
    public void setLevelCompleted(boolean levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

}
