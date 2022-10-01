package exercitii.exercisesS17;

import java.util.*;
import java.util.stream.Collectors;

public class MainEx1Ex2Ex3Ex5AlgoritmiEx1Ex2Ex3Ex4Ex5Ex6Ex7Ex8Ex9 {
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

//        Ex2. Inlocuieste fiecare element dintr-un array cu produsul tuturor celorlalte elemente
//        Exemplu:
//          Input: { 1, 2, 3, 4, 5 }
//          Output: { 120, 60, 40, 30, 24 }
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("The list with the product of all other elements is: " + getProductOfNumbersWithout(numbers));

//        Ex3.Sa se verifice daca un array contine duplicate
//        Exemplu:
//           Input: [6,5,6,2,3,1]
//           Output: true, pentru ca 6 apare de doua ori
        List<Integer> numberList = Arrays.asList(6, 5, 6, 2, 3, 1);
        if (containsDuplicates(numberList)) {
            System.out.println("The list " + numberList + " contains duplicates");
        } else {
            System.out.println("The list " + numberList + " not contains duplicates");
        }

//        Ex4. Sunt afisate n-1 numere dintr-un interval de la 1 la n. Sa se gaseasca numarul care lipseste.
//        Exemplu:
//           Input: n=7, a=[3,2,1,6,5,7]
//           Output: 4 - lipseste doar 4 din array.
        int n = 7;
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(6);
        a.add(5);
        a.add(7);
        System.out.println("The number that is missing from the list is: " + getTheMissingNumber(a));
        System.out.println("MAP: The number that is missing from the list is: " + findTheMissingNumber(a, n));

//        Ex5. Grupeaza elementele dintr-un array astfel incat elementele duplicate sa fie unul langa altul
//        Exemplu:
//           Input: { 1, 2, 3, 1, 2, 1 }
//           Output: { 1, 1, 1, 2, 2, 3 }
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 1);
        System.out.println("The list with duplicate elements next to each other is: " + getAListWithDuplicateElementsNextToEachOther(list));

//        Ex6.Verifica daca un String poate fi derivat din alt String rotindu-l circular.
//        Exemplu:
//           Input: s1 = abcd
//                  s2 = dabc
//           Output: true, pentru ca s2 poate fi derivat din s1, rotind-se cu o unitate

        System.out.println("The strings are circular: " + areCircularRotated("abcd", "cdab"));
        System.out.println("The strings are circular: " + areCircularRotated("abcd", "cdba"));

//      Second method
//        String s = "abcd";
//        String s2 = "cdab";
//        String concatenated = s + s;
//        if (concatenated.contains(s2)) {
//            System.out.println("rotated");
//        }


//        Ex7. Gaseste diferenta maxima intre 2 numere dintr-o lista, astfel incat elementul mai mic sa apara inaintea elementului mai mare
//        Exemplu:
//            Input: [2,7,9,5,1,3,5]
//	          Output: 7 (perechea de numere care indeplineste conditia este (2,9)

        //scad fiecare numar din fiecare numar
        //convertim fiecare diferenta in pozitiv
        //comparam diferenta cu diferenta maxima

        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(2);
        numbers1.add(7);
        numbers1.add(9);
        numbers1.add(5);
        numbers1.add(1);
        numbers1.add(3);
        numbers1.add(5);
        System.out.println("The maxim difference is " + getMaxDifference(numbers1));

//        Ex8. Gaseste cea mai apropiata valoare de un anumit numar dintr-o lista de numere
//        Exemplu:
//           Input: [2,7,9,5,1,3,5], 8
//           Output: 9 sau 7 sunt cele mai apropiate valori de 8

        List<Integer> numbers2 = Arrays.asList(2, 7, 9, 5, 1, 3, 5);
        Integer nr = 8;
        System.out.println("The closest value of " + nr + ": ");
        getTheClosestValueOf(numbers2, nr);
        System.out.println();

//        Ex9. Muta toate zero-urile dintr-un array la final
//        Exemplu:
//            Input: [6,0,8,2,3,0,4,0,1]
//            Output: [6,8,2,3,4,1,0,0,0]
        List<Integer> numbers3 = new ArrayList<>();
        numbers3.add(6);
        numbers3.add(0);
        numbers3.add(8);
        numbers3.add(2);
        numbers3.add(3);
        numbers3.add(0);
        numbers3.add(4);
        numbers3.add(0);
        numbers3.add(1);
        System.out.println("Array list with 0 elements at the end is: " + getTheListWith0ElementsAtTheEnd(numbers3));
        System.out.println("Second method " + returnTheListWith0ElementsAtTheEnd(numbers3));

