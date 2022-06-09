package level;

import game.LevelSelectWindow;
import game.Sprite;

public class Level3 extends Level { // this is for Curtis's Level2

    public Level3(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 3, 50, 550, levelCompleted, 3);
    }

    @Override
    void processShapesForAddition() {
        
    }
        
}