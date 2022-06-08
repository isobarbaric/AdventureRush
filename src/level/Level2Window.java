package level;

import game.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import movement.Shape;

public class Level2Window extends LevelWindow {

    private ArrayList<Shape> currentLevelShapes;
    
    public Level2Window(Sprite currentSprite, int levelNumber) {
        super(currentSprite, levelNumber);
    }

    @Override
    void processShapesForAddition() {
        if (currentLevelShapes == null) {
            currentLevelShapes = super.getCurrentLevelShapes();
        }
        // currentLevelShapes.add(new Shape(0, width, 0, height, "N/A", Color.GREEN));
        currentLevelShapes.add(new Shape(800, 600, 600, 800, "N/A", Color.BLUE));   
        // currentLevelShapes.add(new Shape(0, width, height-100, height, "N/A", Color.GREEN));
    }
        
}