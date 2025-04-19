package items.passive;

import game.Player;

public class Deck extends PassiveItem{
    public Deck() {
        super("A deck of cards", "A big gambling problem");
    }
    @Override
    public void applyEffect(Player player){
        System.out.println("You learned how to effectively gamble, +5 luck");
        player.setLuck(player.getLuck()+5);
    }
}
