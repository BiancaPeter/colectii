package demo.functionalprogramming.examplecomparator.listsetmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();

        prices.add(2);
        prices.add(3);
        prices.add(5);

        System.out.println(prices);

        for (int i = 0; i < prices.size(); i++) {
            System.out.println(prices.get(i));
        }
        prices.set(0, 4);
        System.out.println(prices.get(0));

        for (Integer price : prices) {
            System.out.println(price * 2);
        }

        prices.remove(2);

        System.out.println(prices);
        System.out.println(prices.indexOf(3));
        System.out.println(prices.contains(3));

        //crearea unei liste imutabile
        List<String> immutableList = Arrays.asList("asd", "bcd", "def");
        //nu putem modifica liste imutabile. Se va genera UnsupportedOperationException
        //immutableList.add("sfd");
    }
}
