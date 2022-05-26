package adventurerush;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class LoginPortal extends Menu {

    // attributes of a LoginPortal object
    private int numTotalValidLoginAttempts;
    private int numValidLoginAttempts;
    private int numInvalidLoginAttempts;
    private ArrayList<User> userCredentials;

    /**
     * Default constructor for a LoginPortal object
     * @param: none
     */
    public LoginPortal() {
        super();
        numTotalValidLoginAttempts = 0; 
        numValidLoginAttempts = 0; 
        numInvalidLoginAttempts = 0;
        userCredentials = new ArrayList<>();
        loadRegisteredUsers();
    }

    /**
     * Default constructor for a LoginPortal object
     * @param: none
     */
    public LoginPortal(String menuName) {
        super(menuName);
        numTotalValidLoginAttempts = 0; 
        numValidLoginAttempts = 0; 
        numInvalidLoginAttempts = 0;
        userCredentials = new ArrayList<>();
        loadRegisteredUsers();
    }

    /**
     * Primary constructor for a LoginPortal object
     * @param menuName - the name of the menu
     * @param menuContent - JFrame object that represents the frame of the menu
     * @param assets - an ArrayList containing the images associated with the LoginPortal object
     * */
    public LoginPortal(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets) {
        super(menuName, menuContent, assets);
        numTotalValidLoginAttempts = 0;
        numValidLoginAttempts = 0;
        numInvalidLoginAttempts = 0;
        userCredentials = new ArrayList<>();
        loadRegisteredUsers();
    }

    /**
     * Secondary constructor for a LoginPortal object
     * @param menuName - the name of the menu
     * @param menuContent - JFrame object that represents the frame of the menu
     * @param assets - an ArrayList containing the images associated with the LoginPortal object
     * @param userCredentials - an ArrayList containing the User objects associated with the LoginPortal object
     * */
    public LoginPortal(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets, ArrayList<User> userCredentials) {
        super(menuName, menuContent, assets);
        numTotalValidLoginAttempts = 0;
        numValidLoginAttempts = 0;
        numInvalidLoginAttempts = 0;
        this.userCredentials = userCredentials;
        loadRegisteredUsers();
    }

    /**
     * Tertiary constructor for a LoginPortal object
     * @param menuName - the name of the menu
     * @param menuContent - JFrame object that represents the frame of the menu
     * @param assets - an ArrayList containing the images associated with the LoginPortal object
     * @param userCredentials - an ArrayList containing the User objects associated with the LoginPortal object
     * @param numTotalValidLoginAttempts - the number of valid login attempts
     * @param numValidLoginAttempts - the number of valid login attempts
     * @param numInvalidLoginAttempts - the number of invalid login attempts
     * */
    public LoginPortal(String menuName, JFrame menuContent, ArrayList<ImageIcon> assets, ArrayList<User> userCredentials, int numTotalValidLoginAttempts, int numValidLoginAttempts, int numInvalidLoginAttempts) {
        super(menuName, menuContent, assets);
        this.numTotalValidLoginAttempts = numTotalValidLoginAttempts;
        this.numValidLoginAttempts = numValidLoginAttempts;
        this.numInvalidLoginAttempts = numInvalidLoginAttempts;
        this.userCredentials = userCredentials;
        loadRegisteredUsers();
    }
        
    // getters 

    public int getNumTotalValidLoginAttempts() {
        return numTotalValidLoginAttempts;
    }

    public int getNumValidLoginAttempts() {
        return numValidLoginAttempts;
    }

    public int getNumInvalidLoginAttempts() {
        return numInvalidLoginAttempts;
    }

    // setters 

    public void setNumTotalValidLoginAttempts(int numTotalValidLoginAttempts) {
        this.numTotalValidLoginAttempts = numTotalValidLoginAttempts;
    }

    public void setNumValidLoginAttempts(int numValidLoginAttempts) {
        this.numValidLoginAttempts = numValidLoginAttempts;
    }

    public void setNumInvalidLoginAttempts(int numInvalidLoginAttempts) {
        this.numInvalidLoginAttempts = numInvalidLoginAttempts;
    }

    public ArrayList<User> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(ArrayList<User> userCredentials) {
        this.userCredentials = userCredentials;
    }

    // behavior

    private int findUser(String usernameEntered, String passwordEntered) {
        for (int i = 0; i < userCredentials.size(); i++) {
            if (userCredentials.get(i).checkLoginCredentials(usernameEntered, passwordEntered)) {
                return i;
            }
        }
        return -1; 
    }
   
    // standard methods

    // standard Java toString() method
    @Override
    public String toString() {
        String toDisplay = super.toString();
        // adding information about the number of login attempts to the toDisplay string 
        toDisplay += "Number of total valid login attempts= " + numTotalValidLoginAttempts + ", Number of valid login attempts= " + numValidLoginAttempts + ", Number of invalid login attempts= " + numInvalidLoginAttempts;
        // looping over the users in the userCredentials array and adding information about them to the toDisplay string
        toDisplay += ", User credentials= ";
        for (int i = 0; i < userCredentials.size(); i++) {
            toDisplay += "\n" + userCredentials.get(i).toString();
        }
        return toDisplay;
    }

    // standard Java equals() method
    // public boolean equals(LoginPortal otherLoginPortal) {
    //     return menuName.equals(otherLoginPortal.getMenuName()) && menuContent.equals(otherLoginPortal.getMenuContent()) && assets == otherLoginPortal.getAssets() && userCredentials == otherLoginPortal.getUserCredentials() && numTotalValidLoginAttempts == otherLoginPortal.getNumTotalValidLoginAttempts() && numValidLoginAttempts == otherLoginPortal.getNumValidLoginAttempts() && numInvalidLoginAttempts == otherLoginPortal.getNumInvalidLoginAttempts();
    // }
    
    // clone method
    public LoginPortal clone() {
        LoginPortal otherLoginPortal = new LoginPortal(getMenuName(), getMenuContent(), getAssets(), userCredentials, numTotalValidLoginAttempts, numValidLoginAttempts, numInvalidLoginAttempts);
        return otherLoginPortal;
    }

    public void loadRegisteredUsers() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/adventurerush/loginDetails.txt"));
        } catch (FileNotFoundException e) {
            // change this to some sort of graphical thing later on
            System.out.println("Invalid file path for the file containing information about the users. Please correct this file path and then try running the program again.");
            return;
        }
        while (scanner.hasNextLine()) {
            String username = scanner.nextLine().substring("Username: ".length());
            String password = scanner.nextLine().substring("Password: ".length());
            int lastLevel = Integer.parseInt(scanner.nextLine().substring("Last Level: ".length()));
            User currentUser = new User(username, password, lastLevel);
            if (scanner.hasNextLine()) scanner.nextLine();
            userCredentials.add(currentUser);
        }
    }

}
