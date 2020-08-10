package novi.basics.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SavingAndLoadingExample {

    public static boolean loadFile(String fileName, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        File scoresFile = new File(fileName);

        if(!scoresFile.exists()) {
            return false;
        }

        try {
            Scanner scoreReader = new Scanner(scoresFile);
            while(scoreReader.hasNextLine()) {
                String[] playerInfo = scoreReader.nextLine().split(" = ");
                String name = playerInfo[0];
                int score = Integer.parseInt(playerInfo[1]);

                playerNames.add(name);
                playerScores.add(score);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return true;
    }
    
    public static boolean saveFile(String fileName, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        File scoresFile = new File(fileName);

        if(!scoresFile.exists()) {
            try {
                scoresFile.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }

        try {
            FileWriter pen = new FileWriter(scoresFile);
            BufferedWriter printer = new BufferedWriter(pen);

            for (int playerIndex = 0; playerIndex < playerNames.size(); playerIndex++) {
                printer.write(playerNames.get(playerIndex) + " = " + playerScores.get(playerIndex));
                if(playerIndex != playerNames.size() - 1) {
                    printer.newLine();
                }
            }

            printer.close();
            pen.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }



    private static void addPlayerScores(int amount, ArrayList<String> playerNames, ArrayList<Integer> playerScores) {
        for (int i = 0; i < amount; i++) {
            int newPlayerID = playerNames.size() + 1;
            playerNames.add("Player" + newPlayerID);
            playerScores.add(newPlayerID * 10);
        }
    }

    public static void main(String[] args) {
	    ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> playerScores = new ArrayList<>();

        String fileName = "highscores.txt";
        loadFile(fileName, playerNames, playerScores);

        addPlayerScores(10, playerNames, playerScores);

        saveFile(fileName, playerNames, playerScores);

        for (int playerIndex = 0; playerIndex < playerNames.size(); playerIndex++) {
            System.out.println(playerNames.get(playerIndex) + " = " + playerScores.get(playerIndex));
        }
    }
}
