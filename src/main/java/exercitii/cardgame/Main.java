package exercitii.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> suit = Arrays.asList("trefla", "romb", "rosu", "negru");
        List<String> rang = Arrays.asList("As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k");
        Deck deck = new Deck(suit, rang);
        deck.generateDeck();
        System.out.println(deck.getDeckCards());

//        deck.shuffleDeck();
//        System.out.println(deck.getDeckCards());

        Player player1 = new Player("Alin");
        Player player2 = new Player("Victor");
        Player player3 = new Player("Stefan");
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        for (Player player : playerList) {
            deck.shuffleDeck();
            System.out.println(player.dealHand(deck, 4));
        }
    }
}
