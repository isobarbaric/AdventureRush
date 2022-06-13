package adventurerush;

import loginportal.LoginPortalPrimaryWindow;

public class Game {
    
    // attributes of a Game object
    private String gameName;
    private LoginPortalPrimaryWindow currentTest;
    
    // constructors
    
    /**
     * Default constructor
     */
    public Game() {
        // initializing the currentTest attribute
        currentTest = new LoginPortalPrimaryWindow();
        // initializing the gameName attribute
        gameName = new String();
    }
    
    /**
     * Primary constructor
     * @param gameName the name of the Game object
     */
    public Game(String gameName) {
        // chaining constructors
        this();
        // initializing the gameName attribute with the provided gameName attribute
        this.gameName = gameName;
    }

    // getters
    
    /**
     * Accessor for the gameName attribute
     * @return the name of the Game object
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Accessor for the currentTest attribute
     * @return the main LoginPortal window
     */
    public LoginPortalPrimaryWindow getCurrentTest() {
        return currentTest;
    }
    
    // setters
    
    /**
     * Mutator for the gameName attribute
     * @param gameName the name of the Game object
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Mutator for the currentTest attribute
     * @param currentTest the main LoginPortal window
     */
    public void setCurrentTest(LoginPortalPrimaryWindow currentTest) {
        this.currentTest = currentTest;
    }
    
    // standard methods

    /**
     * Standard Java toString() method
     * @return a String containing information about the Game object
     */
    @Override
    public String toString() {
        return "Game{" + "gameName=" + gameName + ", currentTest=" + currentTest + '}';
    }

    /**
     * Standard Java equals() method
     * @param otherGame the other Game object being compared to
     * @return whether the two Game objects are identical or not
     */
    public boolean equals(Game otherGame) {
        return gameName.equals(otherGame.getCurrentTest());
    }
   
    /**
     * Standard Java clone() method
     * @return a new Game object that is a clone of the current Game object
     */
    public Game clone() {
        return new Game(gameName);
    }
    
}