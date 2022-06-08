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
       
        // lava 
        super.addShapeToLevel(new Shape(175, windowWidth, windowHeight-100, windowHeight, "N/A", Color.RED));
         
        // platforms between lava
        
        // first green platform 
        super.addShapeToLevel(new Shape(250, 250+50, windowHeight-200, windowHeight-100, "N/A", Color.GREEN));
        super.addShapeToLevel(new Shape(250, 250+50, 0, windowHeight-300, "N/A", Color.GREEN));
        
        // second green platform
        super.addShapeToLevel(new Shape(500, 500+50, windowHeight-300, windowHeight-100, "N/A", Color.GREEN));
        super.addShapeToLevel(new Shape(500, 500+50, 0, windowHeight-400, "N/A", Color.GREEN));

        // third green platform
        super.addShapeToLevel(new Shape(750, 750+50, windowHeight-400, windowHeight-100, "N/A", Color.GREEN)); 
        super.addShapeToLevel(new Shape(750, 750+50, 0, windowHeight-500, "N/A", Color.GREEN));
    }   

}