package exercitii.easyexercisesS13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex3_positive_numbers {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(-2);
        list1.add(3);
        list1.add(4);
        list1.add(4);
        list1.add(-5);
        list2.add(1);
        list2.add(-7);
        list2.add(2);
        System.out.println(returnPositiveNumbers(list1, list2));
    }

    public static Set<Integer> returnPositiveNumbers(List<Integer> list1, List<Integer> list2) {
        Set<Integer> positiveNumbers = new HashSet<>();
        for (Integer number : list1) {
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }
        for (Integer number : list2) {
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }
        return positiveNumbers;
    }
}
