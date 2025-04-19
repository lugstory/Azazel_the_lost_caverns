package world;

import fighting.attacks.enemy.*;
import fighting.attacks.player.BasicAttack;
import fighting.attacks.player.HeavySmash;
import fighting.attacks.player.LuckyShot;
import items.Item;
import items.active.HealingPotion;
import items.passive.Bomb;
import items.passive.Key;
import items.passive.SpiderAmulet;
import world.npcs.Enemy;
import world.npcs.NPC;
import world.npcs.enemies.SecretGuy;
import world.rooms.Room;
import world.rooms.Type;
import game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelBuilder {

    public static Game buildLevel() {
        Game game = new Game(null,null);

        // Útoky
        EnemyAttack bite = new Bite();
        EnemyAttack toxicSpit = new ToxicSpit();
        EnemyAttack arrowShot = new ArrowShot();
        EnemyAttack fireball = new Fireball();

        // Nepřátelé
// Giant Spider
        List<EnemyAttack> spiderAttacks = new ArrayList<>();
        spiderAttacks.add(bite);
        spiderAttacks.add(toxicSpit);
        Enemy spider = new Enemy("Giant Spider", 10, spiderAttacks, "Screee!") {
            @Override
            public void onDeath(Game game) {

            }
        };

// Goblin Warrior
        List<EnemyAttack> goblinAttacks = new ArrayList<>();
        goblinAttacks.add(toxicSpit);
        Enemy goblin = new Enemy("Goblin Warrior", 12, goblinAttacks) {
            @Override
            public void onDeath(Game game) {

            }
        };

// Skeleton Archer
        List<EnemyAttack> skeletonAttacks = new ArrayList<>();
        skeletonAttacks.add(arrowShot);
        Enemy skeleton = new Enemy("Skeleton Archer", 9, skeletonAttacks) {
            @Override
            public void onDeath(Game game) {

            }
        };

// Ancient Dragon (Boss)
        List<EnemyAttack> dragonAttacks = new ArrayList<>();
        dragonAttacks.add(fireball);
        dragonAttacks.add(toxicSpit);
        dragonAttacks.add(arrowShot);
        Enemy dragon = new Enemy("Ancient Dragon", 50, dragonAttacks, "You dare challenge me?") {
            @Override
            public void onDeath(Game game) {

            }
        };


        // Předměty
        Item potion = new HealingPotion();
        Item amulet = new SpiderAmulet();

        // Místnosti
        List<Room> rooms = new ArrayList<>(8);

// Room 0 - Entrance Hall
        List<Item> items0 = new ArrayList<>();
        List<NPC> npcs0 = new ArrayList<>();
        npcs0.add(new SecretGuy());
        List<Integer> neighbors0 = new ArrayList<>(4);
        neighbors0 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors0.set(0,1);
        rooms.add(new Room(game, "Entrance Hall", Type.SMALL, items0, npcs0, neighbors0));
        ArrayList<Chest> chests = new ArrayList<>();
        List<Item> itemss = new ArrayList<>();
        itemss.add(new Key());
        Chest chest = new Chest(itemss);
        chests.add(chest);
        rooms.get(0).setChests(chests);

// Room 1 - Spider Nest
        List<Item> items1 = new ArrayList<>();
        items1.add(amulet);
        List<NPC> npcs1 = new ArrayList<>();
        npcs1.add(spider);
        List<Integer> neighbors1 = new ArrayList<>(4);
        neighbors1 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors1.set(0,0);
        rooms.add(new Room(game, "Spider Nest", Type.SMALL, items1, npcs1, neighbors1));
/*
// Room 2 - Goblin Tunnels
        List<Item> items2 = new ArrayList<>();
        items2.add(potion);
        List<NPC> npcs2 = new ArrayList<>();
        npcs2.add(goblin);
        List<Integer> neighbors2 = new ArrayList<>();
        neighbors2.add(0);
        neighbors2.add(4);
        rooms[2] = new Room(game, "Goblin Tunnels", Type.SMALL, items2, npcs2, neighbors2);

// Room 3 - Collapsed Passage
        List<Item> items3 = new ArrayList<>();
        List<NPC> npcs3 = new ArrayList<>();
        List<Integer> neighbors3 = new ArrayList<>();
        neighbors3.add(1);
        neighbors3.add(5);
        rooms[3] = new Room(game, "Collapsed Passage", Type.SMALL, items3, npcs3, neighbors3);

// Room 4 - Skeleton Crypt
        List<Item> items4 = new ArrayList<>();
        List<NPC> npcs4 = new ArrayList<>();
        npcs4.add(skeleton);
        List<Integer> neighbors4 = new ArrayList<>();
        neighbors4.add(2);
        neighbors4.add(6);
        rooms[4] = new Room(game, "Skeleton Crypt", Type.SMALL, items4, npcs4, neighbors4);

// Room 5 - Shrine of Healing
        List<Item> items5 = new ArrayList<>();
        items5.add(new HealingPotion());
        List<NPC> npcs5 = new ArrayList<>();
        List<Integer> neighbors5 = new ArrayList<>();
        neighbors5.add(3);
        rooms[5] = new Room(game, "Shrine of Healing", Type.SMALL, items5, npcs5, neighbors5);

// Room 6 - Hall of Echoes
        List<Item> items6 = new ArrayList<>();
        List<NPC> npcs6 = new ArrayList<>();
        List<Integer> neighbors6 = new ArrayList<>();
        neighbors6.add(4);
        neighbors6.add(7);
        rooms[6] = new Room(game, "Hall of Echoes", Type.SMALL, items6, npcs6, neighbors6);

// Room 7 - Dragon's Lair (Boss Room)
        List<Item> items7 = new ArrayList<>();
        List<NPC> npcs7 = new ArrayList<>();
        npcs7.add(dragon);
        List<Integer> neighbors7 = new ArrayList<>();
        neighbors7.add(6);
        rooms[7] = new Room(game, "Dragon's Lair", Type.SMALL, items7, npcs7, neighbors7);

*/
        game.setAllRooms(rooms);
        game.setCurrentRoom(rooms.get(0));
        game.getPlayer().addAttack(new BasicAttack());
        game.getPlayer().addAttack(new LuckyShot());
        game.getPlayer().addAttack(new HeavySmash());

        game.getPlayer().addPassiveItem(new Key());
        game.getPlayer().addPassiveItem(new Bomb());


        return game;
    }
}
