package fighting;

import fighting.attacks.EnemyAttack;
import fighting.attacks.PlayerAttack;
import game.Game;
import game.Player;
import world.npcs.Enemy;

import java.util.List;
import java.util.Scanner;

public class CombatManager {

    public void startCombat(Game game, Enemy enemy, Scanner scanner) {
        Player player = game.getPlayer();

        System.out.println("Začíná boj s nepřítelem: " + enemy.getName());

        while (enemy.getHealth() > 0 && player.getHealth() > 0) {

            // Player's turn
            System.out.println("\n--- Your turn ---");
            List<PlayerAttack> attacks = player.getAttacks();
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println((i + 1) + ": " + attacks.get(i).getName());
            }

            System.out.print("Pick the attack (1-" + attacks.size() + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;

            PlayerAttack chosenAttack = attacks.get(choice);
            boolean success = chosenAttack.execute(game.getPlayer(), enemy);

            if (success) {
                enemy.setHealth(enemy.getHealth() - chosenAttack.getDamage());
                System.out.println("You had done " + chosenAttack.getDamage() + " damage!");
            } else {
                System.out.println("You missed!");
            }

            if (enemy.getHealth() <= 0) {
                System.out.println("\nThe enemy " + enemy.getName() + " was killed!");
                player.reduceActiveItemCooldown();
                break;
            }

            // Enemy's turn
            System.out.println("\n--- Enemy's turn ---");
            EnemyAttack attack = enemy.getRandomAttack();
            System.out.println(enemy.getName() + " used the attack: " + attack.getName());
            attack.executeOnPlayer(player);

            if (player.getHealth() <= 0) {
                System.out.println("You died, try again!");
                break;
            }
        }
    }
}
