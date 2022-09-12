package exercitii.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<String> dealHand(Deck deck, Integer numberOfCards) {
        List<String> cards = deck.getDeckCards().subList(deck.getDeckCards().size() - numberOfCards, deck.getDeckCards().size());
        deck.setDeckCards(deck.getDeckCards().subList(0, deck.getDeckCards().size()-numberOfCards));
        return  cards;

    }
}
