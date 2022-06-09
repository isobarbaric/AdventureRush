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
    private int pointsAssociated;
    
    private static Color platformColor, lavaColor, doorColor;

    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect

    private boolean levelCompleted;
    private double exitDoorX, exitDoorY;
    
    public Level(LevelSelectWindow previousWindow, Sprite currentSprite, int levelNumber, int begX, int begY, boolean levelCompleted, int pointsAssociated) {
        this.previousWindow = previousWindow;
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber, begX, begY);
        currentLevel.setCurrentLevel(this);
        this.levelCompleted = levelCompleted;
        this.pointsAssociated = pointsAssociated;
        drawingWithGameFrame = currentLevel.getCurrentFrame();    
        drawingWithGameFrame.setOuterAttribute(this);
        currentLevelShapes = new ArrayList();
        exitDoorX = -1;
        exitDoorY = -1;
        height = this.currentLevel.getFrameHeight();
        width = this.currentLevel.getFrameWidth();
        platformColor = drawingWithGameFrame.getPlatformColor();
        lavaColor = drawingWithGameFrame.getLavaColor();
        doorColor = drawingWithGameFrame.getDoorColor();
        addShapesToDrawing();
    }
    
    public Color getPlatformColor() {
        return platformColor;
    }
    
    public Color getLavaColor() {
        return lavaColor;
    }
    
    public Color getDoorColor() {
        return doorColor;
    }
    
    public int getPointsAssociated() {
        return pointsAssociated;
    }
    
    public boolean getLevelCompleted() {
        return levelCompleted;
    }
    
    public void loadLevelMenu() {
        // sets level completed to true
        levelCompleted = true;
        currentLevel.setVisible(false);
        // MainMenuWindow connectedToPreviousWindow = previousWindow.getMainMenuWindow();
        // previousWindow = new LevelSelectWindow(connectedToPreviousWindow);
        previousWindow.updateButtonColors();
        previousWindow.setVisible(true);
    }
    
    public void setExitDoorX(double exitDoorX) {
        this.exitDoorX = exitDoorX;
    }
    
    public void setExitDoorY(double exitDoorY) {
        this.exitDoorY = exitDoorY; 
    }
    
    public double getExitDoorX() {
        return exitDoorX;
    }
    
    public double getExitDoorY() {
        return exitDoorY;
    }
    
    // to allow the class to be made visible and invisible when wanted
    public void setGameFrameVisible(boolean visible) {
        if (visible) {
            currentLevel.loadFrame();
            // System.out.println("width = " + width + ", height =  " + height); 
        } else {
            currentLevel.closeFrame();
        }
    }
    
    public void setGameFrameLocation(Rectangle bounds) {
        currentLevel.setLocation(bounds.x, bounds.y);
    }

    abstract void processShapesForAddition();
    
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