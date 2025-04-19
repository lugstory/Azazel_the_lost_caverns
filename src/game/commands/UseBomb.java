package game.commands;

import game.Game;
import items.passive.Bomb;
import items.passive.Key;
import items.passive.PassiveItem;
import world.rooms.Room;
import world.rooms.SecretRoom;
import world.rooms.UltraSecretRoom;

import java.util.Random;

public class UseBomb implements Command{
    private static final int SECRET_ROOM_CHANCE = 15;
    private static final int ULTRA_SECRET_ROOM_CHANCE = 5;


    @Override
    public void execute(Game game, String[] args) {
        if (args.length<1){
            System.out.println("Please specify what door to bomb.");
            return;
        }

        try{
            int doorId = Integer.parseInt(args[0]);
            if (doorId<0||doorId>3){
                System.out.println("Specify a valid index.");
                return;
            }
            Bomb bomb = null;

            for (PassiveItem item : game.getPlayer().getPassiveItems()) {
                if (item instanceof Bomb) {
                    bomb = (Bomb) item;
                    break;
                }
            }
            if (bomb==null){
                System.out.println("You don't have a bomb to use.");
            }else {
                System.out.println("size = "+game.getCurrentRoom().getNeighborsIndexes().size());
                boolean canGenerate = game.getCurrentRoom().getNeighborsIndexes().get(doorId) == null;
                if (!canGenerate) {
                    System.out.println("The door is open, why use a bomb?");
                } else {
                    generateSecretRooms(game,doorId);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Please specify a valid doorId.");
        }
    }
    public void generateSecretRooms(Game game, int doorId) {
        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (roll <= ULTRA_SECRET_ROOM_CHANCE) {
            Room newRoom = new UltraSecretRoom(game);
            game.addRoom(newRoom);
            newRoom.getNeighborsIndexes().set(getOppositeDirection(doorId),game.getAllRooms().indexOf(game.getCurrentRoom()));
            game.getCurrentRoom().getNeighborsIndexes().set(doorId,game.getAllRooms().indexOf(newRoom));
            //TODO zajistit spravne napojeni neighbors pri pridavani mistnosti
            System.out.println("You found an ultra secret room!");
        } else if (roll <= SECRET_ROOM_CHANCE + ULTRA_SECRET_ROOM_CHANCE) {
            Room newRoom = new SecretRoom(game);
            game.addRoom(newRoom);
            newRoom.getNeighborsIndexes().set(getOppositeDirection(doorId),game.getAllRooms().indexOf(game.getCurrentRoom()));
            game.getCurrentRoom().getNeighborsIndexes().set(doorId,game.getAllRooms().indexOf(newRoom));
        } else {
            System.out.println("You used a bomb, but it didn't lead anywhere.. :(");
        }
    }

    private static final int[] OPPOSITE = {2, 3, 0, 1};

    public int getOppositeDirection(int direction) {
        if (direction < 0 || direction > 3) {
            throw new IllegalArgumentException("Direction must be between 0 and 3.");
        }
        return OPPOSITE[direction];
    }


    @Override
    public String getUsage() {
        return "bomb <doorId> - Allows you to find secret rooms";
    }
}
