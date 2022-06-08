package level1;

import game.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import movement.DrawingSurface;
import movement.GameFrame;
import movement.Shape;

public class Level1Window {
    
    private GameFrame currentLevel;
    private DrawingSurface drawingWithGameFrame;
    private ArrayList<Shape> currentLevelShapes;
    private int height, width;
    // need to subtract sprite radius from height and with to get a proper 
    
    public Level1Window(Sprite currentSprite, int levelNumber) {
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
            System.out.println("sprite: " + drawingWithGameFrame.getSpriteBuffer());
        } else {
            currentLevel.closeFrame();
        }
    }

    private void processShapesForAddition() {
        // currentLevelShapes.add(new Shape(0, width, 0, height, "", Color.GREEN));
        currentLevelShapes.add(new Shape(0, 100, 600, 800, "", Color.BLUE));   
        // currentLevelShapes.add(new Shape(0, width, height-100, height, "", Color.GREEN));
    }
    
    private void addShapesToDrawing() {
        processShapesForAddition();
        for (int i = 0; i < currentLevelShapes.size(); i++) {
            drawingWithGameFrame.addShape(currentLevelShapes.get(i));
        }
    }
    
}