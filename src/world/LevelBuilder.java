package world;

import fighting.attacks.enemy.*;
import fighting.attacks.player.BasicAttack;
import fighting.attacks.player.HeavySmash;
import fighting.attacks.player.LuckyShot;
import game.Game;
import items.Item;
import items.active.HealingPotion;
import items.passive.*;
import world.npcs.Enemy;
import world.npcs.NPC;
import world.npcs.enemies.BigDog;
import world.npcs.enemies.Boss;
import world.npcs.enemies.Dog;
import world.npcs.enemies.Teller;
import world.rooms.BasicRoom;
import world.rooms.Room;

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
        List<Integer> neighbors0 = new ArrayList<>(4);
        neighbors0 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors0.set(1,1);
        neighbors0.set(3,3);
        rooms.add(new BasicRoom(game, "Entrance Hall", items0, npcs0, neighbors0));
        ArrayList<Chest> chests = new ArrayList<>();
        List<Item> itemss = new ArrayList<>();
        itemss.add(new Key());
        Chest chest = new Chest(itemss);
        chests.add(chest);
        rooms.get(0).setChests(chests);
// Room 1 - Spider nest
        List<Item> items1 = new ArrayList<>();
        items1.add(new SpiderAmulet());
        List<NPC> npcs1 = new ArrayList<>();
        List<Integer> neighbors1 = new ArrayList<>(4);
        neighbors1 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors1.set(2,2);
        neighbors1.set(3,0);
        rooms.add(new BasicRoom(game, "Spider Nest", items1, npcs1, neighbors1));
        ArrayList<Chest> chests1 = new ArrayList<>();
        rooms.get(1).setChests(chests1);
// Room 2 - Library
        List<Item> items2 = new ArrayList<>();
        List<NPC> npcs2 = new ArrayList<>();
        List<Integer> neighbors2 = new ArrayList<>(4);
        neighbors2 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors2.set(0,1);
        rooms.add(new BasicRoom(game, "Library", items2, npcs2, neighbors2));
        ArrayList<Chest> chests2 = new ArrayList<>();
        rooms.get(2).setChests(chests2);
// Room 3 - Dark Room
        List<Item> items3 = new ArrayList<>();
        List<NPC> npcs3 = new ArrayList<>();
        List<Integer> neighbors3 = new ArrayList<>(4);
        neighbors3 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors3.set(1,0);
        neighbors3.set(2,4);
        rooms.add(new BasicRoom(game, "Dark room", items3, npcs3, neighbors3));
        ArrayList<Chest> chests3 = new ArrayList<>();
        List<Item> itemss3 = new ArrayList<>();
        itemss3.add(new Knife());
        Chest chest3 = new Chest(itemss3);
        chests3.add(chest3);
        rooms.get(3).setChests(chests3);
// Room 4 - Dog room
        List<Item> items4 = new ArrayList<>();
        items4.add(new HealingPotion());
        List<NPC> npcs4 = new ArrayList<>();
        npcs4.add(new Dog());
        npcs4.add(new BigDog());
        List<Integer> neighbors4 = new ArrayList<>(4);
        neighbors4 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors4.set(2,8);
        neighbors4.set(3,7);
        rooms.add(new BasicRoom(game, "Dog Room", items4, npcs4, neighbors4));
        ArrayList<Chest> chests4 = new ArrayList<>();
        rooms.get(4).setChests(chests4);
// Room 5 - Cat room
        List<Item> items5 = new ArrayList<>();
        List<NPC> npcs5 = new ArrayList<>();
        List<Integer> neighbors5 = new ArrayList<>(4);
        neighbors5 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors5.set(2,6);
        rooms.add(new BasicRoom(game, "Cat room", items5, npcs5, neighbors5));
        ArrayList<Chest> chests5 = new ArrayList<>();
        rooms.get(5).setChests(chests5);
// Room 6 - A harmless passage
        List<Item> items6 = new ArrayList<>();
        List<NPC> npcs6 = new ArrayList<>();
        List<Integer> neighbors6 = new ArrayList<>(4);
        neighbors6 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors6.set(0,5);
        neighbors6.set(2,7);
        rooms.add(new BasicRoom(game, "A harmless passage", items6, npcs6, neighbors6));
        ArrayList<Chest> chests6 = new ArrayList<>();
        List<Item> itemss6 = new ArrayList<>();
        itemss6.add(new Deck());
        Chest chest6 = new Chest(itemss6);
        chests6.add(chest6);
        rooms.get(6).setChests(chests6);
// Room 7 - Depressive room
        List<Item> items7 = new ArrayList<>();
        List<NPC> npcs7 = new ArrayList<>();
        npcs7.add(new Teller());
        List<Integer> neighbors7 = new ArrayList<>(4);
        neighbors7 = new ArrayList<>(Collections.nCopies(4, null));
        neighbors7.set(0,6);
        neighbors7.set(1,4);
        neighbors7.set(2,8);
        rooms.add(new BasicRoom(game, "Depressive room", items7, npcs7, neighbors7));
        ArrayList<Chest> chests7 = new ArrayList<>();
        List<Item> itemss7 = new ArrayList<>();
        itemss7.add(new Bomb());
        Chest chest7 = new Chest(itemss7);
        chests7.add(chest7);
        rooms.get(7).setChests(chests7);
// Room 8 - Boss room
        List<Item> items8 = new ArrayList<>();
        List<NPC> npcs8 = new ArrayList<>();
        npcs8.add(new Boss());
        List<Integer> neighbors8 = new ArrayList<>(4);
        neighbors8 = new ArrayList<>(Collections.nCopies(4, null));
        rooms.add(new BasicRoom(game, "Entrance Hall", items8, npcs8, neighbors8));
        ArrayList<Chest> chests8 = new ArrayList<>();
        List<Item> itemss8 = new ArrayList<>();
        itemss8.add(new Knife());
        Chest chest8 = new Chest(itemss8);
        chests8.add(chest8);
        rooms.get(8).setChests(chests8);

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
