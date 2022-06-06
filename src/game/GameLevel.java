package game;

import java.util.ArrayList;
import java.util.Arrays;
import movement.GameFrameV2;

public class GameLevel {
    
    // declaring the attributes
    private String levelName;
    private ArrayList<GameFrameV2> levelScreens;
    
    /**
     * Default constructor
     */
    public GameLevel() {
        this.levelName = new String();
        this.levelScreens = new ArrayList();
    }
    
    /**
     * Primary Constructor
     * @param levelName - The level name 
     */
    public GameLevel(String levelName) {
        this();
        this.levelName = levelName;
    }
    
    /**
     * Secondary Constructor - Must have a level name and an array of level screens
     * @param levelName - The level name
     * @param levelScreens - The array containing the screens for the level
     */
    public GameLevel(String levelName, ArrayList<GameFrameV2> levelScreens) {
        this(levelName);
        this.levelScreens = (ArrayList<GameFrameV2>) levelScreens.clone();
    }
    
    public void loadLevel() {
        levelScreens.get(0).setVisible(true);
    }
    
    public void addLevelScreens(GameFrameV2 currentLevelScreen) {
        levelScreens.add(currentLevelScreen);
    }
    
    /**
     * Accessor for the level name
     * @return the level name
     */
    public String getLevelName() {
        return levelName;
    }
    
    /**
     * Accessor for the level screens
     * @return the level screens
     */
    public ArrayList<GameFrameV2> getLevelScreens() {
        return levelScreens;
    }
    
    /**
     * Accessor for a specific screen
     * @param screenNumber
     * @return the chosen screen
     */
    public GameFrameV2 getSpecificScreen(int screenNumber) {
        return levelScreens.get(screenNumber);
    }
    
    /**
     * Mutator for the levelName attribute
     * @param levelName 
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    
    /**
     * Primary mutator for levelScreens attribute
     * @param levelScreens 
     */
    public void setLevelScreens(ArrayList<GameFrameV2> levelScreens) {
        this.levelScreens = (ArrayList<GameFrameV2>) levelScreens.clone();
    }
    
    /**
     * Secondary mutator for the levelScreens attribute
     * @param screenNumber
     * @param levelScreen 
     */
    public void setLevelScreen(int screenNumber, GameFrameV2 levelScreen) {
        this.levelScreens.set(screenNumber, levelScreen);
    }
    
    /**
     * Standard Java equals() method
     * @param otherGameLevel
     * @return 
     */
    public boolean equals(GameLevel otherGameLevel) {
        return levelName.equals(otherGameLevel.getLevelName()) && levelScreens.equals(otherGameLevel.getLevelScreens());
    }
    
    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public GameLevel clone() {
        GameLevel clonedObj = new GameLevel(levelName, (ArrayList<GameFrameV2>) levelScreens.clone());
        return clonedObj;
    }

    /**
     * Standard Java toString() method
     * @return 
     */
    @Override
    public String toString() {
        return "GameLevel{" + "levelName=" + levelName + ", levelScreens=" + levelScreens + '}';
    }
        
}