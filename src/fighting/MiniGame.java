package fighting;

import java.util.Random;
import java.util.Scanner;

/**
 * A class used for the start() method.
 * A minigame class that involves the player to type a specific letter.
 */
public class MiniGame {

    public static boolean start(int timeInSeconds) {
        // Generating a character
        char randomChar = generateRandomChar();

        // Making and starting the timer
        Timer timer = new Timer(timeInSeconds * 1000L); // Předáme čas v milisekundách
        timer.start();

        // Typing the letter
        System.out.println("Type the following letter: " + randomChar);

        // Reading the input in a different Thread
        Scanner scanner = new Scanner(System.in);
        String input = "";

        long startTime = System.currentTimeMillis();
        long maxTime = timeInSeconds * 1000L; // Maximum time for response in milliseconds

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
            if (!start(timeInSeconds)) {
                return false;
            }
            rounds--;
        }
        return true;
    }

    private static char generateRandomChar() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26)); // Generates letters a-z
    }

    static class Timer extends Thread {
        private boolean timeUp = false;
        private final long timeLimit;

        // Constructor that accepts the time limit in milliseconds
        public Timer(long timeLimit) {
            this.timeLimit = timeLimit;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeLimit); // Timer runs for the given time
                timeUp = true;
                System.out.println("Time's up!\nPress ENTER to continue.");
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