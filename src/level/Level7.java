package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level7 extends Level {

    // declaring windowHeight and windowWidth attributes
    private double windowHeight, windowWidth;
    
    public Level7(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 7, 50, 550, levelCompleted);
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
        super.addShapeToLevel(new Shape(175, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
         
        // adding the platforms to the level
        
        // first green platform 
        super.addShapeToLevel(new Shape(250, 250+50, windowHeight-200, windowHeight-100, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(250, 250+50, 0, windowHeight-300, super.getPlatformColor()));
        
        // second green platform
        super.addShapeToLevel(new Shape(500, 500+50, windowHeight-300, windowHeight-100, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(500, 500+50, 0, windowHeight-400, super.getPlatformColor()));

        // third green platform
        super.addShapeToLevel(new Shape(750, 750+50, windowHeight-400, windowHeight-100, super.getPlatformColor())); 
        super.addShapeToLevel(new Shape(750, 750+50, 0, windowHeight-500, super.getPlatformColor()));
        
        // door to exit
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }

}