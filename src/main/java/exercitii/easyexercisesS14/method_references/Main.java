package exercitii.easyexercisesS14.method_references;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        //reference to a static method
        BiFunction<Integer, Integer, Integer> maxFunction = (a, b) -> Integer.max(a, b);
        BiFunction<Integer, Integer, Integer> maxFunction2 = Integer::max;
        System.out.println(maxFunction2.apply(3, 7));

        //reference to an instance method of an object
        String word = "java";
        Function<Character, Integer> indexOfCharacterFunction = caracter -> word.indexOf(caracter);
        Function<Character, Integer> indexOfCharacterFunction2 = word::indexOf;
        System.out.println(indexOfCharacterFunction2.apply('v'));

        //reference to an instance method of a class
        Function<Long, Double> converter = x -> x.doubleValue();
        Function<Long, Double> converter2 = Long::doubleValue;
        System.out.println(converter2.apply(200L));

        //reference to a constructor
        Function<String, Person> personGenerator = name -> new Person(name);
        Function<String, Person> personGenerator2 = Person::new;
        System.out.println(personGenerator2.apply("John"));

        Consumer<String> printer =System.out::println;

    }
}
