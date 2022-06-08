package level;

import game.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import movement.Shape;

public class Level2 extends Level {

    private ArrayList<Shape> currentLevelShapes;
    
    public Level2(Sprite currentSprite, int levelNumber) {
        super(currentSprite, levelNumber);
    }

    @Override
    void processShapesForAddition() {
        if (currentLevelShapes == null) {
            currentLevelShapes = super.getCurrentLevelShapes();
        }
    }
        
}