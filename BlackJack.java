package blackjack;

import java.util.Scanner; 

public class BlackJack {

    static Game game = new Game();
    Scanner input = new Scanner(System.in);
    boolean dealerWin = false;
    GUI gui = new GUI();

    Card giveCard;

    
    public void playersfn() {
        System.out.println("*************Let's Start*************");
        for (int i = 0; i < 3; i++) {
            char x;
            do {
                System.out.println("Hit OR Stand?? H/S");
                x = input.next().charAt(0);

                if (x == 'h' || x == 'H' && game.players[i].getScore() <= 21) {

                    giveCard = new Card(game.players[i].sendPlayerCard(game.drawingCard()));

                    gui.updatePlayerHand(giveCard, i);
                    if (game.players[i].getScore() > 21) {
                        game.players[i].setLost(true);
                        break;
                    } else if (game.players[i].getScore() == 21) {
                        game.players[i].setBlackjack(true);
                        break;
                    }

                }
            } while (x == 'h' || x == 'H' && game.players[i].getScore() <= 21);

            if (game.players[i].getScore() > 21) {
                game.players[3].setLost(true);

            } else if (game.players[i].getScore() == 21) {
                game.players[3].setBlackjack(true);

            }
        }

    }

    public void dealerfn() {
        
        if (game.players[3].getScore() > game.validScore||
                (game.players[0].getScore() > 21&&game.players[1].getScore() > 21&&game.players[2].getScore() > 21)) {
            dealerWin = true;
         
        }
        else if (game.players[3].getScore() <= game.validScore) {
            while (game.players[3].getScore() <= game.validScore) {

                giveCard = new Card(game.players[3].sendPlayerCard(game.drawingCard()));

                gui.updateDealerHand(giveCard, game.gameCards);

                if (game.players[3].getScore() > 21) {
                    game.players[3].setLost(true);
                    break;
                } else if (game.players[3].getScore() == 21) {
                    game.players[3].setBlackjack(true);
                    break;
                }

            }

            if (game.players[3].getScore() > 21) {
                game.players[3].setLost(true);

            } else if (game.players[3].getScore() == 21) {
                game.players[3].setBlackjack(true);

            }
        } 

    }

    public void whoWin() {
        int countisBlackjack = 0, mxm = 0, index = 0;
        boolean repet = false;

        if (!dealerWin) {
            for (int i = 0; i < 4; i++) {
                if (game.players[i].getScore()==21) {
                    index = i;
                    countisBlackjack++;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (game.players[i].getScore() <= 21) {
                    for (int j = i + 1; j < 4; j++) {
                        if (game.players[i].getScore() == game.players[j].getScore()) {
                            repet = true;
                            break;
                        }
                    }
                }
            }

            if (countisBlackjack == 1) {

                System.out.println(game.players[index].getName() + " Won This Round!!");
            } else if (countisBlackjack == 0) {
                for (int i = 0; i < 4; i++) {

                    if (game.players[i].getScore() >= mxm && game.players[i].getScore() <= 21) {
                        mxm = game.players[i].getScore();
                        index = i;
                    }
                }
                System.out.println(game.players[index].getName() + " Won This Round!!");
//            } 
//            else if (game.players[0].getScore() > 21 && game.players[1].getScore() > 21 && game.players[2].getScore() > 21 && game.players[3].getScore() > 21) {
//                System.out.println("BUSTED");
            } else if (repet) {
                System.out.println("PUSH");
            } else {
                System.out.println("BUSTED");
            }
        } else {
            System.out.println(game.players[3].getName() + " Won This Round!!");
        }

    }

    public static void main(String[] args) {
        GUI gui = new GUI();

        game.CardDeck();
        game.setPlayers();
        gui.runGUI(game.gameCards, game.players[0].getPlayerCards(), game.players[1].getPlayerCards(), game.players[2].getPlayerCards(), game.players[3].getPlayerCards());
        BlackJack blackjack = new BlackJack();

        blackjack.playersfn();
        game.mxmscore();

        blackjack.dealerfn();
        blackjack.whoWin();

    }
}