import game.Game;
import game.GameLoop;
import world.GameLoader;
import world.GameSaver;
import world.LevelBuilder;

public class Main {
    public static void main(String[] args) {
        //GameSaver.saveGame(LevelBuilder.buildLevel(),"level1.azaz");
        Game game = LevelBuilder.buildLevel();
        GameLoop gameLoop = new GameLoop(game);
        gameLoop.start();
    }
}