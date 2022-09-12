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
        System.out.println(foundPerson.orElse(new Person("", 0, "")));
//        ---VARIANTA CLASICA---
//        Person foundPerson1 = findFirstPersonFrom(list);
//        System.out.println(foundPerson1);

        //2. printeaza o persoana din lista care este din India
        Optional<Person> foundAnyPerson = findAnyPersonFrom(list);
        System.out.println(foundAnyPerson.orElse(new Person("", 0, "")));
    }

    public static Optional<Person> findFirstPersonFrom(List<Person> list) {
        return list.stream()
                .filter(person -> person.getCountry().equals("India"))
                .findFirst();
    }

//        ---VARIANTA CLASICA---
//    public static Person findFirstPersonFrom(List<Person> list) {
//        for (Person person : list) {
//            if (person.getCountry().equals("India")){
//                return person;
//            }
//        }
//        return new Person("", 0, "");
//    }

    public static Optional<Person> findAnyPersonFrom(List<Person> list) {
        return list.stream()
                .filter(person -> person.getCountry().equals("India"))
                .findAny();
    }
}
