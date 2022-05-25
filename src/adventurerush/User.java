package adventurerush;

public class User {

    // attributes of a User object
    private String username;
    private String password;
    private int lastLevel;
    
    // constructors 
   
    public User() {
        username = new String();
        password = new String();
        lastLevel = 0;
    }
    
    public User(String username) {
        this();
        this.username = username;
    }
    
    public User(String username, String password) {
        this(username);
        this.password = password;
    }
    
    public User(String username, String password, int lastLevel) {
        this(username, password);
        this.lastLevel = lastLevel;
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
        return username.equals(otherUser.getUsername()) && password.equals(otherUser.getPassword()) && lastLevel == otherUser.getLastLevel();
    }
    
    public User clone() {
        User clonedObj = new User(username, password, lastLevel);
        return clonedObj;
    }

}
