package deckofcards;
import java.util.Scanner;
/**
 *
 * @author alifazel786
 */
public class DeckOfCardsTest {

    public static void main(String[] args) {
        
        
        DeckOfCards deck = new DeckOfCards();
               
        // print menu
        System.out.println("Deck of cards has been created \n");
        
        Scanner input = new Scanner( System.in );

        int menu, numberOfPlayers, cardsToDeal;
        boolean exit = false;
        
        do {
        
        System.out.println("\nPlease Choose an option: ");  
        System.out.println("****************************");
        System.out.println("1. Shuffle the Deck");
        System.out.println("2. Cut the Deck");
        System.out.println("3. Deal the Deck");
        System.out.println("4. Exit the Program");
        System.out.println("****************************");
        
        menu = input.nextInt();
         
        switch(menu) {
        
            case 1:
                deck.shuffle();
                System.out.println("The deck has been Shuffled");
                break;
                
            case 2:
                deck.cut();
                System.out.println("The deck has been cut");
                break;
                
            case 3:
                
                // get number of players required
                System.out.println("Please input the amount of players");
                numberOfPlayers = input.nextInt();
                
                // initialise array of Player objects (of size inputted above)
                Player[] players = new Player[numberOfPlayers];

                // get number of cards to be dealt
                System.out.println("Please input the number of cards to be dealt");
                cardsToDeal = input.nextInt();
                
                // for each player required
                for (int i = 0; i < numberOfPlayers; i++) {
                    
                    // create a new player
                    players[i] = new Player(false);
                    
                    // deal the right amount of cards
                    Card[] cardsDealt = deck.deal(cardsToDeal);
                    for (int j=0; j <cardsDealt.length; j++) {
                        
                        // add the cards to the players hand
                        players[i].getHand().addCard(cardsDealt[j]);
                    }
                    
                    // print the players hand
                    System.out.println("Player #" + i + ": \n");
                    players[i].getHand().printHand();
                    
                }         
                break;
                
            case 4:
                exit=true;
                break;
        }
   
        } while (!exit);
 
    }
    
}



   /* Some wierd logic for whether number of players is OK.... look into ti later
    * 
    * if ((52/numberOfPlayers)<=5)
                {
                   System.out.println("There are too many players. Try Again:"); 
                   numberOfPlayers = input.nextInt();
                }*/