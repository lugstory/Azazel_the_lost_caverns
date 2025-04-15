import fighting.attacks.enemy.BasicHit;
import fighting.attacks.enemy.EnemyAttack;
import fighting.attacks.player.BasicAttack;
import fighting.attacks.player.PlayerAttack;
import game.Game;
import game.GameLoop;
import world.npcs.NPC;
import world.npcs.enemies.Skeleton;
import world.rooms.Room;
import world.rooms.Type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Skeleton skeleton = new Skeleton();
        EnemyAttack ea = new BasicHit();
        ArrayList<EnemyAttack> attackArrayList = new ArrayList<>();
        attackArrayList.add(ea);
        skeleton.setAttacks(attackArrayList);
        List<NPC> npcs = new ArrayList<>();
        npcs.add(skeleton);
        Room ac = new Room("Skeleton room", Type.SMALL,new ArrayList<>(),npcs,new ArrayList<>());
        Room[] allRooms = new Room[]{ac};
        Game game = new Game(allRooms,ac);
        game.setCurrentRoom(ac);
        PlayerAttack pa = new BasicAttack();
        game.getPlayer().addAttack(pa);
        GameLoop loop = new GameLoop(game);
        loop.start();
    }
}