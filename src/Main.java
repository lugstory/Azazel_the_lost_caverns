import game.Game;
import game.GameLoop;
import world.JsonManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*Game game = LevelBuilder.buildLevel();
        JsonManager jm = new JsonManager();
        try {
            jm.saveToFile("json.json",game);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Game game;
        try {
            game = new JsonManager().loadFromFile("json.json",Game.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome, Azazel, to the lost caverns, try to get out!");
        GameLoop gameLoop = new GameLoop(game);
        gameLoop.start();
    }
}