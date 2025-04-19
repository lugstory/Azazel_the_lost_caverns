package fighting;

import fighting.attacks.enemy.EnemyAttack;
import fighting.attacks.player.PlayerAttack;
import game.Game;
import game.Player;
import world.npcs.Enemy;

import java.util.List;
import java.util.Scanner;

public class CombatManager {
    public static void pressEnter() {
        System.out.println("Press ENTER to continue.");
        new Scanner(System.in).nextLine();
    }

    public static void startCombat(Game game, Enemy enemy, Scanner scanner) {
        Player player = game.getPlayer();

        System.out.println("Starting a fight with " + enemy.getName());

        while (enemy.getHealth() > 0 && player.getHealth() > 0) {

            // Player's turn
            System.out.println("\n--- Your turn ---");
            List<PlayerAttack> attacks = player.getAttacks();
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println((i + 1) + ": " + attacks.get(i).getName());
            }

            int choice;
            while (true) {
                try {
                    System.out.print("Pick the attack (1-" + attacks.size() + "): ");
                    choice = Integer.parseInt(scanner.nextLine());

                    // Zkontroluj, zda je číslo v požadovaném rozsahu
                    if (choice >= 1 && choice <= attacks.size()) {
                        break;  // Pokud je volba platná, ukončíme smyčku
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + attacks.size() + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            PlayerAttack chosenAttack = attacks.get(choice - 1);
            boolean success = chosenAttack.execute(game.getPlayer(), enemy);

            if (success) {
                enemy.setHealth(enemy.getHealth() - chosenAttack.getDamage());
                System.out.println("You had done " + chosenAttack.getDamage() + " damage!");
                pressEnter();
            } else {
                System.out.println("You missed!");
            }

            if (enemy.getHealth() <= 0) {
                System.out.println("\nThe enemy " + enemy.getName() + " was killed!");
                enemy.onDeath(game);
                game.getCurrentRoom().removeNpc(enemy);
                player.reduceActiveItemCooldown();
                pressEnter();
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
            pressEnter();
        }
    }
}
