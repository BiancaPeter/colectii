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
        System.out.println("java8: " + isAnyPersonFrom("Canada", list));
        System.out.println(isAnyPersonFromClassic("Canada", list));
        System.out.println();

        //2. verifica daca toate persoanele din lista sunt din Canada
        System.out.println("java8: "+isAllPersonFrom("Canada", list));
        System.out.println(isAllPersonFromClassic("Canada", list));
        System.out.println();

        //3. verifica daca nu exista nicio persoana din Rusia
        System.out.println("java8: "+isNoOnePersonFrom("Rusia", list));
        System.out.println(isNoOnePersonFromClassic("Rusia", list));
    }
    //ex1
    public static boolean isAnyPersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .anyMatch(person -> person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
    public static boolean isAnyPersonFromClassic(String countryName, List<Person> personList) {
        for (Person person : personList) {
            if (person.getCountry().equals(countryName)) {
                return true;
            }
        }
        return false;
    }
    //ex2
    public static boolean isAllPersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .allMatch(person -> person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
    public static boolean isAllPersonFromClassic(String countryName, List<Person> personList) {
        for (Person person : personList) {
            if (!person.getCountry().equals(countryName)) {
                return false;
            }
        }
        return true;
    }
    //ex3
    public static boolean isNoOnePersonFrom(String countryName, List<Person> personList) {
        return personList.stream()
                .allMatch(person -> !person.getCountry().equals(countryName));
    }

    //    ---VARIANTA CLASICA---
    public static boolean isNoOnePersonFromClassic(String countryName, List<Person> personList){
        for (Person person : personList) {
            if (person.getCountry().equals(countryName)){
                return false;
            }
        }
        return true;
    }
}

