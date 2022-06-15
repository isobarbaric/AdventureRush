package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level8 extends Level {

    // declaring windowHeight and windowWidth attributes
    private double windowHeight, windowWidth;
    
    public Level8(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 8, 0, 200, levelCompleted);
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
       
        // adding the lava to the level
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
        
        // adding the platforms to the level
        
        // initial platform
        super.addShapeToLevel(new Shape(0, 60, windowHeight/2-20, windowHeight/2, super.getPlatformColor()));        

        // first standard platform
        super.addShapeToLevel(new Shape(200, 200+40, 85, 85+20, super.getPlatformColor()));

        // second standard platform
        super.addShapeToLevel(new Shape(390, 390+40, 375, 375+20, super.getPlatformColor()));

        // third standard platform
        super.addShapeToLevel(new Shape(600, 600+40, windowHeight/2-100, windowHeight/2-80, super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }

}