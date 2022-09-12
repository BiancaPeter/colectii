package exercitii.exercisesS17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainEx1Ex2Ex3Ex5Ex1 {
    public static void main(String[] args) {
//        Ex1. Suma numerelor pare:
//        Calculeaza suma numerelor pare dintr-o lista de Integer-uri.
//        (HINT: filter si sum sau reduce)
        List<Integer> numberList1 = Arrays.asList(3, 8, 4, 6, 7, 13);
        Optional<Integer> optionalSumOfEvenNumbers = returnSumOfEvenNumbers(numberList1);
        System.out.println("java8: The sum of the even numbers in the list is: " + optionalSumOfEvenNumbers.orElse(0));
//TODO: cum facem cu filter si sum???
        Integer sumOfEvenNumbers = getSumOfEvenNumbers(numberList1);
        System.out.println("The sum of the even numbers in the list is: " + sumOfEvenNumbers);

//        Ex2. Suma numerelor divizibile cu x sau cu y:
//        Scrie o metoda care sa calculeze suma numerelor divizibile cu x sau y (unde x si y sunt primiti ca parametri), dintr-o lista de Integer-uri.
//        (HINT: filter si sum sau reduce)
        List<Integer> numberList2 = Arrays.asList(3, 8, 4, 5, 6, 7, 8, 9, 13);
        int x = 2;
        int y = 3;
        Optional<Integer> optionalSumOfNumbersDivisibleByXOrY = returnSumOfNumbersDivisibleByXOrY(numberList2, x, y);
        System.out.println("java8: The sum of numbers divisible by x or y is: " + optionalSumOfNumbersDivisibleByXOrY.orElse(0));
        Integer sumOfNumbersDivisibleByXOrY = getSumOfNumbersDivisibleByXOrY(numberList2, x, y);
        System.out.println("The sum of numbers divisible by x or y is: " + sumOfNumbersDivisibleByXOrY);

//        Ex3. Sorteaza numerele dintr-un array
//        Scrie o metoda care sa sorteze numerele dintr-o lista de Integer-uri, dar inainte de asta sa le transforme in valori pozitive
//        Ex: Input: [-1,2,-3,4,-5]
//        Output:[1,2,3,4,5]
//        (HINT: map pentru a transforma fiecare numar din negativ in pozitiv, apoi sorted() ca si operatie finala. Foloseste Math.abs() pentru a transforma un numar din negativ in pozitiv)
        List<Integer> numberList3 = Arrays.asList(-3, -1, 2, 4, -5);
        System.out.println("java8: " + sortsPositiveNumbers(numberList3));
        System.out.println(getSortPositiveNumbers(numberList3));

//        Ex5. Spell checker 2
//        Avand intr-un main un String, in care se stocheaza un text si o lista de cuvinte gresite,
//        scrie o functie care accepta acesti 2 parametrii si returneaza lista cu cuvintele gresite care
//        se regasesc in text
//        Ex: Input: String text = “acesta etse nu text”
//                List<String> badWords = [“etse”, “nu”, “acetsa”, “extt”]
//        Output: [“etse”, “nu”], pentru ca acestea sunt cuvintele din badWords care se regasesc in text
//        (HINT: stream pe lista badWords, apoi filtram doar cuvintele care sunt continute in text (folosind
//        metoda contains()) )
        String text = "acesta etse nu text";
        List<String> badWords = new ArrayList<>();
        badWords.add("etse");
        badWords.add("nu");
        badWords.add("acetsa");
        badWords.add("extt");
        System.out.println("java8: The bad words are: " + findBadWordsInTheText(text, badWords));
        System.out.println(" The bad words are: " + getBadWordsInTheText(text, badWords));

//        Ex1. Afla profitul maxim pe care il poti face cumparand si vanzand actiuni.
//        Ca si input ai un array cu preturile unei actiuni in fiecare zi. Va trebui sa determini in ce zi
//        trebuie sa cumperi si in ce zi trebuie sa vinzi ca sa obtii profitul maxim
//        Exemplu:
//          Input: [100, 180, 260, 310, 40, 535, 695]
//          Output: Cumpara in ziua 5 (la pretul de 40) si vinde in ziua 7 (la pretul de 695), adica profit
//                  maxim 695-40=655
//          Input2: [2, 3, 10, 6, 4, 8, 1]
//          Output: Cumpara in ziau 0 (la pretul de 2) si vinde in ziua 2 (la pretul de 10), adica
//                  profit maxim 10-2=8
        List<Integer> pricesOfActions = Arrays.asList(100, 180, 260, 310, 40, 535, 695);
        int dayWithMaxPriceOfAction = getDayWithMaxPriceOfAction(pricesOfActions);
        int dayWithMinPriceOfActionUntilDayWithMaxPriceOfAction = getDayWithMinPriceOfActionUntilDayWithMaxPriceOfAction(pricesOfActions, dayWithMaxPriceOfAction);
        int maximumProfit = pricesOfActions.get(dayWithMaxPriceOfAction) - pricesOfActions.get(dayWithMinPriceOfActionUntilDayWithMaxPriceOfAction);
        System.out.println("Maximum profit is: " + maximumProfit);
    }

        //Ex1
    public static Optional<Integer> returnSumOfEvenNumbers(List<Integer> numberList) {
        return numberList.stream()
                .filter(number -> number % 2 == 0)
                .reduce((sum, number) -> sum + number);
    }

    public static Integer getSumOfEvenNumbers(List<Integer> numberList) {
        Integer sum = 0;
        for (Integer number : numberList) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    //Ex2
    public static Optional<Integer> returnSumOfNumbersDivisibleByXOrY(List<Integer> numberList, int x, int y) {
        return numberList.stream()
                .filter(number -> number % x == 0 || number % y == 0)
                .reduce((sum, number) -> sum + number);
    }

    public static Integer getSumOfNumbersDivisibleByXOrY(List<Integer> numberList, int x, int y) {
        Integer sum = 0;
        for (Integer number : numberList) {
            if (number % x == 0 || number % y == 0) {
                sum += number;
            }
        }
        return sum;
    }

    //Ex3
    public static List<Integer> sortsPositiveNumbers(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> Math.abs(number))
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> getSortPositiveNumbers(List<Integer> numberList) {
        List<Integer> sortedList = new ArrayList<Integer>();
        Integer bucket;
        for (Integer number : numberList) {
            if (number >= 0) {
                sortedList.add(number);
            } else {
                sortedList.add(Math.abs(number));
            }
        }
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i) > sortedList.get(j)) {
                    bucket = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, bucket);
                }
            }
        }
        return sortedList;
    }

    //Ex5
    public static List<String> findBadWordsInTheText(String text, List<String> badWords) {
        return badWords.stream()
                .filter(word -> text.contains(word))
                .collect(Collectors.toList());
    }

    public static List<String> getBadWordsInTheText(String text, List<String> badWords) {
        List<String> badWordsInTheText = new ArrayList<>();
        for (String word : badWords) {
            if (text.contains(word)) {
                badWordsInTheText.add(word);
            }
        }
        return badWordsInTheText;
    }

    //Ex1
    public static int getDayWithMaxPriceOfAction(List<Integer> pricesOfActions) {
        int day = 0;
        int maxPrice = pricesOfActions.get(0);
        for (int i = 1; i < pricesOfActions.size(); i++) {
            if (maxPrice < pricesOfActions.get(i)) {
                maxPrice = pricesOfActions.get(i);
                day = i;
            }
        }
        return day;
    }

    public static int getDayWithMinPriceOfActionUntilDayWithMaxPriceOfAction(List<Integer> pricesOfActions, int dayWithMaxPrice) {
        int day = 0;
        int minPrice = pricesOfActions.get(0);
        for (int i = 1; i < dayWithMaxPrice; i++) {
            if (minPrice > pricesOfActions.get(i)) {
                minPrice = pricesOfActions.get(i);
                day = i;
            }
        }
        return day;
    }
}
