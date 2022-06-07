package movement;

import game.GameLevel;
import game.HelperMenuWindow;
import game.Sprite;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private Sprite currentSprite;
    private JFrame helperMenu;
    private int gameLevelNumber;
    private ArrayList<Shape> shapes;
    private int height, width;
    private GameLevel outerGameLevel;
    
    public GameFrame(Sprite currentSprite, GameLevel outerGameLevel) {
        this.currentSprite = currentSprite.clone();
        this.helperMenu = new HelperMenuWindow(this);
        this.outerGameLevel = outerGameLevel;
        this.gameLevelNumber = outerGameLevel.getCurrentLevelNumber();
        // create the User interface
        initUI();
    }

    // todo: add setters and getters

    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(Sprite currentSprite) {
        this.currentSprite = currentSprite;
    }

    public JFrame getHelperMenu() {
        return helperMenu;
    }

    public void setHelperMenu(JFrame helperMenu) {
        this.helperMenu = helperMenu;
    }

    public int getGameLevelNumber() {
        return gameLevelNumber;
    }

    public void setGameLevelNumber(int gameLevelNumber) {
        this.gameLevelNumber = gameLevelNumber;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }
    
    public void addShape(Shape newShape) {
        shapes.add(newShape);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public GameLevel getOuterGameLevel() {
        return outerGameLevel;
    }

    public void setOuterGameLevel(GameLevel outerGameLevel) {
        this.outerGameLevel = outerGameLevel;
    }
    
    // behavior
    
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