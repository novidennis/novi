package novi.basics.practice._4strings;

public class WorkingWithStrings {
    public static void main(String[] args) {
        // Opdracht werken met Strings
        String scoreString = "Tom = 28";
        String[] playerInfo = scoreString.split(" = ");

        // zodat met onderstaande printlines in de console komt:
        // name = Tom
        // score = 28
        System.out.println("name = " + playerInfo[0]);
        System.out.println("score = " + playerInfo[1]);

        // Opdracht werken met Strings, deel 2

        String numberText = "100";
        int number = Integer.parseInt(numberText);
        // verhoog het opgeslagen getal met 1
        number++;

        // sla de nieuwe waarde van het getal - 101 - op als text in numberText
        numberText = "" + number;

        // zodat de waarde die geprint wordt 101 is
        System.out.println(numberText);
    }
}
