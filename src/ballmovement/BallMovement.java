/*
 * B Cutten
    April 7, 2022
    A main frame which will serve as a container for the panel
    Also contains a main method which starts things up
 */
package ballmovement;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BallMovement extends JFrame {

    //constructor
    public BallMovement() {
        //create the User interface
        initUI();
    }

    //create the custom JFrame
    private void initUI() {
        //set title of the JFrame
        setTitle("Bouncing Balls");
        //add a custom JPanel to draw on
        add(new DrawingSurface());
        //set the size of the window to full screen
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        //makes sure that GUI updates nicely with the rest of the OS
        EventQueue.invokeLater(() -> {
            JFrame ex = new BallMovement();
            ex.setVisible(true);
        });
    }
}
