package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level1 extends Level {

    // declaring windowHeight and windowWidth attributes
    private double windowHeight, windowWidth;
    
    public Level1(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 1, 50, 550, levelCompleted);
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
        super.addShapeToLevel(new Shape(200, 240, 480, 500, super.getPlatformColor()));   
        super.addShapeToLevel(new Shape(260, 300, 350, 370, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(340, 380, 250, 270, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(265, 305, 140, 160, super.getPlatformColor()));
        
        //Wall
        super.addShapeToLevel(new Shape(380, 390, 70, 550, super.getPlatformColor()));
        
        //Add door here        
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 3*windowHeight/4-10, 3*windowHeight/4, super.getDoorColor()));   
    }   
        
}
