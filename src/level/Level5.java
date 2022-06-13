package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level5 extends Level {

    private double windowHeight, windowWidth;
    
    public Level5(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 5, 30, 100, levelCompleted);
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
        super.addShapeToLevel(new Shape(0, 215, windowHeight-100, windowHeight, super.getLavaColor()));
        super.addShapeToLevel(new Shape(215+70, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
        
        // platforms
        super.addShapeToLevel(new Shape(0, 100, 200, windowHeight/2-50, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(windowWidth/2-25, windowWidth/2+15, 0, 200, super.getLavaColor()));
        super.addShapeToLevel(new Shape(windowWidth/2-25, windowWidth/2+15, windowHeight-240, windowHeight, super.getLavaColor()));
        super.addShapeToLevel(new Shape(215, 215+70, windowHeight-150, windowHeight, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(windowWidth/2+25, windowWidth/2+65, windowHeight/2+100, windowHeight/2+120, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(3*windowWidth/4, 3*windowWidth/4+40, windowHeight/2-80, windowHeight/2-60, super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }

}