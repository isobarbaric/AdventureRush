package adventurerush;

import game.Sprite;

public class User {

    // attributes of a User object
    private String username;
    private String password;
    private int lastLevel;
    private int currencyPossessed;
    private Sprite userSprites[];
    private boolean sprite1;
    private boolean sprite2;
    private boolean sprite3;
    
    // constructors 
   
    public User() {
        username = new String();
        password = new String();
        lastLevel = 0;
        currencyPossessed = 0;
        userSprites = new Sprite[3];
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
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        
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
    
    public boolean getSprite1() {
        
        return sprite1;
        
    }
    
    public boolean getSprite2() {
        
        return sprite2;
        
    }
    
    public boolean getSprite3() {
        
        return sprite3;
        
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
    
    public void setSprite1(boolean sprite) {
        
        sprite1 = sprite;
        
    }
    
    public void setSprite2(boolean sprite) {
        
        sprite2 = sprite;
        
    }
    
    public void setSprite3(boolean sprite) {
        
        sprite3 = sprite;
        
    }
    
    // behavior
    
    public boolean checkLoginCredentials(String usernameProvided, String passwordProvided) {
        return username.equals(usernameProvided) && password.equals(passwordProvided);
    }

    // standard methods 

    @Override // change order of attributes 
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", lastLevel=" + lastLevel + "]";
    }
    
    public boolean equals(User otherUser) {
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && lastLevel == otherUser.getLastLevel() && sprite1 == otherUser.getSprite2() && sprite2 == otherUser.getSprite2() && sprite3 == otherUser.getSprite3();
    }
    
    public User clone() {
        User clonedObj = new User(username, password, lastLevel, currencyPossessed, sprite1, sprite2, sprite3);
        return clonedObj;
    }

}
