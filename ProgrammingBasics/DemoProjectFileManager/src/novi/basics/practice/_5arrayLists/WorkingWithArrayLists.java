package novi.basics.practice._5arrayLists;

import java.util.ArrayList;

public class WorkingWithArrayLists {

    public static void main(String[] args) {

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> playerScores = new ArrayList<>();

        // Opdracht 1: Voeg 10 spelernamen en 10 scores aan de twee ArrayLists toe
        // zodat in de console het volgende geprint wordt:

        /* Console output opdracht 1
        Player1 = 10
        Player2 = 20
        Player3 = 30
        Player4 = 40
        Player5 = 50
        Player6 = 60
        Player7 = 70
        Player8 = 80
        Player9 = 90
        Player10 = 100
        */

        // *** Opdracht 1: schrijf hier je code *** //


        // *** Opdracht 2: roep hier de functie aan (zie uitleg onder de for loop) *** //
        int amountMain = 10;
        boolean playersAdded = addPlayerScores(amountMain, playerNames, playerScores);
        if(playersAdded) {
            amountMain += 20;
            addPlayerScores(amountMain, playerNames, playerScores);
        }

        //System.out.println(amountMain);

        //printen van namen en scores
        for (int playerIndex = 0; playerIndex < playerNames.size(); playerIndex++) {
            System.out.println(playerNames.get(playerIndex) + " = " + playerScores.get(playerIndex));
        }

        // Opdracht 2: Verplaats de code voor vullen van ArrayLists naar onderstaande functie
        // Gebruik de int amount parameter om het aantal nieuwe playerscores mee te kunnen geven

        // Roep addPlayerScores vervolgens aan op de plek waar je code van de eerste opdracht stond
    }

    private static boolean addPlayerScores(int amount, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {

        boolean result = false;
        for (int playerIndex = 1; playerIndex <= amount; playerIndex++) {
            playerNames.add("Player" + playerIndex);
            playerScores.add(playerIndex * 10);
            if(playerIndex == amount) {
                result = true;
            }
        }
        return result;
    }
}
