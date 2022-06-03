package game;

import java.util.Arrays;

public class GameLevel {
    
    // declaring the attributes
    private String levelName;
    private GameFrame[] levelScreens;
    
    // declaring a static attribute for the number of frames
    private static int numFrames;
    
    static {
        numFrames = 10;
    }

    /**
     * Default constructor
     */
    public GameLevel() {
        this.levelName = new String();
        this.levelScreens = new GameFrame[numFrames];
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
    public GameLevel(String levelName, GameFrame[] levelScreens) {
        this(levelName);
        this.levelScreens = levelScreens.clone();
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
    public GameFrame[] getLevelScreens() {
        return levelScreens;
    }
    
    /**
     * Accessor for a specific screen
     * @param screenNumber
     * @return the chosen screen
     */
    public GameFrame getSpecificScreen(int screenNumber) {
        return levelScreens[screenNumber];
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
    public void setLevelScreens(GameFrame[] levelScreens) {
        this.levelScreens = levelScreens.clone();
    }
    
    /**
     * Secondary mutator for the levelScreens attribute
     * @param screenNumber
     * @param levelScreen 
     */
    public void setLevelScreen(int screenNumber, GameFrame levelScreen) {
        this.levelScreens[screenNumber] = levelScreen;
    }
    
    // todo: implement the loadLevel() method
//    public void loadLevel() {
//        
//    }
    
    /**
     * Standard Java equals() method
     * @param otherGameLevel
     * @return 
     */
    public boolean equals(GameLevel otherGameLevel) {
        return levelName.equals(otherGameLevel.getLevelName()) && Arrays.equals(levelScreens, otherGameLevel.getLevelScreens());
    }
    
    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public GameLevel clone() {
        GameLevel clonedObj = new GameLevel(levelName, levelScreens.clone());
        return clonedObj;
    }

    /**
     * Standard Java toString() method
     * @return 
     */
    @Override
    public String toString() {
        return "GameLevel{" + "levelName=" + levelName + ", levelScreens=" + Arrays.toString(levelScreens) + '}';
    }
        
}