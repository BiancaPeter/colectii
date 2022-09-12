package exercitii.easyexercisesS13;

import java.util.ArrayList;
import java.util.List;

public class Ex2_longest_word {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("ana");
        words.add("are");
        words.add("mere");
        System.out.println(returnLongestWord(words));
    }

    public static String returnLongestWord(List<String> words) {
        String longestWord = "";
        for (String word : words) {
            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
