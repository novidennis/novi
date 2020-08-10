package novi.java;

public class Bird extends Pet implements Flyable {

    public Bird(String name, String type) {
        super(name, type);
    }

    @Override
    public void walk() {
        System.out.println(name + " the " + type + " walks through the cage");
    }

    @Override
    public void fly() {
        System.out.println("the bird flies through the air");
    }

}
