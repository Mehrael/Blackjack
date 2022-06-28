package blackjack;

public class Player
{
    private String name;
    private int score=0;
    private Card[] playerCards=new Card[11];
    private boolean lost=false, blackjack=false;
    private int counter=0;

    public Player(String name) {
        this.name = name;
    }

    public void setPlayerCards(Card playerCards) {
        this.playerCards[counter] = playerCards;
        counter++;
        this.score+=playerCards.getValue();
    }
    
    public Card sendPlayerCard(Card playerCards) {
        this.playerCards[counter] = playerCards;
        counter++;
        this.score+=playerCards.getValue();
        
        return playerCards;
    }

    
    public int getScore() {
        return score;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public String getName() {
        return name;
    }

    public boolean isLost() {
        return lost;
    }

    public Card[] getPlayerCards() {
        return playerCards;
    }
    
     public Card getPlayerCardgui() {
        return playerCards[1];
    }

    public int getCounter() {
        return counter;
    }

}