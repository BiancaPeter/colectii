package demo.functionalprogramming.examplecomparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 34));
        personList.add(new Person("Ana", 61));
        personList.add(new Person("Mircea", 14));

        //metoda de comparare cu clasa Comparator
        personList.sort(new NameComparator());
        System.out.println(personList);

        //metoda de comparare folosind functii lambda
        personList.sort((x, y) -> Integer.valueOf(x.getAge()).compareTo(Integer.valueOf(y.getAge())));
        System.out.println(personList);

//        for (Person p:personList) {
//            System.out.println(p);
//            //alte chestii
//        }
        personList.forEach(p -> System.out.println(p));

        //stergeti din lista persoanele cu varsta mai mare decat 50
        System.out.println("-----------------------------");
        List<Person> personToRemove = new ArrayList<>();
        Predicate<Person> removePerson = p -> p.getAge() >= 50;
        for (Person p : personList) {
            if (removePerson.test(p)) {
                personToRemove.add(p);
            }
        }
        for (Person p:personToRemove) {
            personList.remove(p);
        }
        System.out.println(personList);

    }
}
