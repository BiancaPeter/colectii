package demo.streams;

import demo.streams.helperclasses.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindingOp {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "India"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "Canada"));
        list.add(new Person("Iyan", 5, "India"));
        list.add(new Person("Ray", 63, "China"));
        //1. printeaza prima persoana gasita din lista care este din India
        Optional<Person> foundPerson = findFirstPersonFrom(list);
        System.out.println("java8: " + foundPerson.orElse(new Person("", 0, "")));
//        ---VARIANTA CLASICA---
        Person foundPerson1 = getFirstPersonFrom(list);
        System.out.println(foundPerson1);
        System.out.println();

        //2. printeaza o persoana din lista care este din India
        Optional<Person> foundAnyPerson = findAnyPersonFrom(list, "India");
        System.out.println("java8: " + foundAnyPerson.orElse(new Person("", 0, "")));
        //        ---VARIANTA CLASICA---
        System.out.println(getAnyPersonFrom(list, "India"));
    }

    //ex1
    public static Optional<Person> findFirstPersonFrom(List<Person> list) {
        return list.stream()
                .filter(person -> person.getCountry().equals("India"))
                .findFirst();
    }

    //        ---VARIANTA CLASICA---
    public static Person getFirstPersonFrom(List<Person> list) {
        for (Person person : list) {
            if (person.getCountry().equals("India")) {
                return person;
            }
        }
        return new Person("", 0, "");
    }

    //ex2
    public static Optional<Person> findAnyPersonFrom(List<Person> list, String country) {
        return list.stream()
                .filter(person -> person.getCountry().equals(country))
                .findAny();
    }

    //        ---VARIANTA CLASICA---
    public static Person getAnyPersonFrom(List<Person> list, String country) {
        for (Person person : list) {
            if (person.getCountry().equals(country)) {
                return person;
            }
        }
        return new Person("", 0, "");
    }
}
