package adventurerush;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class LoginPortal extends Menu {
 
    // constructors for a LoginPortal object 
    
    /**
     * Default constructor
     */
    public LoginPortal() {
        super();
    }
    
    /**
     * Primary constructor
     * @param menuName name of the LoginPortal object
     */
    public LoginPortal(String menuName) {
        super(menuName);
    }
    
    /**
     * Secondary constructor 
     * @param menuName name of the LoginPortal object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     */
    public LoginPortal(String menuName, JFrame menuContent) {
        super(menuName, menuContent);
    }
    
    /**
     * Tertiary constructor
     * @param menuName name of the LoginPortal object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     * @param assets an ArrayList containing the images to be used in displaying this Menu
     */
    public LoginPortal(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        super(menuName, menuContent, assets);
    }
    
    /**
     * Quaternary constructor 
     * @param menuName name of the LoginPortal object
     * @param menuContent the JFrame containing the graphical content of the Menu object
     * @param assets an ArrayList containing the images to be used in displaying this Menu
     * @param userCredentials an ArrayList containing information about all of the users of this application
     */
    public LoginPortal(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets, ArrayList<User> userCredentials) {
        this(menuName, menuContent, assets);
    }

    // behavior methods for a LoginPortal object

    // standard methods 

    // TODO: fix standard methods that have userCredentials variable attached to them 
    
//    /**
//     * Standard Java toString method
//     * @return toDisplay a string containing information about the current LoginPortal object
//     */
//    public String toString() {
//        String toDisplay = super.toString() + " LoginPortal, User Credentials: " + userCredentials;
//        return toDisplay;
//    }
//    
//    /**
//     * Standard Java equals() method
//     * @param otherLoginPortal the other LoginPortal object being compared to
//     * @return a boolean representing whether both LoginPortal objects are identical or not
//     */
//    public boolean equals(LoginPortal otherLoginPortal) {
//        return super.equals(otherLoginPortal) && userCredentials.equals(otherLoginPortal.getUserCredentials());
//    }
//    
//    /**
//     * Standard Java clone() method 
//     * @return currentLoginPortal an identical LoginPortal object to the current LoginPortal object
//     */
//    public LoginPortal clone() {
//        LoginPortal currentLoginPortal = new LoginPortal(getMenuName(), getMenuContent(), getAssets(), userCredentials);
//        return currentLoginPortal;
//    }
        
}