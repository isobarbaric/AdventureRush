package loginportal;

import mainmenu.User;
import game.Menu;
import java.util.ArrayList;

public class LoginPortal extends Menu {
 
    // constructors for a LoginPortal object 
    private ArrayList<User> userCredentials;
    
    // constructors

    /**
     * Default constructor
     */
    public LoginPortal() {
        // calling the super class's constructor
        super();
    }
    
    /**
     * Primary constructor
     * @param menuName name of the LoginPortal object
     */
    public LoginPortal(String menuName) {
        // calling the super class's constructor
        super(menuName);
    }
    
    /**
     * Secondary constructor
     * @param menuName name of the LoginPortal object 
     * @param userCredentials 
     */
    public LoginPortal(String menuName, ArrayList<User> userCredentials) {
        // chaining of constructors
        this();

        // initialization of the userCredentials attribute
        this.userCredentials = userCredentials;
    }

    // getters and setters
    
    /**
     * Primary accessor for the userCredentials attribute
     * @return userCredentials 
     */
    public ArrayList<User> getUserCredentials() {
        return userCredentials;
    }
    
    /**
     * Primary mutator for the userCredentials attribute
     * @param userCredentials 
     */
    public void setUserCredentials(ArrayList<User> userCredentials) {
        this.userCredentials = userCredentials;
    }
    
    /**
     * Secondary accessor for the userCredentials attribute
     * @param userIndex index of the current
     * @return 
     */
    public User getSpecificUserCredentials(int userIndex) {
        return userCredentials.get(userIndex);
    }
   
    /**
     * Secondary mutator for the userCredentials attribute
     * @param userIndex the index of the current User
     * @param currentUser the current User object
     */
    public void setSpecificUserCredentials(int userIndex, User currentUser) {
        userCredentials.set(userIndex, currentUser);
    }
    
    /**
     * Tertiary mutator for the userCredentials attribute 
     * @param currentUser the current User object
     */
    public void addUserCredential(User currentUser) {
        userCredentials.add(currentUser);
    }
   
    // behavior methods
    
    /**
     * Finds a user in the userCredentials attribute based on the username provided as a parameter
     * @param usernameEntered the username entered by the user
     * @return 
     */
    public int findUser(String usernameEntered) {
        // looping through all of the users in the userCredentials ArrayList to check if we have a User with the username provided
        for (int i = 0; i < userCredentials.size(); i++) {

            // checking if the current user has the username that we are looking for 
            if (userCredentials.get(i).getUsername().equals(usernameEntered)) {

                // if a match is found, then the current index if returned
                return i;
            }
        }

        // fall-through case for when the user with the desired username is not found at all 
        return -1;
    }

    /**
     * Validates the credentials between the password provided for a specific U
     * @param userIndex the index of the User object
     * @param passwordEntered the password the User entered
     * @return 
     */
    public boolean validateCredentials(int userIndex, String passwordEntered) {
        return userCredentials.get(userIndex).getPassword().equals(passwordEntered);
    }
    
    // standard methods
    
    /**
     * Standard Java toString method
     * @return toDisplay a string containing information about the current LoginPortal object
     */
    public String toString() {
        String toDisplay = super.toString() + " LoginPortal, User Credentials: " + userCredentials;
        return toDisplay;
    }
    
    /**
     * Standard Java equals() method
     * @param otherLoginPortal the other LoginPortal object being compared to
     * @return a boolean representing whether both LoginPortal objects are identical or not
     */
    public boolean equals(LoginPortal otherLoginPortal) {
        return super.equals(otherLoginPortal) && userCredentials.equals(otherLoginPortal.getUserCredentials());
    }
    
    /**
     * Standard Java clone() method 
     * @return currentLoginPortal an identical LoginPortal object to the current LoginPortal object
     */
    public LoginPortal clone() {
        return new LoginPortal(getMenuName(), userCredentials);
    }

}