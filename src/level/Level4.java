package level;

import game.LevelSelectWindow;
import game.Sprite;
import level.Level;
import movement.Shape;

public class Level4 extends Level {

    private double windowWidth, windowHeight;
    
    public Level4(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 4, 50, 550, levelCompleted, 4);
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
        super.addShapeToLevel(new Shape(250, 250+40, 0, windowHeight/2-100, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(250, 250+40, windowHeight/2, windowHeight, "N/A", super.getLavaColor()));
        
        super.addShapeToLevel(new Shape(500, 500+40, 0, windowHeight/2, "N/A", super.getLavaColor()));
        super.addShapeToLevel(new Shape(500, 500+40, windowHeight/2+100, windowHeight, "N/A", super.getLavaColor()));
        
        
        // lava floor
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, "N/A", super.getLavaColor()));
        
        // platform
        super.addShapeToLevel(new Shape(90, 90+60, windowHeight/2+150, windowHeight/2+170, "N/A", super.getPlatformColor()));
        super.addShapeToLevel(new Shape(355, 355+60, windowHeight/2+150, windowHeight/2+170, "N/A", super.getPlatformColor()));
    }
        
}