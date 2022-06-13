package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level2 extends Level {

    private double windowHeight, windowWidth;

    public Level2(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        super(previousWindow, currentSprite, 2, 50, 550, levelCompleted);
    }

    @Override
    void processShapesForAddition() {
        if (windowWidth == 0) {
            windowWidth = super.getGameFrameWidth();
        }
        if (windowHeight == 0) {
            windowHeight = super.getGameFrameHeight();
        }

        //Platforms
        super.addShapeToLevel(new Shape(340, 350, 430, 450, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(450, 460, 390, 410, super.getPlatformColor()));

        // lava block
        super.addShapeToLevel(new Shape(200, windowWidth - 200, windowHeight - 80, windowHeight, super.getLavaColor()));

        // door to exit
        super.addShapeToLevel(new Shape(windowWidth - 40, windowWidth, 3 * windowHeight / 4 - 10, 3 * windowHeight / 4, super.getDoorColor()));
    }

}
