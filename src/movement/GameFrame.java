package movement;

import game.HelperMenuWindow;
import game.Sprite;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import level.Level;
import mainmenu.MainMenuWindow;

public class GameFrame extends JFrame {

    private MainMenuWindow previousWindow;
    private Sprite currentSprite;
    private JFrame helperMenu;
    private int gameLevelNumber;
    private DrawingSurface currentFrame;
    private int frameHeight, frameWidth;
    private Level currentLevel;
   
    public GameFrame(Sprite currentSprite, int gameLevelNumber) {
        this.currentSprite = currentSprite.clone();
        // this.helperMenu = new HelperMenuWindow();
        this.gameLevelNumber = gameLevelNumber;
        this.helperMenu = new HelperMenuWindow(this);
        this.currentFrame = new DrawingSurface(currentSprite);
        // frameWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        // frameHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
        frameWidth = 900;
        frameHeight = 600;
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
   
    public void setPreviousWindow(MainMenuWindow previousWindow) {
        this.previousWindow = previousWindow;
    }
    
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