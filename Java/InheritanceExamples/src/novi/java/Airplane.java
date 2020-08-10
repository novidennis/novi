package novi.java;

public class Airplane implements Flyable, Drivable {

    public void fly() {
        System.out.println("the airplane flies through the air");
    }

    public void drive() {
        System.out.println("the airplane drives around on the airfield");
    }
}
