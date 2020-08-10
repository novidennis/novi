package novi.basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);

        // huiswerk: niet na 1 goed antwoord stoppen maar na 10 goede antwoorden
        boolean answerIsRight = false;
        while(!answerIsRight) {

            // Stel vraag wat zijn de 3 getallen?
            System.out.println("Wat zijn de 3 getallen van de kluis?");

            // Maak de te raden getallen
            // huiswerk: als de oude geraden zijn
            //              nieuwe getallen maken
            //           anders (bij een fout antwoord)
            //              blijven de oude getallen staan
            int safeCodeA = 2; //huiswerk: niet 2, maar een willekeurig getal tussen 2 en 5
            int safeCodeB = 2; //huiswerk: niet 2, maar een willekeurig getal tussen 1 en 3
            int safeCodeC = 3; //huiswerk: niet 3, maar een willekeurig getal tussen 3 en 7

            // Bereken de som - A + B + C - en het product - A * B * C - van de getallen
            int safeCodeSum = safeCodeA + safeCodeB + safeCodeC;
            int safeCodeProduct = safeCodeA * safeCodeB * safeCodeC;

            // Som en product weergeven
            System.out.println("De som van de getallen is: " + safeCodeSum);
            System.out.println("Het product van de getallen is: " + safeCodeProduct);

            // Vragen aan de speler om de getallen in te voeren
            System.out.println("Vul het antwoord in door 3 getallen onder of achter elkaar te schrijven");

            // Krijg de getallen van de speler
            int playerGuessA = playerInput.nextInt();
            int playerGuessB = playerInput.nextInt();
            int playerGuessC = playerInput.nextInt();

            System.out.println("Gegeven antwoord is: " + playerGuessA + " " + playerGuessB + " " + playerGuessC);

            int playerGuessSum = playerGuessA + playerGuessB + playerGuessC;
            int playerGuessProduct = playerGuessA * playerGuessB * playerGuessC;

            // Als het antwoord goed is
            if (safeCodeSum == playerGuessSum && safeCodeProduct == playerGuessProduct) {
                // Zeggen dat het goed is en de speler gewonnen heeft
                System.out.println("Het antwoord is goed! Je hebt de kluis geopend");
                answerIsRight = true;
            }
            // Anders
            else {
                // Zeggen dat het fout is en de speler het opnieuw moet proberen
                System.out.println("Het antwoord is fout, probeer het nog een keer");
            }
        }
    }
}