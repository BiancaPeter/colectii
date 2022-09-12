package demo.comparingcollections;

import java.util.Comparator;

class MintYearComparator implements Comparator<Coin> {

    @Override
    public int compare(Coin coin1, Coin coin2) {
        return Integer.compare(coin1.getMintYear(), coin2.getMintYear());
    }
}
