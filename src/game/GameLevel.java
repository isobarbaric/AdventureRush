package game;

import java.util.ArrayList;
import movement.GameFrame;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

public class GameLevel {
    
    // declaring the attributes
    private String levelName;
    private ArrayList<GameFrame> levelScreens;
    private int currentFrameNumber;
    private int currentLevelNumber;
    
    /**
     * Default constructor
     */
    public GameLevel() {
        this.levelName = new String();
        this.levelScreens = new ArrayList();
        currentFrameNumber = 0;
        currentLevelNumber = 0;
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
    public GameLevel(String levelName, ArrayList<GameFrame> levelScreens, int currentLevelNumber) {
        this(levelName);
        this.levelScreens = (ArrayList<GameFrame>) levelScreens.clone();
        this.currentLevelNumber = currentLevelNumber;
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
    
    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }
    
    public void setCurrentLevelNumber(int currentLevelNumber) {
        this.currentLevelNumber = currentLevelNumber;
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
        GameLevel clonedObj = new GameLevel(levelName, (ArrayList<GameFrame>) levelScreens.clone(), currentLevelNumber);
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
      
     /**
     * Music class for every game level
     */
    public class Music {

        //Declaring the attributes
        private String name;
        Clip clip;
        AudioInputStream sound;

        /**
         * Primary Constructor
         */
        public Music() {

            name = "";
            setFile();

        }

        /**
         * Secondary Constructor - Must have a music file name
         *
         * @param name
         */
        public Music(String name) {
            this(); //Primary chaining
            this.name = name;

        }

        /**
         *
         */
        public void setFile() {
            try {
                File file = new File(name);
                sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);

            } catch (Exception e) {

                //Displays an error message
                JOptionPane.showMessageDialog(null, "Error: " + e);

            }
        }

        /**
         * Plays the music
         */
        public void play() {
            clip.start();
        }

        /**
         * Stops the music
         *
         * @throws IOException - Throws an error Took from
         * https://www.codespeedy.com/how-to-add-audio-on-jswing-in-java/
         */
        public void stop() throws IOException {
            sound.close();
            clip.close();
            clip.stop();
        }

    }
}