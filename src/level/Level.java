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

    private LevelSelectWindow previousWindow;
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private double height, width;
    private int begX, begY, levelNumber;
    private Sprite currentSprite;

    private static Color platformColor, lavaColor, doorColor;
    public static int numCoinsAssociated = 15;

    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect
    private boolean levelCompleted;
    
    static {
        numCoinsAssociated = 15;
    }

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

    public Color getPlatformColor() {
        return platformColor;
    }

    public Color getLavaColor() {
        return lavaColor;
    }

    public Color getDoorColor() {
        return doorColor;
    }

    public boolean getLevelCompleted() {
        return levelCompleted;
    }

    public LevelSelectWindow getPreviousWindow() {
        return previousWindow;
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(Sprite newSprite) {
        currentSprite = newSprite;
    }

    /**
     * Accessor for the numCoinsAssociated
     * @return the number of numCoinsAssociated
     */
    public int getNumCoinsAssociated() {
        return numCoinsAssociated;
    }

    /**
     * Mutator for the numCoinsAssociated
     * @param numCoinsAssociated - The given amount of numCoinsAssociated
     */
    public void setNumCoinsAssociated(int numCoinsAssociated) {
        this.numCoinsAssociated = numCoinsAssociated;
    }

    public void loadLevelMenu() {
        levelCompleted = true;
        currentLevel.closeFrame();
        final Rectangle bounds = previousWindow.getBounds();
        previousWindow.dispose();
        previousWindow = new LevelSelectWindow(previousWindow.getMainMenuWindow());
        previousWindow.setLocation(bounds.x, bounds.y);
        previousWindow.setVisible(true);
    }

    // to allow the class to be made visible and invisible when wanted
    public void setGameFrameVisible(boolean visible) {
        if (visible) {
            currentLevel.loadFrame();
        } else {
            currentLevel.closeFrame();
        }
    }

    public void setGameFrameLocation(Rectangle bounds) {
        currentLevel.setLocation(bounds.x, bounds.y);
    }

    private void addShapesToDrawing() {
        processShapesForAddition();
        for (int i = 0; i < currentLevelShapes.size(); i++) {
            drawingWithGameFrame.addShape(currentLevelShapes.get(i));
        }
    }

    // getters and setters
    public GameFrame getGameFrame() {
        return currentLevel;
    }

    public ArrayList<Shape> getCurrentLevelShapes() {
        return currentLevelShapes;
    }

    public void addShapeToLevel(Shape currentShape) {
        currentLevelShapes.add(currentShape);
    }

    public double getGameFrameHeight() {
        return height;
    }

    public double getGameFrameWidth() {
        return width;
    }

    public void setLevelCompleted(boolean levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

}
