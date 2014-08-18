package deckofcards;

/**
 *
 * @author alifazel786
 */

public class DeckOfCards {
    
    final private int maxNumberOfCards = 52;
    final private int numberCardsInSuit = 13;
    
    private String[] suits = {"Diamond", "Club", "Spade", "Heart"};
    private Card[] cards = new Card[maxNumberOfCards];
    
    public DeckOfCards() {
        
        // generate initial deck of cards
        int count = 0;
        for(int i = 0; i < this.suits.length; i++) {
            for(int j = 1; j <= this.numberCardsInSuit; j++) {
                this.cards[count] = new Card(this.suits[i], j);
                count++;
            }
        }
        
    }
   
    public void cut() { //Takes the top random deck, and puts it at the bottom
        
        Card tempCard;
    
        int randomA = (int) (Math.random()*52);
        
        // do you need to print this out? >> System.out.println(randomA);
       
        for(int i = 51; randomA >= 0; i--) {

            tempCard = this.cards[i];
            this.cards[i]=this.cards[randomA];
            this.cards[randomA]=tempCard;
            randomA--;

        }
      
    }
    
    public void shuffle() {

        Card tempCard;

        for(int i = 0; i < 52; i++) {

            int randomA = (int) (Math.random()*52);    // (1)
            int randomB = (int) (Math.random()*52);    // (1)

            tempCard = this.cards[randomB];  //Stores the properties of Random Card B as TempCard

            this.cards[randomB]=this.cards[randomA]; //Swaps Random Card B with Random Card A
            this.cards[randomA] =   tempCard;    //Returns the TempCard to Random Card A

        }

    }
    
    public Card[] deal(int cardsToDeal) {
        
        // create an array of size of cards to be dealt
        Card[] dealtCards = new Card[cardsToDeal];
        int j = 0;
        
        // for each card to be dealt
        for(int i = 0; i < cardsToDeal; i++) {
                        
            Card c = null;
            
            // loop through the deck until it finds the next not null card
            do {
                c = this.cards[j];
                j++;

            } while (c == null);
            
            
            // remove the card from the deck
            this.cards[(j-1)] = null;
            // add the card to the dealt cards
            dealtCards[i] = c;
        }
        
        //return the dealt cards
        return dealtCards;
        
    }
    
    public void printDeck() {
       for(int i = 0; i < 52; i++) {
           System.out.println("Card" + (i+1) + ": " + this.cards[i].getValue() + " of " + this.cards[i].getSuit());    
        }
    }
    
}

/***
 * References
 *
 * (1) http://www.w3schools.com/jsref/jsref_random.asp - Used to find random algorithm. Multiplied by 52 will always equal a number <52.
 * (2) http://stackoverflow.com/questions/4441099/how-do-you-count-the-elements-of-an-array-in-java - Used to find ArrayList replacement of Arrays for dynamically sized Arrays.  
 *
 **/