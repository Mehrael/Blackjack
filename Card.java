package blackjack;

public class Card {

    private int suit, rank, value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public Card(Card c) {
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

}
