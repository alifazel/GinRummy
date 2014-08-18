/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

import java.util.Scanner;

/**
 *
 * @author alifazel786
 */
public class PlayGinRummy {
    
    public static void main(String[] args) {
        
        boolean exit = false;
        do {

            // print menu
            System.out.println("\nGin Rummy Game: ");  
            System.out.println("****************************");
            System.out.println("1. Begin Game");
            System.out.println("2. Exit the Program");
            System.out.println("****************************");
            
            Scanner input = new Scanner( System.in );
            int menu = input.nextInt();
            
            if(menu == 1) {
                
                // get number of players required
                System.out.println("Please input total number of players");
                int numberOfPlayers = input.nextInt();
                
                // initialise array of Player objects (of size inputted above)
                Player[] players = new Player[numberOfPlayers];

                // get number of AI players in the game
                System.out.println("Please input the number of AI players");
                int numberOfAIPlayers = input.nextInt();
                
                // quick error checking that inputs are correct
                if(numberOfAIPlayers >= numberOfPlayers) {
                    System.out.println("Error: Number of AI Players exceeds Number of Players / No Human Player");
                
                } else {
                    
                     /**
                      * Begin Game
                      */
                  
                     DeckOfCards deck = new DeckOfCards();
                     deck.shuffle();
                     
                     int count = 0;
                     // for each player required
                     for (int i = 0; i < numberOfPlayers; i++) {
                         
                        // create the players (AI First)
                        if(count < numberOfAIPlayers) {
                            players[i] = new Player(false);
                            count++;
                        } else {
                            players[i] = new Player(false);
                        }
     
                        // deal the 7 initial cards to each player
                        Card[] cardsDealt = deck.deal(7);
                        for (int j=0; j <cardsDealt.length; j++) {

                            // add each card to the players hand
                            players[i].getHand().addCard(cardsDealt[j]);
                        }
                     }
                         
                    // create the discard pile
                    Hand discardPile = new Hand();
                    Card[] cardsDealt = deck.deal(1);
                    Card card = cardsDealt[0];
                    discardPile.addCard(card);

                    boolean gameWon = false;
                    do {
                            
                        /**
                         * Begin Rounds
                         */
                            
                        for(int i = 0; i < players.length; i++) {
                            
                            if(!players[i].isAIPLayer()) {
                                
                                // human player, let them decide what to do
                            
                                System.out.println("\nPlayer #" + i + ":");  
                                System.out.println("****************************");
                                System.out.println("Cards in Hand: ");
                                players[i].getHand().printHand();

                                System.out.println("1. Draw from Deck");
                                System.out.println("2. Draw from Discard Pile (:card on discard pile:)");
                                System.out.println("3. Discard Card");
                                System.out.println("****************************");
                                int choice = input.nextInt();


                                switch(choice) {
                                    
                                    case 1:
                                        players[i].getHand().addCard(deck.deal(1)[0]);
                                        break;
                                        
                                    case 2:
                                        System.out.println("Not implemented yet...");
                                        break;
                                        
                                    case 3:
                                        System.out.println("Choose Card Num # to Discard:");
                                        int discardNo = input.nextInt();
                                        if(discardNo > 0 | discardNo <= players[i].getHand().getSizeOfHand()) {
                                            players[i].getHand().removeCard((discardNo - 1));
                                        }
                                        break;
                                    
                                }

                                if(players[i].getHand().getSizeOfHand() > 7) {
                                    System.out.println("Error: You can only have 7 cards, choose a card to discard");
                                    players[i].getHand().printHand();
                                    System.out.println("Choose Card Num # to Discard:");
                                    int discardNo = input.nextInt();
                                    if(discardNo > 0 | discardNo <= players[i].getHand().getSizeOfHand()) {
                                        players[i].getHand().removeCard((discardNo - 1));
                                    }
                                }

                                // score the hand and check if the player has won the game or not
                                
                                gameWon = players[0].getHand().scoreHand();
                 
                                
                            } else {
                                
                                // this is a computer player so let it make the decisions
                                
                            }
                            
                        }
                            
                            
                    } while(!gameWon);
                   
  
                }
                
            } 
            
            if(menu == 2) {
                exit = true;
            }

        } while (!exit);

        
    }
    
    
}
