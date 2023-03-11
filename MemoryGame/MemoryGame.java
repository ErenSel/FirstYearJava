package MemoryGame;

import java.util.Scanner;

public class MemoryGame {
    private static Card[][] cards = new Card[4][4];
    public static void main(String[] args) {

        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');

        while (isGameEnd() == false){
            gameBoard();
            guess();
        }

    }
    public static void gameBoard(){
        for (int i = 0; i < 4; i++) {
            System.out.println("____________________");
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isGuess()){
                    System.out.print(" |"+cards[i][j].getValue()+"| ");
                }
                else {
                    System.out.print(" | | ");
                }

            }
            System.out.println("");
        }
        System.out.println("____________________");

    }
    public static void guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Guess:  ");
        int raw1 = scanner.nextInt();
        int column1 = scanner.nextInt();
        cards[raw1][column1].setGuess(true);
        gameBoard();

        System.out.print("Second Guess:  ");
        int raw2 = scanner.nextInt();
        int column2 = scanner.nextInt();

        if (cards[raw1][column1].getValue() == cards[raw2][column2].getValue()){
            System.out.println("Your guess is true...");
            cards[raw2][column2].setGuess(true);
        }
        else {
            System.out.println("Your guess is false...");
            cards[raw1][column1].setGuess(false);
        }
    }
    public static boolean isGameEnd(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isGuess() == false){
                    return false;
                }

            }
            
        }
        return true;
    }
}



class Card{
    private char value;
    private boolean guess = false;

    public Card(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isGuess() {
        return guess;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }
}
