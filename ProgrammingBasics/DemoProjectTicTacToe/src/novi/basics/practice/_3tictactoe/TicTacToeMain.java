package novi.basics.practice._3tictactoe;

public class TicTacToeMain {

    public static void main(String[] args) {
        // Oefenen met for loops en arrays

        // Oefening 3: Het karakter bord dynamisch vullen en printen

        char[] board = new char[9];

        char characterNumber = '1';
        for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
            // uitdaging 1: zet de karakter waarden 1 tot 9 in de board array
            board[boardIndex] = characterNumber;
            // gebruik characterNumber en pas deze aan zodat deze steeds de volgende getalwaarde heeft
            characterNumber++;
        }

        // zorg ervoor dat als je het programma uitvoert
        // dat de output in de onderstaande for loop op de console is:
        // 1 2 3 4 5 6 7 8 9

        for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
            System.out.print(board[boardIndex] + " ");
        }
        System.out.println();

        // uitdaging 2: print de karaktergetallen in de board array niet na elkaar
        // maar in een 3x3 grid met behulp van for loops

        //1 2 3
        //4 5 6
        //7 8 9

        // begin hieronder met de uitwerking van uitdaging 2
        // hint: begin klein en print eerst enkel 1 rij
        //       zet daarna een spatie achter de rij en print de 2e rij en zo ook de 3e rij
        //       maak dus eerst 3 for loops voor de rijen apart
        //       en kijk daarna hoe je deze 3 samen zou kunnen voegen


        //optie 1: printen met 1 for loop en 1 if statement
        printBoard(board);

        board[0] = 'X';
        System.out.println();

        printBoard(board);


    }

    public static void printBoard(char[] board) {
        for (int fieldIndex = 0; fieldIndex < board.length; fieldIndex++) {
            System.out.print(board[fieldIndex] + " ");
            // als we het tweede veld geprint hebben of het vijfde veld geprint hebben
            // dan gaan we naar de volgende regel
            if(fieldIndex == 2 || fieldIndex == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

/*
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(board[column + row * 3] + " ");
            }
            System.out.println();
        }

        for (int field = 0; field < 3; field++) {
            System.out.print(board[field + 1 * 3] + " ");
        }
        System.out.println();

        for (int field = 0; field < 3; field++) {
            System.out.print(board[field + 2 * 3] + " ");
        }
        System.out.println();
        */