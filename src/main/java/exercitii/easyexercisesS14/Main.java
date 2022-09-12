package exercitii.easyexercisesS14;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Ex5. Scrie o metoda care:
//        Primeste ca parametru o lista de numere, care are un element duplicat
//        Returneaza elementul duplicat
//        HINT (alt mod de rezolvare decat cel clasic): metoda add din interfata Set returneaza false, daca nu poate adauga elementul
//        primit ca parametru in set
        System.out.println("Exercitiul nr. 5");
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(3);
        numberList.add(5);

        Integer duplicateNumber = returnDuplicateNumber(numberList);
        if (duplicateNumber == 0) {
            System.out.println("Lista nu are elemente duplicate");
        } else {
            System.out.println("Elementul duplicat din lista este " + duplicateNumber);
        }
        System.out.println("------------------------------------");


//        Ex6. Scrie o metoda care:
//        Primeste ca parametru o lista de numere
//        Afiseaza cel mai mic si cel mai mare element din lista
//        HINT (alt mod de rezolvare decat cel clasic): adauga toate elementele din lista intr-un treeset, apoi apeleaza
//        metodele first() si last() pe acel treeset
        System.out.println("Exercitiul nr. 6");
        printTheSmallestAndLargestElementInTheList(numberList);
        System.out.println("------------------------------------");

//        Ex1(mediu). Scrie o metoda care:
//        Primeste ca parametrii doua cuvinte si returneaza true, daca cuvintele sunt anagrame.
//        Exemple:
//          Input1: “race”, “care”
//           Output1: true, pentru ca care contine aceleasi litere ca si race, si literele apar de acelasi numar de ori
//          Input2:”race”, “carec”
//          Output2: false, pentru ca nu contin acelasi litere, de acelasi numar de ori
        System.out.println("Exercitiul nr. 1 (mediu)");
        String word1 = "race";
        String word2 = "care";
        if (isAnagram(word1, word2)) {
            System.out.println("Cuvintele introduse sunt anagrame.");
        } else {
            System.out.println("Cuvintele introduse NU sunt anagrame.");
        }
        System.out.println("------------------------------------");
    }

    public static Integer returnDuplicateNumber(List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numberList) {
            if (!numberSet.add(number)) {
                return number;
            }
        }
        return 0;
    }

    public static void printTheSmallestAndLargestElementInTheList(List<Integer> numberList) {
        SortedSet<Integer> numberSet = new TreeSet<>();
        for (Integer number : numberList) {
            numberSet.add(number);
        }
        Integer smallestNumber = numberSet.first();
        System.out.println("The smallest element in the list is: " + smallestNumber);
        Integer largestNumber = numberSet.last();
        System.out.println("The largest element in the list is: " + largestNumber);
    }

    public static boolean isAnagram(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        generateMap(map1, generateListOfCharacter(word1));
        generateMap(map2, generateListOfCharacter(word2));

        if (map1.equals(map2)) {
            return true;
        } else {
            return false;
        }
    }

    private static List<Character>  generateListOfCharacter(String word) {
        List<Character> wordList = new ArrayList<>();
        for (Character ch : word.toCharArray()) {
            wordList.add(ch);
        }
        return wordList;
    }

    private static void generateMap(Map<Character, Integer> map, List<Character> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (map.containsKey(wordList.get(i))) {
                map.put(wordList.get(i), map.get(wordList.get(i) + 1));
            } else {
                map.put(wordList.get(i), 1);
            }
        }
    }

}
