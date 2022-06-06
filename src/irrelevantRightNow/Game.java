//package game;
//
//import java.util.Arrays;
//
//public class Game {
//
//    private String gameName;
//    private GameLevel[] levels;
//    
//    private static int numberLevels;
//    
//    static {
//        numberLevels = 10;
//    }
//    
//    public Game() {
//        gameName = new String();
//        levels = new GameLevel[numberLevels];
//    }
//    
//    public Game(String gameName) {
//        this();
//        this.gameName = gameName;
//    }
//    
//    public Game(String gameName, GameLevel levels[]) {
//        this(gameName);
//        this.levels = levels;
//    }
//    
//    public String getGameName() {
//        return gameName;
//    }
//    
//    public void setGameName(String gameName) {
//        this.gameName = gameName;
//    }
//    
//    public GameLevel getSpecificGameLevels(int levelIndex) {
//        return levels[levelIndex];
//    }
//    
//    public void setSpecificGameLevels(int levelIndex, GameLevel currentLevel) {
//        levels[levelIndex] = currentLevel.clone();
//    }
//    
//    public void setGameLevels(GameLevel levels[]) {
//        this.levels = levels;
//    }
//    
//    public GameLevel[] getGameLevels() {
//        return levels;
//    }
//
//    @Override
//    public String toString() {
//        return "Game{" + "gameName=" + gameName + ", levels=" + Arrays.toString(levels) + '}';
//    }
//    
//    public boolean equals(Game otherGame) {
//        return gameName.equals(otherGame.getGameName()) && Arrays.equals(levels, otherGame.getGameLevels());
//    }
//    
//    public Game clone() {
//        Game clonedObj = new Game(gameName, levels);
//        return clonedObj;
//    }
//            
//}