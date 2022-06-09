package level;

import game.LevelSelectWindow;
import game.Sprite;
import java.awt.Color;
import movement.Shape;

public class Level8 extends Level {

    private double windowHeight, windowWidth;
    
    public Level8(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 8, 0, 200, levelCompleted, 8);
    }
    
    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
       
//        // lava 
//        super.addShapeToLevel(new Shape(175, windowWidth, windowHeight-100, windowHeight, "N/A", Color.RED));
//         
//        // platforms between lava
//        
//        // first green platform 
//        super.addShapeToLevel(new Shape(250, 250+50, windowHeight-200, windowHeight-100, "N/A", Color.GREEN));
//        super.addShapeToLevel(new Shape(250, 250+50, 0, windowHeight-300, "N/A", Color.GREEN));
//        
//        // second green platform
//        super.addShapeToLevel(new Shape(500, 500+50, windowHeight-300, windowHeight-100, "N/A", Color.GREEN));
//        super.addShapeToLevel(new Shape(500, 500+50, 0, windowHeight-400, "N/A", Color.GREEN));
//
//        // third green platform
//        super.addShapeToLevel(new Shape(750, 750+50, windowHeight-400, windowHeight-100, "N/A", Color.GREEN)); 
//        super.addShapeToLevel(new Shape(750, 750+50, 0, windowHeight-500, "N/A", Color.GREEN));

        // lava
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, "N/A", Color.RED));
        
        // platforms (width = 40, height = 20)
        
        // initial platform
        super.addShapeToLevel(new Shape(0, 60, windowHeight/2-20, windowHeight/2, "N/A", Color.green));        

        // first standard platform
        super.addShapeToLevel(new Shape(200, 200+40, 85, 85+20, "N/A", Color.green));

        // second standard platform
        super.addShapeToLevel(new Shape(390, 390+40, 375, 375+20, "N/A", Color.green));

        // third standard platform
        super.addShapeToLevel(new Shape(630, 630+40, windowHeight/2-100, windowHeight/2-80, "N/A", Color.green));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, "N/A", Color.YELLOW));   

        // set the location of the door
        super.setExitDoorX(windowWidth-40);
        super.setExitDoorY(3*windowHeight/4-10);
    }

}