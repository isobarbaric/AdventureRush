package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level6 extends Level { 
    
    private double windowWidth, windowHeight;

    public Level6(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 6, 50, 550, levelCompleted, 6);
    }

    @Override
    void processShapesForAddition() {
        
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        } 
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }
        
        
        
    }
        
}