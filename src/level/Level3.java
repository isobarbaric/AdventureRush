package level;

import game.Sprite;
import java.awt.Color;
import movement.Shape;

public class Level3 extends Level {

    private double windowHeight, windowWidth;
    
    public Level3(Sprite currentSprite) {
        super(currentSprite, 3);
    }
    
    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
        super.addShapeToLevel(new Shape(150, windowWidth, windowHeight-100, windowHeight, "N/A", Color.GREEN));   
//        super.addShapeToLevel(new Shape(, , , , "N/A", ));
    }   

}