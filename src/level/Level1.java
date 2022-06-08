package level;

import game.Sprite;
import java.awt.Color;
import movement.Shape;

public class Level1 extends Level {

    public Level1(Sprite currentSprite) {
        super(currentSprite, 1);
    }

    @Override
    void processShapesForAddition() {
        super.addShapeToLevel(new Shape(800, 600, 600, 800, "N/A", Color.BLUE));   
        super.addShapeToLevel(new Shape(200, 400, 400, 600, "N/A", Color.GREEN));
    }
        
}