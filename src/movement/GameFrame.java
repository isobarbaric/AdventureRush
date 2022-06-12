package movement;

import game.Sprite;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import level.Level;

public class GameFrame extends JFrame {

    private int gameLevelNumber;
    private DrawingSurface currentFrame;
    private int frameHeight, frameWidth;
    private Level currentLevel;
   
    public GameFrame(Sprite currentSprite, int gameLevelNumber, int begX, int begY) {
        this.gameLevelNumber = gameLevelNumber;
        this.currentFrame = new DrawingSurface(currentSprite, begX, begY);
        frameWidth = 900;
        frameHeight = 562;
    }
    
    // made to be used after constructor
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }
    
    public void loadFrame() {
        // create the User interface
        initUI();
        setVisible(true);
    }
    
    public void closeFrame() {
        setVisible(false);
    }
    
    // todo: add all other setters and getters
    
    public DrawingSurface getCurrentFrame() {
        return currentFrame;
    } 
    
    public void setCurrentFrame(DrawingSurface currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }
    
    // create the custom JFrame
    private void initUI() {
        // set title of the JFrame

        setTitle("Adventure Rush - Level " + gameLevelNumber);
                
        // need to add the helper menu to this, or might just leave out if need be
       
        // add a custom JPanel to draw on
        add(currentFrame);

        // set the size of the window to full screen
        setSize(frameWidth, frameHeight);
        setResizable(false);
                
        // tell the JFrame what to do when closed
        // this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Music class for every game level
     */
    public class Music {

        // declaring the attributes
        private String name;
        private Clip clip;
        private AudioInputStream sound;

        /**
         * Primary Constructor
         */
        public Music() {
            name = new String();
            setFile();
        }

        /**
         * Secondary Constructor - Must have a music file name
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