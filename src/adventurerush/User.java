package adventurerush;

import game.Sprite;
import java.util.ArrayList;

public class User {

    // attributes of a User object
    private String username;
    private String password;
    private int lastLevel;
    private int currencyPossessed;
    private int currentFileLine;
    private ArrayList<Sprite> userSprites;
    
    // constructors 

    /**
     * Default constructor
     */
    public User() {
        username = new String();
        password = new String();
        lastLevel = 0;
        currencyPossessed = 0;
        userSprites = new ArrayList();
        // todo: add code to load in default Sprite
    }
    
    /**
     * Primary constructor
     * @param username
     * @param currentFileLine 
     */
    public User(String username, int currentFileLine) {
        this();
        this.username = username;
        this.currentFileLine = currentFileLine;
    }
    
    /**
     * Secondary constructor
     * @param username
     * @param password
     * @param currentFileLine 
     */
    public User(String username, String password, int currentFileLine) {
        this(username, currentFileLine);
        this.password = password;
    }
    
    /**
     * Tertiary constructor
     * @param username
     * @param password
     * @param currentFileLine
     * @param lastLevel
     * @param currencyPossessed
     * @param userSprites 
     */
    public User(String username, String password, int currentFileLine, int lastLevel, int currencyPossessed, ArrayList<Sprite> userSprites) {
        this(username, password, currentFileLine);
        this.lastLevel = lastLevel;
        this.currencyPossessed = currencyPossessed;
        this.userSprites = userSprites;
    }
    
    /**
     * Accessor for the username attribute
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Mutator for the username attribute
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
            
    /**
     * Accessor for the password attribute
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator for the password attribute
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Accessor for the lastLevel attribute 
     * @return lastLevel
     */
    public int getLastLevel() {
        return lastLevel;
    }
    
    /**
     * Mutator for the lastLevel attribute
     * @param lastLevel 
     */
    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }
    
    /**
     * Accessor for the currencyPossessed attribute
     * @return currencyPossessed
     */
    public int getCurrencyPossessed() {
        return currencyPossessed;
    }

    /**
     * Mutator for the currencyPossessed attribute
     * @param currencyPossessed 
     */
    public void setCurrencyPossessed(int currencyPossessed) {
        this.currencyPossessed = currencyPossessed;
    }

    // behavior 
    
    /**
     * Returns whether the login credentials provided successfully identify the current User object
     * @param usernameProvided
     * @param passwordProvided
     * @return 
     */
    public boolean checkLoginCredentials(String usernameProvided, String passwordProvided) {
        return username.equals(usernameProvided) && password.equals(passwordProvided);
    }

    // standard methods 

    /**
     * Standard Java toString() method
     * @return 
     */
    @Override 
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", lastLevel=" + lastLevel + "]";
    }
    
    /**
     * Standard Java equals() method
     * @param otherUser
     * @return whether or not the two User objects are identical or not
     */
    public boolean equals(User otherUser) {
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && lastLevel == otherUser.getLastLevel();
    }
    
    /**
     * Standard Java clone() method
     */
    @Override
    public User clone() {
        User clonedObj = new User(username, password, currentFileLine, lastLevel, currencyPossessed, userSprites);
        return clonedObj;
    }

}
