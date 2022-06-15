package level;

import game.LevelSelectWindow;
import game.Sprite;
import movement.Shape;

public class Level4 extends Level {

    // declaring windowHeight and windowWidth attributes
    private double windowWidth, windowHeight;
    
    public Level4(LevelSelectWindow previousWindow, Sprite currentSprite, boolean levelCompleted) {
        // calling the constructor for the super class
        super(previousWindow, currentSprite, 4, 100, 370, levelCompleted);
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
        super.addShapeToLevel(new Shape(250, 250+40, 0, windowHeight/2-100, super.getLavaColor()));
        super.addShapeToLevel(new Shape(250, 250+40, windowHeight/2, windowHeight, super.getLavaColor()));
        super.addShapeToLevel(new Shape(500, 500+40, 0, windowHeight/4+20, super.getLavaColor()));
        super.addShapeToLevel(new Shape(500, 500+40, windowHeight/2+100, windowHeight, super.getLavaColor()));
        super.addShapeToLevel(new Shape(0, windowWidth, windowHeight-100, windowHeight, super.getLavaColor()));
        
        // adding the platforms to the level
        super.addShapeToLevel(new Shape(90, 90+60, windowHeight/2+150, windowHeight/2+170, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(355, 355+60, windowHeight/2+150, windowHeight/2+170, super.getPlatformColor()));
        super.addShapeToLevel(new Shape(550, 570, windowHeight/2+150, windowHeight/2+170, super.getPlatformColor()));
        
        //Door
        super.addShapeToLevel(new Shape(windowWidth-40, windowWidth, 180, 400, super.getDoorColor()));  
    } 
        
}