/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

/**
 *
 * @author alifazel786
 */
import java.util.*;
public class Hand {
    
     private ArrayList<Card> hand = new ArrayList<Card>(); 
     
     public Hand() {
     }
     
     public void addCard(Card c) {
         this.hand.add(c); 
     }
     
     public void removeCard(int i) {
         this.hand.remove(i);
     }
     
     public int getSizeOfHand() {
         return this.hand.size();
     }
     
     public boolean scoreHand() {
                
         int countThreeOfAKind=0, countFourOfAKind=0;
         boolean threeOfAKind=false, fourOfAKind=false, straightThree=false, straightFour=false;
         Card c = this.hand.get(0);

         int[] tally = new int [13];
         int[] tallyHearts = new int [13];
         int[] tallySpades = new int [13];
         int[] tallyClubs = new int [13];
         int[] tallyDiamonds = new int [13];
         
         //Create indivudual card tally
         
            for(int i = 0; i < this.getSizeOfHand(); i++) {
                if (this.hand.get(i).getSuit().equals ("Heart")) 
                    tallyHearts[this.hand.get(i).getValue()]++;
                if (this.hand.get(i).getSuit().equals ("Club")) 
                    tallyClubs[this.hand.get(i).getValue()]++;
                if (this.hand.get(i).getSuit().equals ("Spade")) 
                    tallySpades[this.hand.get(i).getValue()]++;
                if (this.hand.get(i).getSuit().equals ("Diamond")) 
                    tallyDiamonds[this.hand.get(i).getValue()]++;               
            }
            
            //Check for Three Straight
            
            for (int i=0; i<=10; i++) 
                    if(tallyHearts[i]==1 & tallyHearts[i+1]==1 & tallyHearts[i+2]==1)
                       straightThree=true;
            
            for (int i=0; i<=10; i++) 
                    if(tallyClubs[i]==1 & tallyClubs[i+1]==1 & tallyClubs[i+2]==1)
                       straightThree=true;
            
            for (int i=0; i<=10; i++) 
                    if(tallyDiamonds[i]==1 & tallyDiamonds[i+1]==1 & tallyDiamonds[i+2]==1)
                       straightThree=true;
            
            for (int i=0; i<=10; i++) 
                    if(tallySpades[i]==1 & tallySpades[i+1]==1 & tallySpades[i+2]==1)
                       straightThree=true;   
            
            //Check for Four Straight
            
/*            for (int i=0; i<=9; i++) 
                    if(tallyHearts[i]==1 & tallyHearts[i+1]==1 & tallyHearts[i+2]==1 & tallyHearts[i+3]==1)
                       straightFour=true;
            
            for (int i=0; i<=9; i++) 
                    if(tallyClubs[i]==1 & tallyClubs[i+1]==1 & tallyClubs[i+2]==1 & tallyClubs[i+3]==1)
                       straightFour=true;
            
            for (int i=0; i<=9; i++) 
                    if(tallyDiamonds[i]==1 & tallyDiamonds[i+1]==1 & tallyDiamonds[i+2]==1 & tallyDiamonds[i+3]==1)
                       straightFour=true;
            
            for (int i=0; i<=9; i++) 
                    if(tallySpades[i]==1 & tallySpades[i+1]==1 & tallySpades[i+2]==1 & tallySpades[i+3]==1)
                       straightFour=true;            
 
 */
            
  
         /*   
          * make array for hearts clubs and spade and diamonds
          *
          * 
          * for (int x=1; x<=9; x++) //can't have straight with lowest value of more than 10
          *         if (ranks[x]==1 && ranks[x+1]==1 && ranks[x+2]==1 && ranks[x+3]==1 && ranks[x+4]==1)
          *                 straight=true;
          */ 
            
            
         // Tally Chart   
            for(int i=0; i<7; i++){
                tally[this.hand.get(i).getValue()]++;
            }
       
            
            
          // Check for Three Of A Kind     
            for(int i=0; i<7; i++)
                if(tally[i]==3)
                    threeOfAKind=true;
            
          // Check for Four Of A Kind  
            for(int i=0; i<7; i++)
                if(tally[i]==4)
                    fourOfAKind=true;
            
          // Check for 3-straight  
            
       
         
          // Check for winning conditions
            if (threeOfAKind == true & fourOfAKind == true)
                    return true;
            
            if (threeOfAKind == true & straightFour == true)
                    return true;
                
            if (fourOfAKind == true & straightThree == true)
                    return true;
                   
            if (straightThree == true & straightFour == true) 
                    return true;                                 
            
            
            //If no winning conditions, return false
            return false;
            
            
     }           
            
           // Debugger 
           // System.out.println("Number of H:" + countHearts + " C:" + countClubs + " S:" + countSpades + "D" + countDiamonds);
         
     
     
     public void printHand() {
        
         Card c = this.hand.get(0);
         
         for(int i = 0; i < this.getSizeOfHand(); i++) {
             System.out.println("Card " + (i+1) + ": " + this.hand.get(i).getValue() + " of " + this.hand.get(i).getSuit());
             
         }
         
    
         
     }
     
 
     
}

