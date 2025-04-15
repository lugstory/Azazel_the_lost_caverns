package fighting;

import java.util.Random;
import java.util.Scanner;

public class MiniGame {
    private boolean isTimeUp = false;
    private boolean isCorrect = false;

    public boolean startGame(int timeLimit) {
        Thread timerThread = new Thread(new TimerRunnable(timeLimit));
        timerThread.start();

        char randomChar = generateRandomChar();
        System.out.println("Zadej písmeno: " + randomChar);

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!isTimeUp) {
            if (scanner.hasNext()) {
                userInput = scanner.nextLine();
                if (userInput.length() == 1 && userInput.charAt(0) == randomChar) {
                    isCorrect = true;
                }
                break;
            }
        }

        return isCorrect;
    }

    private char generateRandomChar() {
        Random rand = new Random();
        return (char) ('a' + rand.nextInt(26)); // a-z
    }

    private class TimerRunnable implements Runnable {
        private int timeLimit;

        public TimerRunnable(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeLimit); // Po uplynutí uživatelského časového limitu
            } catch (InterruptedException e) {
                System.out.println("The game was interrupted.");
            }
            isTimeUp = true;
        }
    }
}
