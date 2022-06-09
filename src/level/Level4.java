package level;

import game.LevelSelectWindow;
import game.Sprite;

public class Level4 extends Level { // this is for Curtis's Level2

    public Level4(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 4, 50, 550, levelCompleted, 4);
    }

    @Override
    void processShapesForAddition() {
        
    }
        
}