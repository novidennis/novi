package novi.basics.practice._1loops;

public class Main {

    public static void main(String[] args) {
        // Oefenen met for loops en arrays

        // Oefening 1: Dagen van de week printen

        String[] workingDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] weekendDays = {"Saturday", "Sunday"};

        System.out.println(workingDays[4]);
        // uitdaging: zet de onderstaande pseudocode om naar echte code
        // laat de for lus zoals deze nu is
        for (int dayIndex = 0; dayIndex < 7; dayIndex++) {
            // als dayIndex kleiner is dan 5
            if(dayIndex < 5) {
                // print de bijbehorende werkdag uit
                System.out.println(workingDays[dayIndex]);
                // dayIndex 0 is maandag, 1 is dinsdag, 2 is woensdag
                //          3 is donderdag en 4 is vrijdag
            }
            // anders
            else {
                // print de weekend dag uit
                System.out.println(weekendDays[dayIndex - 5]);
                // dayIndex 5 is zaterdag, dayIndex 6 is zondag
            }
        }
    }
}
