package exercitii.easyexercisesS13;

import java.util.ArrayList;
import java.util.List;

public class Ex1_pow2 {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);

        System.out.println(returnNumbersToPowerOfTwo(numbers));
    }

    public static List<Double> returnNumbersToPowerOfTwo(List<Double> numbers) {
        List<Double> numbersToPowerOfTwo = new ArrayList<>();
        for (Double number : numbers) {
            numbersToPowerOfTwo.add(Math.pow(number, 2));
        }
        return numbersToPowerOfTwo;
    }
}
