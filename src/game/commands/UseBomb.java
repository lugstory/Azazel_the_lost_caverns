package game.commands;

import game.Game;
import items.passive.Bomb;
import items.passive.PassiveItem;
import world.rooms.Room;
import world.rooms.SecretRoom;
import world.rooms.UltraSecretRoom;

import java.util.Random;

/**
 * Command to use a bomb to potentially open a secret or ultra-secret room.
 * The player can choose a door to bomb and reveal hidden rooms.
 */
public class UseBomb implements Command {
    private static final int SECRET_ROOM_CHANCE = 15; // Chance to generate a SecretRoom
    private static final int ULTRA_SECRET_ROOM_CHANCE = 5; // Chance to generate an UltraSecretRoom

    /**
     * Executes the use of a bomb on a specified door.
     * If the door is closed (null in neighbors list), a secret or ultra-secret room is generated.
     * If the door is already open, the bomb is not used.
     *
     * @param game The current game state.
     * @param args The command arguments, where args[0] is the door index to bomb.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify what door to bomb.");
            return;
        }

        try {
            int doorId = Integer.parseInt(args[0]);
            if (doorId < 0 || doorId > 3) {
                System.out.println("Specify a valid index.");
                return;
            }

            Bomb bomb = null;
            // Check if the player has a bomb in their inventory
            for (PassiveItem item : game.getPlayer().getPassiveItems()) {

                if (item.getName().equalsIgnoreCase("bomb")) {
                    int index = game.getPlayer().getPassiveItems().indexOf(item);
                    game.getPlayer().getPassiveItems().set(index,new Bomb());
                    bomb = (Bomb)game.getPlayer().getPassiveItems().get(index);
                    break;
                }
            }

            if (bomb == null) {
                System.out.println("You don't have a bomb to use.");
            } else {
                boolean canGenerate = game.getCurrentRoom().getNeighborsIndexes().get(doorId) == null;
                if (!canGenerate) {
                    System.out.println("The door is open, why use a bomb?");
                } else {
                    game.getPlayer().getPassiveItems().remove(bomb);
                    generateSecretRooms(game, doorId); // Generate secret rooms if the door is closed
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Please specify a valid doorId.");
        }
    }

    /**
     * Generates a secret or ultra-secret room based on a random roll and connects it to the current room.
     *
     * @param game    The current game state.
     * @param doorId  The door index that the bomb is used on.
     */
    public void generateSecretRooms(Game game, int doorId) {
        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (roll <= ULTRA_SECRET_ROOM_CHANCE) {
            Room newRoom = new UltraSecretRoom(game);
            game.addRoom(newRoom);
            newRoom.getNeighborsIndexes().set(getOppositeDirection(doorId), game.getAllRooms().indexOf(game.getCurrentRoom()));
            game.getCurrentRoom().getNeighborsIndexes().set(doorId, game.getAllRooms().indexOf(newRoom));
            System.out.println("You found an ultra secret room!");
        } else if (roll <= SECRET_ROOM_CHANCE + ULTRA_SECRET_ROOM_CHANCE) {
            Room newRoom = new SecretRoom(game);
            game.addRoom(newRoom);
            newRoom.getNeighborsIndexes().set(getOppositeDirection(doorId), game.getAllRooms().indexOf(game.getCurrentRoom()));
            game.getCurrentRoom().getNeighborsIndexes().set(doorId, game.getAllRooms().indexOf(newRoom));
            System.out.println("You found a secret room!");
        } else {
            System.out.println("You used a bomb, but it didn't lead anywhere.. :(");
        }
    }

    /**
     * Returns the opposite direction index for a given door.
     * For example, if the direction is 0 (north), the opposite is 2 (south).
     *
     * @param direction The direction index (0-3).
     * @return The opposite direction index.
     */
    private static final int[] OPPOSITE = {2, 3, 0, 1};

    public int getOppositeDirection(int direction) {
        if (direction < 0 || direction > 3) {
            throw new IllegalArgumentException("Direction must be between 0 and 3.");
        }
        return OPPOSITE[direction];
    }

    /**
     * Provides the usage instructions for the use bomb command.
     *
     * @return The string describing how to use the bomb command.
     */
    @Override
    public String getUsage() {
        return "bomb <doorId> - Allows you to find secret rooms";
    }
}
