package demo.streams;

import demo.streams.helperclasses.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOp {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(23);
        list1.add(45);
        list1.add(6);

        //1. returneaza numerele din lista care sunt mai mari decat x
        System.out.println("java8: " + findNumbersBiggerThan(list1, 5));
        System.out.println(getNumbersBiggerThan(list1, 5));
        System.out.println();

        List<String> programmingLanguages = Arrays.asList("Java", "", "scala", "Kotlin", "", "clojure");
        //2. printeaza cate string-uri din lista care incep cu litera mare si care nu sunt goale
        long count = programmingLanguages.stream()
//                .filter(language -> {
//                    if(!language.isEmpty()){
//                       if (Character.isUpperCase(language.charAt(0))){
//                           return true;
//                       }
//                    }
//                    return false;
//                })
                .filter(language -> !language.isEmpty() && Character.isUpperCase(language.charAt(0)))
                .count();
        System.out.println(count);

        long count2 = programmingLanguages.stream()
                .filter(language -> !language.isEmpty())
                .filter(language -> Character.isUpperCase(language.charAt(0)))
                .count();
        System.out.println(count2);


        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "USA"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "USA"));
        list.add(new Person("Iyan", 5, "USA"));
        list.add(new Person("Ray", 63, "USA"));
        //3. returneaza care sunt persoanele active (cu varsta mai mare decat 18 si mai mica decat 60 de ani)
        System.out.println("java8: " + findActivePerson(list));
        System.out.println(getActivePerson(list));

    }

    //ex1
    public static List<Integer> findNumbersBiggerThan(List<Integer> list, int x) {
        return list.stream()
                .filter(number -> number > x)
                .collect(Collectors.toList());
    }

    //    ---VARIANTA CLASICA---
    public static List<Integer> getNumbersBiggerThan(List<Integer> list, int x) {
        List<Integer> foundNumbers = new ArrayList<>();
        for (Integer number : list) {
            if (number > x) {
                foundNumbers.add(number);
            }
        }
        return foundNumbers;
    }

    //ex3
    public static List<Person> findActivePerson(List<Person> list) {
        return list.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 60)
                .collect(Collectors.toList());
    }

    //    ---VARIANTA CLASICA---
    public static List<Person> getActivePerson(List<Person> list) {
        List<Person> foundActivePerson = new ArrayList<>();
        for (Person person : list) {
            if (person.getAge() >= 18 && person.getAge() <= 60) {
                foundActivePerson.add(person);
            }
        }
        return foundActivePerson;
    }
}


