package exercitii.easyexercisesS13;

import java.util.ArrayList;
import java.util.List;

public class Ex4_reversed_word_list {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("ana");
        wordList.add("nu");
        wordList.add("are");
        wordList.add("mere");
        System.out.println(returnReversedWordListLessWordsSmallerThenThree(wordList));
    }

    public static List<String> returnReversedWordListLessWordsSmallerThenThree(List<String> wordList) {
        List<String> reversedWords = new ArrayList<>();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            if (wordList.get(i).length() >= 3) {
                reversedWords.add(wordList.get(i));
            }
        }
        return reversedWords;
    }
}
