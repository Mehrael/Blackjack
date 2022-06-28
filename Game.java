package blackjack;

import java.util.Scanner;
import java.util.Random;

public class Game {

    Player[] players = new Player[4];
    Card[] gameCards = new Card[52];
    int validScore = 0;

    Scanner input = new Scanner(System.in);

    public void CardDeck() {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j > 8) {
                    gameCards[index] = new Card(i, j, 10);
                } else {
                    gameCards[index] = new Card(i, j, j + 1);
                }

                index++;

            }
        }
    }

    public Card drawingCard() {
        Random rand = new Random();
        int randomChoice = rand.nextInt(52);
        Card selected;

        if (gameCards[randomChoice] != null) {
            selected = new Card(gameCards[randomChoice]);
            gameCards[randomChoice] = null;
        } else {
            while (true) {

                randomChoice = rand.nextInt(52);
                if (gameCards[randomChoice] != null) {
                    selected = new Card(gameCards[randomChoice]);
                    gameCards[randomChoice] = null;
                    break;
                }

            }
        }

        return selected;
    }

    public void setPlayers() {

        String player;

        for (int i = 0; i < 4; i++) {
            System.out.print("Player " + (i + 1) + " : ");
            player = input.nextLine();
            players[i] = new Player(player);

            players[i].setPlayerCards(drawingCard());
            players[i].setPlayerCards(drawingCard());
        }
    }

    void mxmscore() 
    {
        int mxm = 0;
        for (int i = 0; i < 3; i++) {
            if (players[i].getScore() >= mxm) {
                mxm = players[i].getScore();
            }
        }
        validScore = mxm;
    }

}
