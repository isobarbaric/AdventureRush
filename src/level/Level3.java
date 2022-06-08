package level;

import game.Sprite;
import java.awt.Color;
import movement.Shape;

public class Level3 extends Level {

    private int windowHeight, windowWidth;
    
    public Level3(Sprite currentSprite) {
        super(currentSprite, 3);
        windowHeight = super.getGameFrameHeight();
        windowWidth = super.getGameFrameWidth();
    }
    
    @Override
    void processShapesForAddition() {
        super.addShapeToLevel(new Shape(800, 600, 600, 800, "N/A", Color.BLUE));   
        super.addShapeToLevel(new Shape(200, 400, 400, 600, "N/A", Color.GREEN));
    }   

        
}