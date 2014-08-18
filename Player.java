/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

/**
 *
 * @author alifazel786
 */
public class Player {
        
    private Hand hand = new Hand();
    private boolean isAIPlayer = false;
    
    
    public Player (boolean isAIPlayer) {
        this.isAIPlayer = isAIPlayer;
    }
    
    public Hand getHand() {
        return this.hand;
    }
    
    public boolean isAIPLayer() {
        return this.isAIPlayer;
    }
            
    
    
    
}
