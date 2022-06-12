package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level1 extends Level {

    private double windowHeight, windowWidth;
    
    public Level1(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 1, 50, 550, levelCompleted, 10);
    }

    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
        
        //Platforms
        super.addShapeToLevel(new Shape(200, 240, 480, 500, super.getPlatformColor()));   
        super.addShapeToLevel(new Shape(260, 300, 350, 370, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(340, 380, 250, 270, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(265, 305, 140, 160, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(100, 140, 140, 150, super.getPlatformColor()));
        
        //Wall
        super.addShapeToLevel(new Shape(380, 390, 0, 480, super.getPlatformColor()));
        
        //Add door here        
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }   
        
}
