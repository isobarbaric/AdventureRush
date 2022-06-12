package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level7 extends Level {

    private double windowHeight, windowWidth;
    
    public Level7(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 7, 50, 550, levelCompleted, 3);
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
        super.addShapeToLevel(new Shape(175, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
         
        // platforms between lava
        
        // first green platform 
        super.addShapeToLevel(new Shape(250, 250+50, windowHeight-200, windowHeight-100, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(250, 250+50, 0, windowHeight-300, super.getPlatformColor()));
        
        // second green platform
        super.addShapeToLevel(new Shape(500, 500+50, windowHeight-300, windowHeight-100, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(500, 500+50, 0, windowHeight-400, super.getPlatformColor()));

        // third green platform
        super.addShapeToLevel(new Shape(750, 750+50, windowHeight-400, windowHeight-100, super.getPlatformColor())); 
        super.addShapeToLevel(new Shape(750, 750+50, 0, windowHeight-500, super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }

}