//         Ex10. Gaseste un subarray, care sa aiba o anumita suma
//         Un subarray are capatul din stanga inaintea capatului din dreapta in array-ul original.
//         Array-ul original poate avea doar numere pozitive
//         Exemplu:
//             Input: [1, 4, 20, 3, 10, 5], sum = 33
//             Output: suma a fost gasita intre indicii 2 si 4 (20+3+10=33)
//             Input: [1, 4], sum = 0
//             Output: nici un array nu a fost gasit
        List<Integer> numbers4 = Arrays.asList(1, 4, 20, 3, 10, 5);
        Integer sum = 33;
        List<Integer> numbers5 = Arrays.asList(1, 4);
        Integer sum1 = 0;
        System.out.println("The array with a certain sum is: " + getArrayWithACertainSum(numbers4, sum));
        System.out.println("The array with a certain sum is: " + getArrayWithACertainSum(numbers5, sum1));

//         Ex11. Roteste un array la stanga  cu o pozitie
//         Exemplu:
//             Input: [1,2,3,4,5]
//             Output: [5,1,2,3,4]
//         Rezolva apoi problema in mod general, adic[ roteste un array cu n pozitii
//         Exemplu:
//             Input: [1,2,3,4,5]
//             Output: [3,4,5,1,2] - array-ul s-arotit cu 2 pozitii
        List<Integer> numbers6 = new ArrayList<>();
        numbers6.add(1);
        numbers6.add(2);
        numbers6.add(3);
        numbers6.add(4);
        numbers6.add(5);
        int numberOfRotation = 2;
        System.out.println("The array rotated to the left by " + numberOfRotation + " positions is: " + getArrayRotatedToTheLeftBySpecifiedPositions(numbers6, numberOfRotation));
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

    //Ex2

    public static List<Integer> getProductOfNumbersWithout(List<Integer> numbers) {
        List<Integer> productOfNumbersWithout = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            productOfNumbersWithout.add(1);
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if ((i != j)) {
                    productOfNumbersWithout.set(i, productOfNumbersWithout.get(i) * numbers.get(j));
                }
            }
        }
        return productOfNumbersWithout;
    }

    //Ex3
    public static boolean containsDuplicates(List<Integer> numberList) {
        Map<Integer, Integer> numberByApparition = new HashMap<>();
        for (Integer number : numberList) {
            if (!numberByApparition.containsKey(number)) {
                numberByApparition.put(number, 1);
            } else {
                numberByApparition.put(number, numberByApparition.get(number) + 1);
            }
        }
        if (numberList.size() == numberByApparition.size()) {
            return false;
        }
        return true;
    }

    //Ex4
    public static Integer getTheMissingNumber(List<Integer> a) {
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i + 1) - a.get(i) == 2) {
                return a.get(i) + 1;
            }
        }
        return 0;
    }

    public static Integer findTheMissingNumber(List<Integer> a, int n) {
        Map<Integer, Boolean> numberByApparition = new HashMap<>();
//        for (int number = 1; number <= n; number++) {
//            if (!numberByApparition.containsKey(number)) {
//                numberByApparition.put(number, 0);
//            }
//        }
        for (Integer number : a) {
            numberByApparition.put(number, true);
        }
        for (int number = 1; number <= n; number++) {
            if (!numberByApparition.containsKey(number)) {
                return number;
            }
        }
        return 0;
    }

    //Ex5
    public static List<Integer> getAListWithDuplicateElementsNextToEachOther(List<Integer> list) {
        Map<Integer, Integer> numberByApparition = new HashMap<>();
        List<Integer> listWithDuplicateElementsNextToEachOther = new ArrayList<>();
        for (Integer number : list) {
            if (!numberByApparition.containsKey(number)) {
                numberByApparition.put(number, 1);
            } else {
                numberByApparition.put(number, numberByApparition.get(number) + 1);
            }
        }
        for (Integer number : numberByApparition.keySet()) {
            for (int i = 1; i <= numberByApparition.get(number); i++) {
                listWithDuplicateElementsNextToEachOther.add(number);
            }
        }
        return listWithDuplicateElementsNextToEachOther;
    }

    //Ex6
    public static boolean areCircularRotated(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            word1 = word1.substring(1) + word1.charAt(0);
            if (word1.equals(word2)) {
                return true;
            }
        }
        return false;
    }

    //Ex7
    public static int getMaxDifference(List<Integer> numbers) {
        int maxDifference = 0;
        int firstNumberPosition = 0;
        int secondNumberPosition = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) < numbers.get(j)) {
//                    if (maxDifference < Math.abs(numbers.get(i) - numbers.get(j))) {
//                        maxDifference = Math.abs(numbers.get(i) - numbers.get(j));
//                    }
                    if (numbers.get(j) - numbers.get(i) > maxDifference) {
                        maxDifference = numbers.get(j) - numbers.get(i);
                        firstNumberPosition = i;
                        secondNumberPosition = j;
                    }
//                    maxDifference = Integer.max(maxDifference, numbers.get(j) - numbers.get(i));
                }
            }
        }
        System.out.println(numbers.get(firstNumberPosition) + " " + numbers.get(secondNumberPosition));
        return maxDifference;
    }

    //Ex8
    //scad nr din fiecare element din lista
    //convertesc fiecare diferenta la pozitiv
    //compar diferenta cu diferenta minima
    //dupa ce am gasit diferenta minima parcurg din nou lista si afisez acele elemente care
    //daca sunt scazute din nr dat (rezultat convertit la pozitiv) dau valoarea egala cu diferenta
    // minima gasita
    public static void getTheClosestValueOf(List<Integer> numbers, Integer nr) {
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            minDifference = Integer.min(minDifference, Math.abs(nr - numbers.get(i)));
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (Math.abs(nr - numbers.get(i)) == minDifference) {
                System.out.print(numbers.get(i) + " ");
            }
        }
    }

    //Ex9

    //caut elementele egale cu 0 si contorizez  numarul lor
    //in acelasi timp introduc introduc in lista noua elementele diferite de 0
    //la final adaug in noua lista si elementele egale cu zero
    public static List<Integer> getTheListWith0ElementsAtTheEnd(List<Integer> numbers) {
        List<Integer> listWith0ElementsAtTheEnd = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 0) {
                count++;
            } else {
                listWith0ElementsAtTheEnd.add(numbers.get(i));
            }
        }
        for (int i = 1; i <= count; i++) {
            listWith0ElementsAtTheEnd.add(0);
        }
        return listWith0ElementsAtTheEnd;
    }

    //pentru fiecare element din lista verific daca elementul este egal cu 0 si daca elementele urmatoare
    //din lista sunt diferite de 0
    //daca se respecta conditia, inversez elementul curent cu elementele urmatoare care sunt diferite de 0
    public static List<Integer> returnTheListWith0ElementsAtTheEnd(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if ((numbers.get(i) == 0) && (numbers.get(i) - numbers.get(j) != 0)) {
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, 0);
                }
            }
        }
