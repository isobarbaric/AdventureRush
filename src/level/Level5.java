package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level5 extends Level {

    private double windowHeight, windowWidth;
    
    public Level5(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 9, 30, 100, levelCompleted, 5);
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
        super.addShapeToLevel(new Shape(0, 215, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(215+70, windowWidth, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));
        
        // platforms
        super.addShapeToLevel(new Shape(0, 100, windowHeight/2-90, windowHeight/2-50, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(windowWidth/2-25, windowWidth/2+15, 0, 200, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(windowWidth/2-25, windowWidth/2+15, windowHeight-240, windowHeight, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(215, 215+70, windowHeight-150, windowHeight, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(windowWidth/2+25, windowWidth/2+65, windowHeight/2+100, windowHeight/2+120, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(3*windowWidth/4, 3*windowWidth/4+40, windowHeight/2-80, windowHeight/2-60, "N/A", super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, "N/A", super.getDoorColor()));   

        // set the location of the door
        super.setExitDoorX(windowWidth-40);
        super.setExitDoorY(3*windowHeight/4-10);
    }

}