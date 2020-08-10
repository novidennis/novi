package novi.java;

public class Dog extends Pet {

    public Dog(String name, String type) {
        super(name, type);
    }

    public void walk() {
        System.out.println(name + " the " + type + " walks through the house");
    }
}
