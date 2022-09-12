package exercitii.easyexercisesS13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex6_number_of_word {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("ana");
        words.add("are");
        words.add("mere");
        words.add("are");
        System.out.println(returnNumberOfDuplicates(words));
    }

    public static Map<String, Integer> returnNumberOfDuplicates(List<String> words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        String currentWord;
        for (int i = 0; i < words.size(); i++) {
            currentWord = words.get(i);
            if (wordsMap.containsKey(currentWord)) {
                wordsMap.put(currentWord, wordsMap.get(currentWord) + 1);
            } else {
                wordsMap.put(currentWord, 1);
            }
        }
        return wordsMap;
    }
}
