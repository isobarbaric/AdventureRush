package movement;

import game.Sprite;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
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
        currentFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    currentLevel.loadLevelMenu();
                }
            }
        });
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

}