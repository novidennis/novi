package novi.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pet dog = new Dog("Meneer Henk", "Bulldog");
        Bird bird = new Bird("Sjaakie", "Parkiet");
        Airplane plane = new Airplane();

        dog.walk();
        bird.walk();

        ArrayList<Flyable> flyables = new ArrayList<>();
        flyables.add(bird);
        flyables.add(plane);
    }
}
