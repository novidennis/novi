package novi.basics;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // TIP 1: begin zo klein mogelijk en bekijk delen van het probleem 1 voor 1
        // voorbeeld 10 rondes doorlopen
        //boolean answerIsRight = false;
        /*int round = 1;
        while(round <= 10) {
            System.out.println("ronde is: " + round);
            //wanneer de speler het goede antwoord gegeven heeft
            round++;
        }

        Random randomGenerator = new Random();
        int randomGetal = randomGenerator.nextInt(5);
        System.out.println(randomGetal);
        */

        //voorbeeld random waardes vasthouden
        Random randomGenerator = new Random();

        int randomRound = 1;
        boolean answerIsRight = false;
        int randomNumber1 = 2;
        boolean roundHasChanged = false;

        // wat gebeurt er nu in ronde 3? of 4?
        // maak hiervoor randomRound <= 3 (of 4)
        // hoe los je dit nu op?
        while(randomRound <= 4) {
            //TIP 2: zoek informatie op vanuit google en bekijk dan meerdere bronnen om betrouwbare informatie te vinden die je goed kunt gebruiken

            // pas in de tweede ronde zal het nummer anders zijn
            // als het antwoord goed is en van ronde gewisseld is
            if(roundHasChanged) {
                randomNumber1 = randomGenerator.nextInt(5) + 1;
            } else {
                // random number blijft hetzelfde
            }

            //TIP 3: print zoveel mogelijk informatie uit om erachter te komen waar fouten of onduidelijkheden zitten
            System.out.println("we zitten in ronde: " + randomRound);
            System.out.println("willekeurig getal: " + randomNumber1);
            System.out.println("het goede antwoord is gegeven: " + answerIsRight);

            // we doen alsof de speler de tweede keer het goede antwoorde antwoord gaat geven
            // De speler geeft eerst een verkeerd antwoord dus blijven we in dezelfde ronde
            if(answerIsRight) {
                randomRound++;
                //opslaan dat er van ronde gewisseld is
                roundHasChanged = true;
            }
            answerIsRight = true;
        }
    }
}
