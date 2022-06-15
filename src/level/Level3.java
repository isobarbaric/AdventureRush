package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level3 extends Level {

    // declaring windowHeight and windowWidth attributes
    private double windowHeight, windowWidth;

    public Level3(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 3, 0, 200, levelCompleted);
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
        super.addShapeToLevel(new Shape(0, 40, 200, 220, super.getPlatformColor()));   
        super.addShapeToLevel(new Shape(0, 40, 440, 460, super.getPlatformColor())); 
        super.addShapeToLevel(new Shape(100, 140, 200, 220, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(100, 140, 440, 460, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(300, 340, 300, 320, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(540, 580, 300, 320, super.getPlatformColor()));
        
        // adding the lava to the level
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
            
        // adding the door to the level        
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 180, 200, super.getDoorColor()));   
    }
        
}