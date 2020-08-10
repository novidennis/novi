package novi.java;

import java.util.Scanner;

public class Main {
    public static Scanner PLAYERINPUT = new Scanner(System.in);

    public static void main(String[] args) {

        // -- vanaf hier gaan we het spel opnieuw spelen met andere spelers (nadat op het eind  keuze 2 gekozen is)
        while (true) {
            // de 1e speler om zijn naam vragen
            System.out.println("Player 1, what is your name?");
            // de naam van de 1e speler opslaan
            String player1Name = PLAYERINPUT.next();
            Player player1 = new Player(player1Name, 'x');

            // de 2e speler om zijn naam vragen
            System.out.println("Player 2, what is your name?");
            // de naam van de 2e speler opslaan
            String player2Name = PLAYERINPUT.next();
            Player player2 = new Player(player2Name, 'o');

            boolean chooseGame = true;
            while(chooseGame) {
                System.out.println("which game would you like to play?");
                System.out.println("1: Tic Tac Toe");
                System.out.println("2: Triple Digits");
                int choice = PLAYERINPUT.nextInt();

                boolean playTicTacToe = choice == 1;

                boolean rematch = true;
                while (rematch) {
                    if (playTicTacToe) {
                        TicTacToe game = new TicTacToe(player1, player2);
                        game.play();
                    } else {
                        TripleDigits game = new TripleDigits(player1, 10);
                        game.play();
                    }

                    // vragen of de spelers nog een keer willen spelen
                    System.out.println("What do you want to do next?");
                    //1: nog een keer spelen
                    System.out.println("1: Rematch with same players");
                    //2: van spelers wisselen
                    System.out.println("2: Change Game");
                    //2: van spelers wisselen
                    System.out.println("3: Change Players");
                    //3: afsluiten
                    System.out.println("4: Exit");

                    // speler keuze opslaan
                    choice = PLAYERINPUT.nextInt();
                    switch (choice) {
                        // bij keuze 1: terug naar het maken van het bord
                        // voor keuze 1 hoef je geen actie te ondernemen,
                        // de rematch loop wordt automatisch gestart

                        // bij keuze 2: terug naar de start van de applicatie en het vragen van spelernamen
                        case 2:
                            rematch = false;
                            break;

                        // bij keuze 3: het spel en de applicatie helemaal afsluiten
                        case 3:
                            rematch = false;
                            chooseGame = false;
                            break;
                        // bij keuze 4: het spel en de applicatie helemaal afsluiten
                        case 4:
                            return;

                    }
                }
            }
        }
    }
}