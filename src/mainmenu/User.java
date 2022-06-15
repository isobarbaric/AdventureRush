package mainmenu;

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
        // initializing username
        username = new String();

        // initializing password
        password = new String();

        // initializing the number of coins
        currencyPossessed = 0;

        // initializing the userSprites attribute
        userSprites = new ArrayList();

        // initializing the defaultSprite
        this.defaultSprite = new Sprite();

        // adding the default Sprite to the list of user sprites
        userSprites.add(defaultSprite);
    }
    
    /**
     * Primary constructor
     * @param username name of the User ohject
     * @param currentFileLine current file line
     */
    public User(String username, int currentFileLine) {
        // chaining of constructors
        this();

        // initializing username
        this.username = username;

        // initializing currentFileLine
        this.currentFileLine = currentFileLine;
    }
    
    /**
     * Secondary constructor
     * @param username name of the User object
     * @param password password for the User object
     * @param currentFileLine current file line
     */
    public User(String username, String password, int currentFileLine) {
        // chaining of constructors
        this(username, currentFileLine);
 
        // initializing password
        this.password = password;
    }
    
    /**
     * Tertiary constructor
     * @param username name of the user object
     * @param password password for the User object
     * @param currentFileLine current file line
     * @param currencyPossessed number of coins the Sprite has
     * @param userSprites the collection of Sprites the user has
     */
    public User(String username, String password, int currentFileLine, int currencyPossessed, ArrayList<Sprite> userSprites) {
        // chaining of constructors
        this(username, password, currentFileLine);

        // initializing number of coins
        this.currencyPossessed = currencyPossessed;

        // initializing userSprites
        this.userSprites = userSprites;
    }
    
    // getters and setters
    
    /**
     * Accessor for the username attribute
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Accessor for the password attribute
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator for the currencyPossessed attribute
     * @return currencyPossessed
     */
    public int getCurrencyPossessed() {
        return currencyPossessed;
    }
    
    /**
     * Mutator for the userSprites attribute
     * @return userSprites the ArrayList of sprites the current user has 
     */
    public ArrayList<Sprite> getSprites() {
        return userSprites;
    }
    
    // setters
    
    /**
     * Mutator for the username attribute
     * @param username User's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Mutator for the password attribute
     * @param password User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Mutator for the currencyPossessed attribute
     * @param currencyPossessed number of coins
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

    /**
     * Mutator for the userSprites attribute
     * @param newSprite 
     */
    public void addSprite(Sprite newSprite) {
        userSprites.add(newSprite);
    }
    
    /**
     * Accessor for the defaultSprite attribute
     * @return 
     */
    public Sprite getDefaultSprite() {
        return defaultSprite;
    }
    
    /**
     * Mutator for the defaultSprite attribute
     * @param revisedSprite 
     */
    public void setDefaultSprite(Sprite revisedSprite) {
        this.defaultSprite = revisedSprite;
    }
    
    /**
     * Accessor for the currentFileLine attribute
     * @return currentFileLine
     */
    public int getCurrentFileLine() {
        return currentFileLine;
    }
    
    // behavior 
    
    /**
     * Returns whether the login credentials provided successfully identify the current User object
     * @param usernameProvided the username provided to check/compare with 
     * @param passwordProvided the password provided to check/compare with
     * @return 
     */
    public boolean checkLoginCredentials(String usernameProvided, String passwordProvided) {
        return username.equals(usernameProvided) && password.equals(passwordProvided);
    }

    // standard methods 

    /**
     * Standard Java toString() method
     * @return a string containing information about the current User object
     */
    @Override 
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
    
    /**
     * Standard Java equals() method
     * @param otherUser the other User being compared to
     * @return whether or not the two User objects are identical or not
     */
    public boolean equals(User otherUser) {
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && userSprites.equals(otherUser.getSprites());
    }
    
    /**
     * Standard Java clone() method
     * @return an identical User object
     */
    @Override
    public User clone() {
        return new User(username, password, currentFileLine, currencyPossessed, userSprites);
    }

}