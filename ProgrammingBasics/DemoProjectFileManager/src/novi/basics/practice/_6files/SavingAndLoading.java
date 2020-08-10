package novi.basics.practice._6files;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SavingAndLoading {

    public static void main(String[] args) {
        // Opdracht 4: Roep de loadFile en saveFile functies aan in deze main functie (op de aangegeven plekken)

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> playerScores = new ArrayList<>();

        String fileName = "highscores.txt";

        // Roep hieronder de loadFile functie aan
        loadFile(fileName, playerNames, playerScores);

        addPlayerScores(5, playerNames, playerScores);

        //Roep hieronder de saveFile functie aan
        saveFile(fileName, playerNames, playerScores);

        for (int playerIndex = 0; playerIndex < playerNames.size(); playerIndex++) {
            System.out.println(playerNames.get(playerIndex) + " = " + playerScores.get(playerIndex));
        }
    }
    public static boolean saveFile(String fileName, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        File scoresFile = new File(fileName);

        if(!scoresFile.exists()) {
            try {
                // deze code maakt een bestand "highscores.txt" aan in de projectmap van dit project
                // deze kan je vinden in de verkenner
                // kijk regelmatig in dit bestand om te zien of wat je denkt op te slaan ook echt gebeurd
                scoresFile.createNewFile();
            } catch (IOException exception) {
                return false;
            }
        }


        // Opdracht 1: Zoek op internet of edhub een manier om informatie in bestanden op te slaan
        // Gebruik het scoresFile als bestand om op te slaan
        // Gebruik FileWriter en BufferedWriter objecten om de informatie in het bestand te schrijven
        try {
            FileWriter pen = new FileWriter(scoresFile);
            BufferedWriter printer = new BufferedWriter(pen);

            for (int playerIndex = 0; playerIndex < playerNames.size(); playerIndex++) {
                printer.write(playerNames.get(playerIndex) + " = " + playerScores.get(playerIndex));
                //als het niet de laatste regel is
                if(playerIndex < playerNames.size() - 1) {//9
                    printer.newLine();
                }
            }

            printer.close();
            pen.close();

        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

        // De informatie die naar het bestand geschreven moet worden:

        // Voor elke speler naam en score in de ArrayLists
            // Schrijf regel voor regel in het bestand: 'naam' = 'score'
            // Voeg na elke regel een enter toe (newLine), behalve na de laatste regel

        // In het bestand komt dus te staan:

        /*
         Player1 = 10
         Player2 = 20
         Player3 = 30
         ...
        */

        return true;
    }

    public static boolean loadFile(String fileName, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        File scoresFile = new File(fileName);

        if(!scoresFile.exists()) {
            return false;
        }

        // Opdracht 2:  Zoek op internet of edhub uit hoe je informatie uit een bestand kunt lezen
        //              Zoek door tot je een voorbeeld gevonden hebt dat je goed begrijpt

        // Opdracht 2, stap 2
        // Sla regel voor regel de 'naam' = 'score' van 1 speler op als String

        try {
            Scanner fileReader = new Scanner(scoresFile);
            //zolang er een nieuwe regel is
            while(fileReader.hasNextLine()) {
                String playerInfo = fileReader.nextLine();
                String[] playerInfoArray = playerInfo.split(" = ");

                String playerName = playerInfoArray[0];
                playerNames.add(playerName);

                String playerScore = playerInfoArray[1]; //"10"
                int playerScoreNumber = Integer.parseInt(playerScore);
                playerScores.add(playerScoreNumber);

                //System.out.println("player name: " + playerInfoArray[0]);
                //System.out.println("player score: " + playerInfoArray[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // In het bestand staat dus:

        /*
         Player1 = 10
         Player2 = 20
         Player3 = 30
         ...
        */

        // Hints:   - gebruik de split methode van de String om de naam en score te scheiden
        //          - met de Integer.parseInt methode kun je de score weer als opslaan als getal

        // Opdracht 2, stap 3
        // Sla de uitgelezen naam en score ieder in hun eigen ArrayList op
        // - namen in de playerNames ArrayList
        // - scores in de playerScores ArrayList

        return true;
    }


    private static void addPlayerScores(int amount, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        int newIndex = playerNames.size();
        for (int playerIndex = 1; playerIndex <= amount; playerIndex++) {
            newIndex++;
            // Opdracht 3: zorg ervoor dat er elke keer 10 EXTRA spelers in de lijst komen te staan
            playerNames.add("Player" + newIndex);
            playerScores.add(newIndex * 10);
        }
    }
}
