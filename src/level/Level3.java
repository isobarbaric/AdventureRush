package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level3 extends Level { // this is for Curtis's Level2

    private double windowHeight, windowWidth;
    public Level3(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 3, 0, 200, levelCompleted, 3);
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
        super.addShapeToLevel(new Shape(0, 40, 200, 220, "N/A", super.getPlatformColor()));   
        super.addShapeToLevel(new Shape(0, 40, 440, 460, "N/A", super.getPlatformColor())); //Key on this platform
        super.addShapeToLevel(new Shape(100, 140, 200, 220, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(100, 140, 440, 460, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(300, 340, 300, 320, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(540, 580, 300, 320, "N/A", super.getPlatformColor()));
        
            
        //Add door here
        
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 180, 200, "N/A", super.getDoorColor()));   


    }
        
}