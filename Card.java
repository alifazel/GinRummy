package deckofcards;

public class Card {
    
    public String suit;
    public int value;
    
    public Card(String s, int v) {
        this.suit = new String(s);
        this.value = v;
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String getCardDetails() {
        return new String("Card Suit: " + this.getSuit() + " and Card Value: " + this.getValue() + "\n\n");
    }
    
    public String getCardDetailsShort() {
        return new String(this.getValue() + " of " + this.getSuit());
    }
    
    
    
}