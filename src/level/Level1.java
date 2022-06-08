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
       //Platforms
        super.addShapeToLevel(new Shape(200, 240, 480, 500, "N/A", Color.GREEN));   
        super.addShapeToLevel(new Shape(260, 300, 350, 370, "N/A", Color.GREEN));
        super.addShapeToLevel(new Shape(340, 380, 250, 270, "N/A", Color.GREEN));
        super.addShapeToLevel(new Shape(265, 305, 140, 160, "N/A", Color.GREEN));
        super.addShapeToLevel(new Shape(100, 140, 140, 150, "N/A", Color.GREEN));
        
        //Wall
        super.addShapeToLevel(new Shape(380, 390, 0, 510, "N/A", Color.GREEN));
        
    }   
        
}
