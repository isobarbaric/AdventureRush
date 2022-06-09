package level;

import game.LevelSelectWindow;
import game.Sprite;
import java.awt.Color;
import movement.Shape;

public class Level9 extends Level {

    private double windowHeight, windowWidth;
    
    public Level9(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 9, 50, 550, levelCompleted, 9);
    }
    
    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
       
        // lava walls
        
        // first lava wall
        super.addShapeToLevel(new Shape(170, 170+40, 0, 240, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(170, 170+40, 420, windowHeight, "N/A", super.getLavaColor()));
        
        // second lava wall
        super.addShapeToLevel(new Shape(440, 440+40, 0, 240, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(440, 440+40, 420, windowHeight, "N/A", super.getLavaColor()));

        // third lava wall
        super.addShapeToLevel(new Shape(710, 710+40, 0, 240, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(710, 710+40, 420, windowHeight, "N/A", super.getLavaColor()));

        // lava floor
        super.addShapeToLevel(new Shape(170+40, windowWidth, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));
        
        // first platform
        super.addShapeToLevel(new Shape(270, 270+100, windowHeight-120, windowHeight-100, "N/A", super.getPlatformColor()));
        
        // second platform
        super.addShapeToLevel(new Shape(540, 540+100, windowHeight-120, windowHeight-100, "N/A", super.getPlatformColor()));
                
        // third platform
        super.addShapeToLevel(new Shape(820, 820+40, windowHeight-180, windowHeight-160, "N/A", super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-200, 3*windowHeight/4-190, "N/A", super.getDoorColor()));   

        // set the location of the door
        super.setExitDoorX(windowWidth-40);
        super.setExitDoorY(3*windowHeight/4-200);
    }

}