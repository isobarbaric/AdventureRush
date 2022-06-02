
package game;


public class GameLevel {
    
    //Declaring the attributes
    private String levelName;
    private GameFrame[] levelScreens;
    
    
    /**
     * Primary Constructor
     * @param levelName - The level name 
     */
    public GameLevel(String levelName) {
        
        this.levelName = levelName;

    }
    
    /**
     * Secondary Constructor - Must have a level name and an array of level screens
     * @param levelName - The level name
     * @param levelScreens - The array containing the screens for the level
     */
    public GameLevel(String levelName, GameFrame[] levelScreens) {
        
        this.levelName = levelName;
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
     * @param num - The index of the screen
     * @return the chosen screen
     */
    public GameFrame getSpecificScreen(int num) {
        
        return levelScreens[num];
        
    }
    
    public void setLevelName(String levelName) {
        
        this.levelName = levelName;
        
    }
    
    public void setLevelScreens(GameFrame[] levelScreens) {
        
        
        
        
    }
    
    public void setLevelScreen(int num, GameFrame levelScreen) {
        
        this.levelScreens[num] = levelScreen;
        
        
    }
    
    public void loadLevel() {
        
        
        
    }
    
    public boolean equals(GameLevel otherGameLevel) {
        
        
        
    }
    
    
    public GameLevel clone() {
        
        
        
        
    }
    
    public String toString() {
        
        
        
    }
    
}