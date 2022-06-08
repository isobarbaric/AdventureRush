package level;

import game.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import movement.Shape;

public class Level3 extends Level {

    private ArrayList<Shape> currentLevelShapes;
    
    public Level3(Sprite currentSprite, int levelNumber) {
        super(currentSprite, levelNumber);
    }

    @Override
    void processShapesForAddition() {
        if (currentLevelShapes == null) {
            currentLevelShapes = super.getCurrentLevelShapes();
        }
    }
        
}