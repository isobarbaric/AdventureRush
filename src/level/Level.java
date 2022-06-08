package level;

import game.Sprite;
import java.awt.Rectangle;
import java.util.ArrayList;
import movement.DrawingSurface;
import movement.GameFrame;
import movement.Shape;

public abstract class Level {
    
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private double height, width;
    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect
    
    public Level(Sprite currentSprite, int levelNumber) {
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber);
        this.drawingWithGameFrame = currentLevel.getCurrentFrame();    
        currentLevelShapes = new ArrayList();
        height = this.currentLevel.getFrameHeight();
        width = this.currentLevel.getFrameWidth();
        addShapesToDrawing();
    }
    
    // to allow the class to be made visible and invisible when wanted
    public void setGameFrameVisible(boolean visible) {
        if (visible) {
            currentLevel.loadFrame();
            System.out.println("width = " + width + ", height =  " + height);
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
    
}