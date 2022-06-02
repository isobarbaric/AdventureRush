package loginportal;

import adventurerush.Menu;
import adventurerush.User;
import java.util.ArrayList;

public class LoginPortal extends Menu {
 
    // constructors for a LoginPortal object 
    private ArrayList<User> userCredentials;

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
    
    public LoginPortal(String menuName, ArrayList<User> userCredentials) {
        this();
        this.userCredentials = userCredentials;
    }
    
    // behavior methods for a LoginPortal object

    // standard methods 

    // TODO: fix standard methods that have userCredentials variable attached to them 
    
    // getters
    
    public ArrayList<User> getUserCredentials() {
        return userCredentials;
    }
    
    public User getSpecificUserCredentials(int userIndex) {
        return userCredentials.get(userIndex);
    }

    // setters
    
    public void setUserCredentials(ArrayList<User> userCredentials) {
        this.userCredentials = userCredentials;
    }
    
    public void setSpecificUserCredentials(int userIndex, User currentUser) {
        userCredentials.set(userIndex, currentUser);
    }
    
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
        LoginPortal currentLoginPortal = new LoginPortal(getMenuName(), userCredentials);
        return currentLoginPortal;
    }
        
}