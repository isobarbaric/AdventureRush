package adventurerush;

import game.Sprite;
import java.util.ArrayList;

public class User {

    // attributes of a User object
    private String username, password;
    private int currencyPossessed;
    private int currentFileLine;
    private ArrayList<Sprite> userSprites;
    private Sprite defaultSprite;
    
    // constructors 

    /**
     * Default constructor
     */
    public User() {
        username = new String();
        password = new String();
        currencyPossessed = 0;
        userSprites = new ArrayList();
        this.defaultSprite = new Sprite();
        userSprites.add(defaultSprite);
    }
    
    // move later
    
    public void addSprite(Sprite newSprite) {
        userSprites.add(newSprite);
    }
    
    public Sprite getDefaultSprite() {
        return defaultSprite;
    }
    
    public void setDefaultSprite(Sprite revisedSprite) {
        this.defaultSprite = revisedSprite;
    }
    
    public int getCurrentFileLine() {
        return currentFileLine;
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
     * @param currencyPossessed
     * @param userSprites 
     */
    public User(String username, String password, int currentFileLine, int currencyPossessed, ArrayList<Sprite> userSprites) {
        this(username, password, currentFileLine);
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
     * Accessor for the password attribute
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator for the currencyPossessed attribute
     * @return 
     */
    public int getCurrencyPossessed() {
        return currencyPossessed;
    }
    
    /**
     * Mutator for the userSprites attribute
     * @return 
     */
    public ArrayList<Sprite> getSprites() {
        return userSprites;
    }
    
    // setters
    
    /**
     * Mutator for the username attribute
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Mutator for the password attribute
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Mutator for the currencyPossessed attribute
     * @param currencyPossessed 
     */
    public void setCurrencyPossessed(int currencyPossessed) {
        this.currencyPossessed = currencyPossessed;
    }

    /**
     * Mutator for the userSprites attribute
     * @param userSprites
     */
    public void setSprites(ArrayList<Sprite> userSprites) {
        this.userSprites = userSprites;
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
        return "User [username=" + username + ", password=" + password + "]";
    }
    
    /**
     * Standard Java equals() method
     * @param otherUser
     * @return whether or not the two User objects are identical or not
     */
    public boolean equals(User otherUser) {
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && userSprites.equals(otherUser.getSprites());
    }
    
    /**
     * Standard Java clone() method
     * @return 
     */
    @Override
    public User clone() {
        User clonedObj = new User(username, password, currentFileLine, currencyPossessed, userSprites);
        return clonedObj;
    }

}