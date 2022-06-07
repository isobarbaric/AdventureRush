package movement;

import game.GameLevel;
import game.Sprite;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private final Sprite currentSprite;
    private final JFrame helperMenu;
    private int gameLevelNumber;
    
    private GameLevel outerGameLevel;
    
    public GameFrame(Sprite currentSprite, JFrame helperMenu, int gameLevelNumber, GameLevel outerGameLevel) {
        this.currentSprite = currentSprite.clone();
        this.helperMenu = helperMenu;
        this.gameLevelNumber = gameLevelNumber;
        this.outerGameLevel = outerGameLevel;
        // create the User interface
        initUI();
    }

    // todo: add setters and getters
    
    public void changeToNextWindow() {
        outerGameLevel.switchWindows();
        outerGameLevel.setCurrentFrameNumber(outerGameLevel.getCurrentFrameNumber() + 1);
    }
    
    // create the custom JFrame
    private void initUI() {
        // set title of the JFrame
        
        int displayFrame = outerGameLevel.getCurrentFrameNumber() + 1;
        System.out.println(gameLevelNumber + " " + displayFrame);
        setTitle("Adventure Rush - Level " + gameLevelNumber + ", Frame " + displayFrame);

        // need to add the helper menu to this, or might just leave out if need be
        
        // add a custom JPanel to draw on
        add(new DrawingSurface(currentSprite, this));

        // set the size of the window to full screen
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.7), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.7));

        // tell the JFrame what to do when closed
        // this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}