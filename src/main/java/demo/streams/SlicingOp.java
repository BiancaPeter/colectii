package demo.streams;

import java.util.ArrayList;
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
        Set<String> countrySet = getCountries(countries);
        System.out.println(countrySet);

        //2. printeaza 3 tari din lista, fara sa se repete
        Set<String> firstTreeCountries = getTreeCountries(countries);
        System.out.println(firstTreeCountries);
    }

    public static Set<String> getCountries(List<String> countries) {
        return countries.stream()
                .collect(Collectors.toSet());
    }
    //    ---VARIANTA CLASICA---
//    public static Set<String> getCountries(List<String> countries) {
//        Set<String> countriesSet = new HashSet<>();
//        for (String country : countries) {
//            countriesSet.add(country);
//        }
//        return countriesSet;
//    }

        public static Set<String> getTreeCountries(List<String> countries) {
        return countries.stream()
                .limit(3)
                .collect(Collectors.toSet());
    }
    //    ---VARIANTA CLASICA---
//TODO:Check the implement
////    public static Set<String> getTreeCountries(List<String> countries) {
////        Set<String> countriesSet = new HashSet<>();
////        int i = 0;
////        for (String country : countries) {
////            if (!countriesSet.contains(country) && i < 3){
////                countriesSet.add(country);
////                i++;
////            }
////        }
////        return countriesSet;
////    }
}
