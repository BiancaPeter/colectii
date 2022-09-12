package demo.streams;

import demo.streams.helperclasses.Person;

import java.util.ArrayList;
import java.util.List;

public class MatchingOp {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "India"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "Canada"));
        list.add(new Person("Iyan", 5, "India"));
        list.add(new Person("Ray", 63, "China"));
        //1. verifica daca lista de persoana contine cel putin o persoana din Canada
//        boolean isAnyPersonFromCanada = list.stream()
//                .anyMatch(person -> person.getCountry().equals("Canada"));
//        System.out.println(isAnyPersonFromCanada);
        System.out.println(isAnyPersonFrom("Canada", list));

        //2. verifica daca toate persoanele din lista sunt din Canada
        //TODO: Check the implement
        System.out.println(isAllPersonFrom("Canada", list));

        //3. verifica daca nu exista nicio persoana din Rusia
        //TODO: Check the implement
        System.out.println(isNoOnePersonFrom("Rusia", list));
    }

    public static boolean isAnyPersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .anyMatch(person -> person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
//    public static boolean isAnyPersonFrom(String countryName, List<Person> personList) {
//        for (Person person : personList) {
//            if (person.getCountry().equals(countryName)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean isAllPersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .allMatch(person -> person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
//    public static boolean isAllPersonFrom(String countryName, List<Person> personList) {
//        for (Person person : personList) {
//            if (!person.getCountry().equals(countryName)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isNoOnePersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .allMatch(person -> !person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
//    public static boolean isNoOnePersonFrom(String countryName, List<Person> personList){
//        for (Person person : personList) {
//            if (person.getCountry().equals(countryName)){
//                return false;
//            }
//        }
//        return true;
//    }
}

