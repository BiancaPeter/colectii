package exercitii.exercisesS17.personeligibleforvotingEx4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Ex 4. Filtreaza persoanele care pot vota
//        O persoana este caracterizata de nume si varsta.
//        Scrie o metoda statica numita isPersonEligibleForVoting(), care accepta ca parametru o lista de
//        persoane si returneaza o lista cu persoanele care pot vota.
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Anca", 12));
        personList.add(new Person("Alin", 32));
        personList.add(new Person("Vlad", 21));
        personList.add(new Person("Ionut", 15));
        personList.add(new Person("Darius", 25));
        System.out.println("java8: The persons eligible for voting are: " + isPersonEligibleForVoting(personList));
        System.out.println("The persons eligible for voting are: " + getPersonEligibleForVoting(personList));
    }

    public static List<Person> isPersonEligibleForVoting(List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public static List<Person> getPersonEligibleForVoting(List<Person> personList) {
        List<Person> personEligibleForVoting = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() >= 18) {
                personEligibleForVoting.add(person);
            }
        }
        return personEligibleForVoting;
    }
}
