package fighting;

import java.util.Random;
import java.util.Scanner;

public class MiniGame {

    public static void main(String[] args) {
        int timeInSeconds = 5; // nastavíš požadovaný čas v sekundách
        if (start(timeInSeconds)) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }

    public static boolean start(int timeInSeconds) {
        // Generování náhodného písmena
        char randomChar = generateRandomChar();

        // Vytvoření a spuštění časovače
        Timer timer = new Timer(timeInSeconds * 1000); // Předáme čas v milisekundách
        timer.start();

        // Vytisknutí písmena
        System.out.println("Type the following letter: " + randomChar);

        // Čtení vstupu uživatele v samostatném vlákně
        Scanner scanner = new Scanner(System.in);
        String input = "";

        long startTime = System.currentTimeMillis();
        long maxTime = timeInSeconds * 1000; // Maximální čas pro odpověď v milisekundách

        while (System.currentTimeMillis() - startTime < maxTime) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                break;
            }
        }

        timer.stopTimer();

        return input.length() == 1 && input.charAt(0) == randomChar;
    }
    public static boolean startMultiple(int timeInSeconds, int rounds) {
        while (rounds > 0) {
            if(!start(timeInSeconds)){
                return false;
            };
            rounds--;
        }
        return true;
    }

    private static char generateRandomChar() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26)); // Generuje písmena a-z
    }

    static class Timer extends Thread {
        private boolean timeUp = false;
        private final long timeLimit;

        // Konstruktor, který přijímá časový limit v milisekundách
        public Timer(long timeLimit) {
            this.timeLimit = timeLimit;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeLimit); // Časovač trvá zadaný čas
                timeUp = true;
                if (timeUp) {
                    System.out.println("Time's up!\nPress ENTER to continue.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void stopTimer() {
            this.interrupt();
        }

        public boolean isTimeUp() {
            return timeUp;
        }
    }
}
