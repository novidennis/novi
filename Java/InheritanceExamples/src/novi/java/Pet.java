package novi.java;

public abstract class Pet {
    protected String name;
    protected String type;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract void walk();
}
