package game;

import java.util.ArrayList;
import movement.GameFrame;

public class GameLevel {
    
    // declaring the attributes
    private String levelName;
    private ArrayList<GameFrame> levelScreens;
    private int currentFrameNumber;
    
    /**
     * Default constructor
     */
    public GameLevel() {
        this.levelName = new String();
        this.levelScreens = new ArrayList();
        currentFrameNumber = 0;
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
    public GameLevel(String levelName, ArrayList<GameFrame> levelScreens) {
        this(levelName);
        this.levelScreens = (ArrayList<GameFrame>) levelScreens.clone();
    }
    
    public void loadLevel() {
        levelScreens.get(0).setVisible(true);
    }
    
    public void switchWindows() {
        currentFrameNumber++;
        levelScreens.get(currentFrameNumber-1).setVisible(false);
        levelScreens.get(currentFrameNumber).setVisible(true);
    }
    
    public void addLevelScreens(GameFrame currentLevelScreen) {
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
    public ArrayList<GameFrame> getLevelScreens() {
        return levelScreens;
    }
    
    /**
     * Accessor for a specific screen
     * @param screenNumber
     * @return the chosen screen
     */
    public GameFrame getSpecificScreen(int screenNumber) {
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
    public void setLevelScreens(ArrayList<GameFrame> levelScreens) {
        this.levelScreens = (ArrayList<GameFrame>) levelScreens.clone();
    }
    
    /**
     * Secondary mutator for the levelScreens attribute
     * @param screenNumber
     * @param levelScreen 
     */
    public void setLevelScreen(int screenNumber, GameFrame levelScreen) {
        this.levelScreens.set(screenNumber, levelScreen);
    }
    
    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }
    
    public void setCurrentFrameNumber(int currentFrameNumber) {
        this.currentFrameNumber = currentFrameNumber;
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
        GameLevel clonedObj = new GameLevel(levelName, (ArrayList<GameFrame>) levelScreens.clone());
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