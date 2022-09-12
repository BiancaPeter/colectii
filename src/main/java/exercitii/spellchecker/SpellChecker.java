package exercitii.spellchecker;

import java.util.*;

public class SpellChecker {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        List<String> wordFormText = new ArrayList<>();

        //citirea dictionarului
        Scanner console = new Scanner(System.in);
        System.out.println("Number of words in dictionary: ");
        int number = Integer.parseInt(console.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Enter next word: ");
            String word = console.nextLine();
            dictionary.add(word);
        }
        System.out.println("Words in dictionary are: " + dictionary);

        //citirea textului
        System.out.println("Enter number of lines: ");
        int numberOfLines = Integer.parseInt(console.nextLine());
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println("Enter next line: ");
            String line = console.nextLine();
            String[] words = line.split(" ");
            for (int j = 0; j < words.length; j++) {
                wordFormText.add(words[j]);
            }
        }
        System.out.println("Words form text are: " + wordFormText);

        //verificarea textului pentrucuvinte eronate
        System.out.println("Bad words are: " + findBadWords(dictionary, wordFormText));
    }

    public static Set<String> findBadWords(Set<String> dictionary, List<String> wordFromText) {
        Set<String> badWords = new HashSet<>();
        for (String word : wordFromText) {
            if (!dictionary.contains(word)) {
                badWords.add(word);
            }
        }
        return badWords;
    }
}