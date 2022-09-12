package demo.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SlicingOp {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");
        //1. printeaza tarile din lista, fara sa se repete
        Set<String> countrySet = findCountries(countries);
        System.out.println("java8: " + countrySet);
        System.out.println(getCountries(countries));
        System.out.println();

        //2. printeaza 3 tari din lista, fara sa se repete
        Set<String> firstTreeCountries = findTreeCountries(countries);
        System.out.println("java8: "+firstTreeCountries);
        System.out.println(getTreeCountries(countries));
    }

    //ex1
    public static Set<String> findCountries(List<String> countries) {
        return countries.stream()
                .collect(Collectors.toSet());
    }

    //    ---VARIANTA CLASICA---
    public static Set<String> getCountries(List<String> countries) {
        Set<String> countriesSet = new HashSet<>();
        for (String country : countries) {
            countriesSet.add(country);
        }
        return countriesSet;
    }

    //ex2
    public static Set<String> findTreeCountries(List<String> countries) {
        return countries.stream()
                .limit(3)
                .collect(Collectors.toSet());
    }
    //    ---VARIANTA CLASICA---
    public static Set<String> getTreeCountries(List<String> countries) {
        Set<String> countriesSet = new HashSet<>();
        int i = 0;
        for (String country : countries) {
            if (!countriesSet.contains(country) && i < 3){
                countriesSet.add(country);
                i++;
            }
        }
        return countriesSet;
    }
}
