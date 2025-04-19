package world;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import fighting.attacks.enemy.*;
import fighting.attacks.player.*;
import game.Game;
import items.Item;
import items.active.HealingPotion;
import items.passive.*;
import world.npcs.Enemy;
import world.npcs.NPC;
import world.npcs.enemies.*;
import world.rooms.BasicRoom;
import world.rooms.Room;
import world.rooms.SecretRoom;
import world.rooms.UltraSecretRoom;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * JsonManager is responsible for serializing and deserializing objects to and from JSON format.
 * It utilizes the Gson library to handle different types of objects (NPCs, rooms, items, attacks) by registering type adapters.
 */
public class JsonManager {
    private final Gson gson;

    public JsonManager() {
        // ---------- START OF FACTORIES ----------

        RuntimeTypeAdapterFactory<NPC> npcFactory = RuntimeTypeAdapterFactory
                .of(NPC.class, "type")
                .registerSubtype(Enemy.class, "enemy")
                .registerSubtype(SecretGuy.class, "secretGuy")
                .registerSubtype(Teller.class,"teller")
                .registerSubtype(Boss.class,"boss")
                .registerSubtype(Dog.class,"dog")
                .registerSubtype(Cat.class,"cat")
                .registerSubtype(BigDog.class,"bigDog")
                .registerSubtype(BigCat.class,"bigCat")
                ;

        RuntimeTypeAdapterFactory<Room> roomFactory = RuntimeTypeAdapterFactory
                .of(Room.class, "roomType")
                .registerSubtype(BasicRoom.class,"basicRoom")
                .registerSubtype(SecretRoom.class, "secretRoom")
                .registerSubtype(UltraSecretRoom.class,"ultraSecretRoom");

        RuntimeTypeAdapterFactory<Item> itemFactory = RuntimeTypeAdapterFactory
                .of(Item.class, "type")
                //active
                .registerSubtype(HealingPotion.class,"healingPotion")
                //passive
                .registerSubtype(Bomb.class,"bomb")
                .registerSubtype(Key.class,"key")
                .registerSubtype(Knife.class,"knife")
                .registerSubtype(SpiderAmulet.class,"spiderAmulet")
                .registerSubtype(Water.class,"water")
                .registerSubtype(Book.class,"book")
                .registerSubtype(Deck.class,"deck");


        RuntimeTypeAdapterFactory<EnemyAttack> enemyAttackFactory = RuntimeTypeAdapterFactory
                .of(EnemyAttack.class, "type")
                .registerSubtype(ArrowShot.class, "arrowShot")
                .registerSubtype(BasicHit.class,"basicHit")
                .registerSubtype(Bite.class,"bite")
                .registerSubtype(Blessing.class,"blessing")
                .registerSubtype(Fireball.class,"fireball")
                .registerSubtype(GroundSmash.class,"groundSmash")
                .registerSubtype(ToxicSpit.class,"toxicSpit");

        RuntimeTypeAdapterFactory<PlayerAttack> playerAttackFactory = RuntimeTypeAdapterFactory
                .of(PlayerAttack.class, "type")
                .registerSubtype(BasicAttack.class, "basicAttack")
                .registerSubtype(HeavySmash.class,"heavySmash")
                .registerSubtype(LuckyShot.class,"luckyShot")
                .registerSubtype(QuickStrike.class,"quickStrike")
                .registerSubtype(Stab.class,"stab");

        // ---------- END OF FACTORIES ----------

        //makes the gson object with custom options
        gson = new GsonBuilder()
                .registerTypeAdapterFactory(npcFactory)
                .registerTypeAdapterFactory(roomFactory)
                .registerTypeAdapterFactory(itemFactory)
                .registerTypeAdapterFactory(enemyAttackFactory)
                .registerTypeAdapterFactory(playerAttackFactory)
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    public <T> String toJson(T object) {
        return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public <T> void saveToFile(String path, T object) throws IOException {
        String json = gson.toJson(object);
        Files.writeString(Paths.get(path), json);
    }

    /**
     * Loads an object from JSON
     * @param path path to the file
     * @param clazz class to be loaded
     * @return the loaded object
     * @throws IOException if file not found or not enough permissions
     */
    public <T> T loadFromFile(String path, Class<T> clazz) throws IOException {
        String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        T o = gson.fromJson(json, clazz);
        //To not run into problems with a circular reference, the game object gets set here.
        if (o instanceof Game){
            for (Room room : ((Game) o).getAllRooms()){
                ((Game) o).setCurrentRoom(((Game) o).getAllRooms().getFirst());
                room.setGame((Game)o);
            }
        }

        return o;
    }

    public <T> T loadFromFile(String path, Type type) throws IOException {
        String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        return gson.fromJson(json, type);
    }
}
