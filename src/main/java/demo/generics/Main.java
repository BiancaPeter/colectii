package demo.generics;

public class Main {
    public static void main(String[] args) {
        String word = "abc";
        GenericClass<String> genericClass = new GenericClass<>(word);
        System.out.println(genericClass.get());
        genericClass.set("bcd");
        System.out.println(genericClass.get());

        GenericClass<Integer> genericClass1 = new GenericClass<>(4);
        System.out.println(genericClass1.get());

        //in cazul in care metoda nu e statica, o apelam pe un obiect
//        SimpleClass simpleClass = new SimpleClass();
        Character[] characters = {'a', 'b', 'c'};
//        simpleClass.printArray(characters);
        Integer[] numbers = {1, 2, 3};
//        simpleClass.printArray(numbers);

        SimpleClass.printArray(characters);
        SimpleClass.printArray(numbers);
    }
}
