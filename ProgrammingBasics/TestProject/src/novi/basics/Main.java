package novi.basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);

        // de speler vragen om een getal in te voeren dat wordt opgeslagen als variabele
        System.out.println("voer een nummer in");
        int numberInput = playerInput.nextInt();
        System.out.println("invoer: " + numberInput);


        // if, else if, else
        if(numberInput > 10) {
            System.out.println("invoer is groter dan 10");
        }
        else if (numberInput == 10) {
            System.out.println("invoer is gelijk aan 10");
        }
        else {
            System.out.println("invoer is kleiner dan 10");
        }


        // zolang de invoer groter is dan 10
        while(numberInput >= 10) {
            System.out.println("voer een nummer in dat kleiner is dan 10");
            numberInput = playerInput.nextInt();
            System.out.println("invoer: " + numberInput);
        }

        // berekeningen maken met invoer van de speler
        int inputSum = numberInput * 3;
        System.out.println("invoer * 3: " + inputSum);

        // de speler naam opvragen
        System.out.println("Wat is je naam?");
        String playerName = playerInput.next();
        System.out.println("Hi, " + playerName);


    }
}