
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;
    
    public Hand() {
        cards = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        for (Card item : cards) {
            System.out.println(Card.VALUES[item.getValue()] + " of " + Card.SUITS[item.getSuit()]);
        }
    }
    
    public void sortAgainstSuit() {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    @Override
    public int compareTo(Hand other) {
        int hand = 0;
        int otherHand = 0;
        
        for (Card item : cards) {
            hand += item.getValue();
        }
        
        for (Card item : other.cards) {
            otherHand += item.getValue();
        }
        return hand - otherHand;
    }
}
