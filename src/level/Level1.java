package level;

import game.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import movement.Shape;

public class Level1 extends Level {

    private ArrayList<Shape> currentLevelShapes;
    
    public Level1(Sprite currentSprite, int levelNumber) {
        super(currentSprite, levelNumber);
    }

    @Override
    void processShapesForAddition() {
        if (currentLevelShapes == null) {
            currentLevelShapes = super.getCurrentLevelShapes();
        }
        currentLevelShapes.add(new Shape(800, 600, 600, 800, "N/A", Color.BLUE));   
        currentLevelShapes.add(new Shape(200, 400, 400, 600, "N/A", Color.GREEN));
    }
        
}