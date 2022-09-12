package demo.functionalprogramming.examplecomparator.listsetmap;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();

        countries.add("India");
        countries.add("Japan");
        countries.add("India");

        System.out.println(countries);
        System.out.println(countries.contains("Japan"));

        countries.clear();

        System.out.println(countries);

        for (String country : countries) {
            System.out.println(country);
        }

        //crearea unui set imutabil
        Set<String> immutableSet = Set.of("Romania", "England", "USA");
        //nu putem modifica set-uri imutabile. Se va genera UnsupportedOperationException
        //immutableSet.add("France");
    }
}
