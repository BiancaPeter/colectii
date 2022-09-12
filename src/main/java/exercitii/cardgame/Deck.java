package exercitii.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<String> suit;
    private List<String> rang;
    private List<String> deckCards= new ArrayList<>();

    public Deck(List<String> suit, List<String> rang) {
        this.suit = suit;
        this.rang = rang;
    }

    public List<String> getSuit() {
        return suit;
    }

    public void setSuit(List<String> suit) {
        this.suit = suit;
    }

    public List<String> getRang() {
        return rang;
    }

    public void setRang(List<String> rang) {
        this.rang = rang;
    }

    public List<String> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(List<String> deckCards) {
        this.deckCards = deckCards;
    }

    public void generateDeck() {
        for (String s : suit) {
            for (String r : rang) {
                deckCards.add(s + " " + r);
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deckCards);
    }
}
