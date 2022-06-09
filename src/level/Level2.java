package level;

import game.LevelSelectWindow;
import game.Sprite;

public class Level2 extends Level {

    public Level2(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 2, 50, 550, levelCompleted, 2);
    }

    @Override
    void processShapesForAddition() {
        
    }
        
}