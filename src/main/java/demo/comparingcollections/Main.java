package demo.comparingcollections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Coin coin1 = new Coin(50, 2010);
        Coin coin2 = new Coin(100, 2013);
        Coin coin3 = new Coin(150, 2015);
        Coin coin4 = new Coin(200, 2006);

        List<Coin> coins = new ArrayList<>();
        coins.add(coin4);
        coins.add(coin2);
        coins.add(coin3);
        coins.add(coin1);

        System.out.println(coins);
        Collections.sort(coins);
        System.out.println(coins);

        coins.sort(new MintYearComparator());
        System.out.println(coins);

        Set<Coin> coinSet = new TreeSet<>();
        coinSet.add(coin4);
        coinSet.add(coin3);
        coinSet.add(coin1);
        coinSet.add(coin2);
        System.out.println(coinSet);

        Set<Coin> coinsOrderByMintYear = new TreeSet<>(new MintYearComparator());
        coinsOrderByMintYear.addAll(coinSet);
        System.out.println(coinsOrderByMintYear);
    }

}
