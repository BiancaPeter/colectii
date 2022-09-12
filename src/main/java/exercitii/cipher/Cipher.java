package exercitii.cipher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cipher {
    private List<Character> inputChars;
    private List<Character> outputChars;

    Map<Character, Character> cipher;

    public Cipher(List<Character> inputChars, List<Character> outputChars) {
        this.inputChars = inputChars;
        this.outputChars = outputChars;
        cipher = new HashMap<>();
        initializeCypher();
    }

    public Map<Character, Character> initializeCypher() {
        for (int i = 0; i < inputChars.size(); i++) {
            cipher.put(inputChars.get(i), outputChars.get(i));
        }
        return cipher;
    }

    public String encrypt(String word) {
        String encryptedWord = "";
        for (Character c : word.toCharArray()) {
            encryptedWord += cipher.get(c);
        }
        return encryptedWord;
    }

    public String decrypt(String word) {
        String decryptedWord = "";
        for (Character c : word.toCharArray()) {
            for (Character key : cipher.keySet()) {
                if (cipher.get(key).equals(c)) {
                    decryptedWord += key;
                }
            }
        }
        return decryptedWord;
    }

}
