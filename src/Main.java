import game.Game;
import game.GameLoop;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(); // zde bys později např. nahrál data z JSONu
        GameLoop loop = new GameLoop(game);
        loop.start();
    }
}