//        int k = 0;
//        for (int i = 0; i < numbers.size(); i++){
//            if (numbers.get(i)!=0){
//                numbers.set(k,numbers.get(i));
//                k++;
//            }
//        }
//        for (int i=k; i<numbers.size(); i++){
//            numbers.set(i,0);
//        }
        return numbers;
    }

    //Ex10

    //vom determina capatul din stanga pt fiecare subarray parcurgand array-ul original de la indexul 0
    //    pana la penultimul index
    //pentru fiecare capat din stanga vom determina capetele din dreapta parcurgand array-ul original
    //    de la indexul capatului din stanga+1 pana la ultimul index din array-ul original
    //avand la dispozitie capetele stanga dreapta pentru fiecare subarray-ul, determinam pe rand fiecare
    //    subarray si calculam suma elementelor
    //daca suma elementelor este cea cautata returnam subarray-ul curent
    //altfel stergem elementele din subarray-ul curent, initializam computSum cu 0 si trecem la subarray-ul urmator
    public static List<Integer> getArrayWithACertainSum(List<Integer> numbers, Integer sum) {
        List<Integer> subarray = new ArrayList<>();
        Integer computeSum = 0;
        for (int i = 0; i <= numbers.size() - 2; i++) {
            for (int j = i + 1; j <= numbers.size() - 1; j++) {
                for (int x = i; x <= j; x++) {
                    subarray.add(numbers.get(x));
                    computeSum += numbers.get(x);
                }
                if (computeSum == sum) {
                    return subarray;
                }
                subarray.clear();
                computeSum = 0;
            }
        }
        return subarray;
    }

    //Ex11
    //pentru fiecare rotatie:
    //retinem ultima valoare din lista intr-o variabila
    //parcurgem lista de la sfarsit spre inceput, incepand cu penultimul element pana la primul element
    //elementul curent il atribuim elementului cu index-ul mai mare cu o unitate fata de indexul elementului curent
    //primul element va primi valoarea ultimului element din lista initiala, retinuta la inceput intr-o variabila
    public static List<Integer> getArrayRotatedToTheLeftBySpecifiedPositions(List<Integer> numbers, int numberOfRotation) {
        Integer lastValue;
        for (int x = 1; x <= numberOfRotation; x++) {
            rotateArrayByOne(numbers);
        }
        return numbers;
    }

    private static void rotateArrayByOne(List<Integer> numbers) {
        Integer lastValue;
        lastValue = numbers.get(numbers.size() - 1);
        for (int i = numbers.size() - 2; i >= 0; i--) {
            numbers.set(i + 1, numbers.get(i));
        }
        numbers.set(0, lastValue);
    }
}
