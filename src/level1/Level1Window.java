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
    
    public Level1Window(Sprite currentSprite, int levelNumber) {
        this.currentLevel = new GameFrame(currentSprite.clone(), levelNumber);
        this.drawingWithGameFrame = currentLevel.getCurrentFrame();    
        currentLevelShapes = new ArrayList();
        addShapesToDrawing();
    }
    
    // to allow the class to be made visible and invisible when wanted
    public void setGameFrameVisible(boolean visible) {
        if (visible) {
            currentLevel.loadFrame();
        } else {
            currentLevel.closeFrame();
        }
    }

    private void processShapesForAddition() {
        currentLevelShapes.add(new Shape(200, 400, 400, 600, "", Color.GREEN));
        currentLevelShapes.add(new Shape(600, 800, 600, 800, "", Color.BLUE));        
    }
    
    private void addShapesToDrawing() {
        processShapesForAddition();
        for (int i = 0; i < currentLevelShapes.size(); i++) {
            drawingWithGameFrame.addShape(currentLevelShapes.get(i));
        }
    }
    
}