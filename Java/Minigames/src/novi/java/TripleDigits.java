package novi.java;

import java.util.Random;

import static novi.java.Main.PLAYERINPUT;

public class TripleDigits {

    private int safeCodeA;
    private int safeCodeB;
    private int safeCodeC;

    private int safeCodeSum;
    private int safeCodeProduct;

    private Player player;
    private Random random;

    private int maxRounds;

    public TripleDigits(Player player, int rounds) {
        this.player = player;

        random = new Random();
        maxRounds = rounds;
    }

    public void play() {
        int round = 1;
        while(round <= maxRounds) {

            // Stel vraag wat zijn de 3 getallen?
            System.out.println("Round: " + round);
            System.out.println("What are the 3 digits of the safe?");

            generateDigits(round);
            // Vragen aan de speler om de getallen in te voeren
            System.out.println("Enter the 3 digits now:");

            // Krijg de getallen van de speler
            try {
                int playerGuessA = PLAYERINPUT.nextInt();
                int playerGuessB = PLAYERINPUT.nextInt();
                int playerGuessC = PLAYERINPUT.nextInt();

                if (isInputValid(playerGuessA, playerGuessB, playerGuessC)) {

                    System.out.println("Gegeven antwoord is: " + playerGuessA + " " + playerGuessB + " " + playerGuessC);

                    int playerGuessSum = playerGuessA + playerGuessB + playerGuessC;
                    int playerGuessProduct = playerGuessA * playerGuessB * playerGuessC;

                    // Als het antwoord goed is
                    if (safeCodeSum == playerGuessSum && safeCodeProduct == playerGuessProduct) {
                        // Zeggen dat het goed is en de speler gewonnen heeft
                        System.out.println("You're so right!");
                        round++;
                        player.addScore();
                    }
                    // Anders
                    else {
                        // Zeggen dat het fout is en de speler het opnieuw moet proberen
                        System.out.println("That's not correct, try again");
                    }

                } else {
                    handleError("Please enter 3 digits (0-9) separated by spaces");
                }
            } catch (Exception e) {
                handleError("Please enter 3 digits (0-9) separated by spaces");
            }
        }

        System.out.println("You won!");
        System.out.println("Score: " + player.getScore());
    }

    private void handleError(String message) {
        System.out.println(message);
        PLAYERINPUT.nextLine();
    }

    private boolean isInputValid(int playerGuessA, int playerGuessB, int playerGuessC) {
        return  playerGuessA >= 0 && playerGuessA < 10 &&
                playerGuessB >= 0 && playerGuessB < 10 &&
                playerGuessC >= 0 && playerGuessC < 10;
    }

    private void generateDigits(int round) {

        safeCodeA = random.nextInt(round);
        safeCodeB = random.nextInt(round);
        safeCodeC = random.nextInt(round);

        // Bereken de som - A + B + C - en het product - A * B * C - van de getallen
        safeCodeSum = safeCodeA + safeCodeB + safeCodeC;
        safeCodeProduct = safeCodeA * safeCodeB * safeCodeC;
        System.out.println(safeCodeA + " " + safeCodeB + " " + safeCodeC);

        // Som en product weergeven
        System.out.println("The sum of the digits is: " + safeCodeSum);
        System.out.println("The product of the digits is: " + safeCodeProduct);

    }
}
