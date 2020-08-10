package novi.basics.practice._2arrays;

public class ArraysMain {

    public static void main(String[] args) {
        // Oefenen met for loops en arrays

        // Oefening 2: Een array met letters en getallen printen

        // stap 1: verander onderstaande array zodat er zowel getallen als letters in kunnen staan
        char[] characters = {'1','2','X','O'};

        for (int index = 0; index < characters.length/* stap 2: vul hier de juiste waarde in */; index++) {
            // stap 3: print alle getallen en letters niet onder elkaar maar achter elkaar uit
            // zet geen enters tussen de velden in de lijst maar spaties
            System.out.print(characters[index] + " ");
        }
    }
}