package novi.basics.example;

public class ExampleMain {

    public static void main(String[] args) {
        // twee manieren om het speelbord op te slaan
        // - het bord is een lijst van 9 getallen met de waardes 1 - 9

        // manier 1: het opslaan van een lege array met een vaste lengte
        // - er zitten 9 plekken in de array maar ze hebben nog geen waarde
        int[] numbers = new int[9];

        // voor elke plek in de array geven we die plek in een for loop een waarde
        // we beginnen op index 0 en eindigen met index 8 (kleiner dan 9)
        for (int index = 1; index < 9; index++) {
            // de plekken in de lijst krijgen de waarde: index van de plek + 1
            // plek 0 heeft waarde 1
            // plek 1 heeft waarde 2
            // etc..
            numbers[index] = index + 1;
        }
        /*  Dit is wat er in de herhaling van de for loop gebeurd,
            > De plekken in de lijst krijgen 1 voor 1 de waarde 1 tot en met 9
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        numbers[5] = 6;
        numbers[6] = 7;
        numbers[7] = 8;
        numbers[8] = 9;
        */

        // Tweede manier om een array met getallen aan te maken is alsvolgt.
        // - omdat we altijd met een bord starten met 9 getallen, kunnen we het Tic Tac Toe bord ook direct een waarde geven
        // - door de waardes in de lijst tussen accolade haakjes {} mee te geven, gescheiden met een komma
        int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

}
