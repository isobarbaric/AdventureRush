package movement;

import game.HelperMenuWindow;
import game.Sprite;
import java.awt.Toolkit;
import javax.swing.JFrame;
import mainmenu.MainMenuWindow;

public class GameFrame extends JFrame {

    private MainMenuWindow previousWindow;
    private Sprite currentSprite;
    private JFrame helperMenu;
    private int gameLevelNumber;
    private DrawingSurface currentFrame;
    private int frameHeight, frameWidth;
   
    public GameFrame(Sprite currentSprite, int gameLevelNumber) {
        this.currentSprite = currentSprite.clone();
        // this.helperMenu = new HelperMenuWindow();
        this.gameLevelNumber = gameLevelNumber;
        this.helperMenu = new HelperMenuWindow(this);
        this.currentFrame = new DrawingSurface(currentSprite, this);
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

        frameWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        frameHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);

        // set the size of the window to full screen
        setSize(frameWidth, frameHeight);
        setResizable(false);
                
        // tell the JFrame what to do when closed
        // this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}