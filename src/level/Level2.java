package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level2 extends Level {

    private double windowHeight, windowWidth;
    
    public Level2(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 2, 50, 550, levelCompleted, 2);
    }
    
    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
       
        // lava block
        super.addShapeToLevel(new Shape(200, 200+150, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));

        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, "N/A", super.getDoorColor()));   

        // set the location of the door
        super.setExitDoorX(windowWidth-40);
        super.setExitDoorY(3*windowHeight/4-10);
    }

}