package level;

import game.Sprite;
import java.util.ArrayList;
import movement.DrawingSurface;
import movement.GameFrame;
import movement.Shape;

public abstract class LevelWindow {
    
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private int height, width;
    // need to subtract sprite radius from height and width
    // -> works for width, height is still incorrect
    
    public LevelWindow(Sprite currentSprite, int levelNumber) {
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber);
        this.drawingWithGameFrame = currentLevel.getCurrentFrame();    
        currentLevelShapes = new ArrayList();
        System.out.println("initialized araylist");
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

}