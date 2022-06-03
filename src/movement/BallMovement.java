package movement;

import game.Sprite;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class BallMovement extends JFrame {

    private final Sprite currentSprite;
    
    //constructor
    public BallMovement(Sprite currentSprite) {
        this.currentSprite = currentSprite.clone();
        //create the User interface
        initUI();
    }

    // todo: add setters and getters
    
    //create the custom JFrame
    private void initUI() {
        //set title of the JFrame
        setTitle("Bouncing Balls");
        //add a custom JPanel to draw on
        add(new DrawingSurface(currentSprite));
        //set the size of the window to full screen
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}