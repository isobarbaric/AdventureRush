package game;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

public class GameLevel {

    //Declaring the attributes
    private String levelName;
    private GameFrame[] levelScreens;

    /**
     * Default constructor
     */
    public GameLevel() {
        this.levelName = new String();
        this.levelScreens = new GameFrame[10];
    }

    /**
     * Primary Constructor
     *
     * @param levelName - The level name
     */
    public GameLevel(String levelName) {
        this();
        this.levelName = levelName;
    }

    /**
     * Secondary Constructor - Must have a level name and an array of level
     * screens
     *
     * @param levelName - The level name
     * @param levelScreens - The array containing the screens for the level
     */
    public GameLevel(String levelName, GameFrame[] levelScreens) {
        this(levelName);
        this.levelScreens = levelScreens.clone();
    }

    /**
     * Accessor for the level name
     *
     * @return the level name
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Accessor for the level screens
     *
     * @return the level screens
     */
    public GameFrame[] getLevelScreens() {
        return levelScreens;
    }

    /**
     * Accessor for a specific screen
     *
     * @param screenNumber
     * @return the chosen screen
     */
    public GameFrame getSpecificScreen(int screenNumber) {
        return levelScreens[screenNumber];
    }

    /**
     * Mutator for the levelName attribute
     *
     * @param levelName
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * Primary mutator for levelScreens attribute
     *
     * @param levelScreens
     */
    public void setLevelScreens(GameFrame[] levelScreens) {
        this.levelScreens = levelScreens.clone();
    }

    /**
     * Secondary mutator for the levelScreens attribute
     *
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
     *
     * @param otherGameLevel
     * @return
     */
    public boolean equals(GameLevel otherGameLevel) {
        return levelName.equals(otherGameLevel.getLevelName()) && Arrays.equals(levelScreens, otherGameLevel.getLevelScreens());
    }

    /**
     * Standard Java clone() method
     *
     * @return
     */
    @Override
    public GameLevel clone() {
        GameLevel clonedObj = new GameLevel(levelName, levelScreens.clone());
        return clonedObj;
    }

    /**
     * Standard Java toString() method
     *
     * @return
     */
    @Override
    public String toString() {
        return "GameLevel{" + "levelName=" + levelName + ", levelScreens=" + Arrays.toString(levelScreens) + '}';
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
