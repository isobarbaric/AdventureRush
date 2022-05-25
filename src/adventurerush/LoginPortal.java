package adventurerush;

import java.util.ArrayList;

public class LoginPortal {

    // attributes of a LoginPortal object
    private int numTotalValidLoginAttempts;
    private int numValidLoginAttempts;
    private int numInvalidLoginAttempts;
    private ArrayList<User> userCredentials;

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
    
    @Override
    public String toString() {
        return "LoginPortal [numInvalidLoginAttempts=" + numInvalidLoginAttempts + ", numTotalValidLoginAttempts="
                + numTotalValidLoginAttempts + ", numValidLoginAttempts=" + numValidLoginAttempts + ", userCredentials="
                + userCredentials + "]";
    }
            
    // why is userCredentials available publicly bruh
    public boolean equals(LoginPortal otherLoginPortal) {
        return numTotalValidLoginAttempts == otherLoginPortal.getNumTotalValidLoginAttempts() && numValidLoginAttempts == otherLoginPortal.getNumTotalValidLoginAttempts() && numInvalidLoginAttempts == otherLoginPortal.getNumInvalidLoginAttempts() && userCredentials == otherLoginPortal.userCredentials; 
    }    

}