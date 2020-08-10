package novi.basics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static boolean saveScores(String fileName) {
        try {
            File scoreFile = new File(fileName);
            FileWriter pen = new FileWriter(scoreFile);
            BufferedWriter printer = new BufferedWriter(pen);
            printer.write("Erik=2");
            printer.newLine();
            printer.write("Arno=5");
            printer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Geen toegang tot locatie: " + fileName);
            return false;
        }
    }

    public static void main(String[] args)  {
        boolean scoresSaved = saveScores("C:\\scores.txt");
        
        int[] num = {1,2,3,4,5,6,7,8,9};
        String text = "";
        for (int i = 0; i < num.length; i++) {
            text += num[i];
            System.out.println(text);
        }
        
        ArrayList<String> names= new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(1);
        int s = scores.get(0);

        if(scoresSaved) {
            System.out.println("Scores opgeslagen op C schijf");
        } else {
            scoresSaved = saveScores("E:\\scores.txt");
            if(scoresSaved) {
                System.out.println("Scores opgeslagen in project map");
            }
        }
        if(!scoresSaved) {
            System.out.println("Scores konden niet worden opgeslagen");
        }
    }
}
