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

            // Tah hráče
            System.out.println("\n--- Tvůj tah ---");
            List<PlayerAttack> attacks = player.getAttacks();
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println((i + 1) + ": " + attacks.get(i).getName());
            }

            System.out.print("Zvol útok (1-" + attacks.size() + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;

            PlayerAttack chosenAttack = attacks.get(choice);
            boolean success = chosenAttack.execute(game.getPlayer(), enemy);

            if (success) {
                enemy.setHealth(enemy.getHealth() - chosenAttack.getDamage());
                System.out.println("Způsobil jsi " + chosenAttack.getDamage() + " poškození!");
            } else {
                System.out.println("Minul jsi!");
            }

            if (enemy.getHealth() <= 0) {
                System.out.println("\nNepřítel " + enemy.getName() + " byl poražen!");
                player.reduceActiveItemCooldown();
                break;
            }

            // Tah nepřítele
            System.out.println("\n--- Tah nepřítele ---");
            EnemyAttack attack = enemy.getRandomAttack();
            System.out.println(enemy.getName() + " použil útok: " + attack.getName());
            attack.executeOnPlayer(player);

            if (player.getHealth() <= 0) {
                System.out.println("Byl jsi poražen... Nasťa pláče 💔");
                break;
            }
        }
    }
}
