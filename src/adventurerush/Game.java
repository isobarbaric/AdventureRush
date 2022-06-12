package adventurerush;

import loginportal.LoginPortalPrimaryWindow;

public class Game {
    
    private String gameName;
    private LoginPortalPrimaryWindow currentTest;
    
    public Game() {
        currentTest = new LoginPortalPrimaryWindow();
    }
    
    public Game(String gameName) {
        this();
        this.gameName = gameName;
    }
    
}