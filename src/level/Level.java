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
    private int height, width;
    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect
    
    public Level(Sprite currentSprite, int levelNumber) {
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber);
        this.drawingWithGameFrame = currentLevel.getCurrentFrame();    
        currentLevelShapes = new ArrayList();
        addShapesToDrawing();
        height = -1;
        width = -1;
    }
    
    // to allow the class to be made visible and invisible when wanted
    public void setGameFrameVisible(boolean visible) {
        if (visible) {
            currentLevel.loadFrame();
            height = (int) (currentLevel.getFrameHeight() - drawingWithGameFrame.getSpriteBuffer());
            width = (int) (currentLevel.getFrameWidth() - drawingWithGameFrame.getSpriteBuffer());
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
    
  
    /**
     * Accessor for the shapes in the level
     * @return an array list containing all the shapes in the level
     */
    public ArrayList<Shape> getCurrentLevelShapes() {
        return currentLevelShapes;
    }
    
    /**
     * Mutator for the shapes
     * @param currentShape - The given shape
     */
    public void addShapeToLevel(Shape currentShape) {
        currentLevelShapes.add(currentShape);
    }

    /**
     * Accessor for the frame height
     * @return the height
     */
    public int getGameFrameHeight() {
        return height;
    }
    
    /**
     * Accessir for the frame width
     * @return the width
     */
    public int getGameFrameWidth() {
        return width;
    }
    
}