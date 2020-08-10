package novi.basics.practice._4strings;
public class WorkingWithStrings {
    public static void main(String[] args) {
        // Opdracht werken met Strings
        String scoreString = "Tom = 28";
        String[] playerInfo = scoreString.split(/* vul hier de juiste waarde in*/);
        // zodat met onderstaande printlines in de console komt:
        // name = Tom
        // score = 28
        System.out.println("name = " + playerInfo[0]);
        System.out.println("score = " + playerInfo[1]);

        // Opdracht werken met Strings, deel 2
        String numberText = "100";
        /* maak hier een variabele aan */ = Integer.parseInt(numberText);
        // verhoog het opgeslagen getal met 1
        // sla de nieuwe waarde van het getal - 101 - op als text in numberText
        numberText = /* de nieuwe waarde van het getal als text */;
        // zodat de waarde die geprint wordt 101 is
        System.out.println(numberText);
    }
}