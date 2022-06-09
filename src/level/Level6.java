package level;

import game.LevelSelectWindow;
import game.Sprite;

public class Level6 extends Level { // this is for Curtis's Level2

    public Level6(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 6, 50, 550, levelCompleted, 6);
    }

    @Override
    void processShapesForAddition() {
        
    }
        
}