package world;

import game.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameSaver {

    public static void saveGame(Game game, String pathname) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathname))) {
            oos.writeObject(game);
            System.out.println("Game saved successfully to " + pathname);
        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
