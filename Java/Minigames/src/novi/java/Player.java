package novi.java;

public class Player {

    //attributen: informatie verzamelen
    private String name;
    private char token;
    private int score;

    //methoden: acties die de speler uit kan voeren
    //constructor
    public Player(String name, char token) {
        this.name = name;
        this.token = token;
        score = 0;
    }

    //get methoden
    public String getName() {
        return name;
    }

    public char getToken() {
        return token;
    }

    public int getScore() {
        return score;
    }

    //set methoden
    /*public void setScore(int score) {
        this.score = score;
    }*/

    public void addScore() {
        score++;
    }

}
