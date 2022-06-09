package level;

import game.LevelSelectWindow;
import game.Sprite;
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
       
        // lava
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));
        
        // platforms (width = 40, height = 20)
        
        // initial platform
        super.addShapeToLevel(new Shape(0, 60, windowHeight/2-20, windowHeight/2, "N/A", super.getPlatformColor()));        

        // first standard platform
        super.addShapeToLevel(new Shape(200, 200+40, 85, 85+20, "N/A", super.getPlatformColor()));

        // second standard platform
        super.addShapeToLevel(new Shape(390, 390+40, 375, 375+20, "N/A", super.getPlatformColor()));

        // third standard platform
        super.addShapeToLevel(new Shape(630, 630+40, windowHeight/2-100, windowHeight/2-80, "N/A", super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, "N/A", super.getDoorColor()));   

        // set the location of the door
        super.setExitDoorX(windowWidth-40);
        super.setExitDoorY(3*windowHeight/4-10);
    }

}