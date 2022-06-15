package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level6 extends Level { 

    // declaring windowHeight and windowWidth attributes    
    private double windowWidth, windowHeight;

    public Level6(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 6, 50, 550, levelCompleted);
    }

    @Override
    void processShapesForAddition() {
        // initializing the windowWidth attribute if not done so already
        if (windowWidth == 0) {
            
            // initialization with a call to a getter
            windowWidth = super.getGameFrameWidth();
        } 

        // initializing the windowHeight attribute if not done so already
        if (windowHeight == 0) {

            // initialization with a call to a getter
            windowHeight = super.getGameFrameHeight();
        }
 
        // adding the platforms to the level
        super.addShapeToLevel(new Shape(340, 400, 450, 460, super.getPlatformColor()));
   
        // adding the lava to the level
        super.addShapeToLevel(new Shape(200, windowWidth - 200, windowHeight - 80, windowHeight, super.getLavaColor()));

        // door to exit
        super.addShapeToLevel(new Shape(windowWidth - 40, windowWidth, 3 * windowHeight / 4 - 10, 3 * windowHeight / 4, super.getDoorColor()));
        
    }
        
}