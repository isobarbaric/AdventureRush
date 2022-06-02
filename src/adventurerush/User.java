package adventurerush;

import game.Sprite;
import java.util.ArrayList;

public class User {

    // attributes of a User object
    private String username;
    private String password;
    private int lastLevel;
    private int currencyPossessed;
    private ArrayList<Sprite> userSprites;
    
    // constructors 
   
    public User() {
        username = new String();
        password = new String();
        lastLevel = 0;
        currencyPossessed = 0;
        userSprites = new ArrayList();
        // load in default Sprite
    }
    
    public User(String username) {
        this();
        this.username = username;
    }
    
    public User(String username, String password) {
        this(username);
        this.password = password;
    }
    
    public User(String username, String password, int lastLevel, int currencyPossessed, boolean sprite1, boolean sprite2, boolean sprite3) {
        this(username, password);
        this.lastLevel = lastLevel;
        this.currencyPossessed = currencyPossessed;
    }
    
    // getters
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getLastLevel() {
        return lastLevel;
    }
    
    public int getCurrencyPossessed() {
        return currencyPossessed;
    }
    
    // setters
        
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }
    
    public void setCurrencyPossessed(int currencyPossessed) {
        this.currencyPossessed = currencyPossessed;
    }
    
    // behavior
    
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
     * Standard Java equals () method
     * @param otherUser
     */
    public boolean equals(User otherUser) {
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && lastLevel == otherUser.getLastLevel() && sprite1 == otherUser.getSprite2() && sprite2 == otherUser.getSprite2() && sprite3 == otherUser.getSprite3();
    }
    
    /**
     * Standard Java clone() method
     */
    public User clone() {
        User clonedObj = new User(username, password, lastLevel, currencyPossessed, sprite1, sprite2, sprite3);
        return clonedObj;
    }

}
