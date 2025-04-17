package world;

import game.Game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameLoader {
    public static Game loadGame(String pathname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathname))) {
            return (Game) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load game: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
