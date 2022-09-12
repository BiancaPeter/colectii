package exercitii.cipher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> inputChars = new ArrayList<>();
        inputChars.add('a');
        inputChars.add('e');
        inputChars.add('i');
        inputChars.add('o');
        inputChars.add('u');
        inputChars.add('c');
        inputChars.add('n');
        inputChars.add('d');
        inputChars.add('b');
        inputChars.add('s');
        inputChars.add('l');
        inputChars.add('m');
        System.out.println(inputChars);

        List<Character> outChars = new ArrayList<>();
        outChars.add('s');
        outChars.add('t');
        outChars.add('n');
        outChars.add('f');
        outChars.add('g');
        outChars.add('h');
        outChars.add('j');
        outChars.add('k');
        outChars.add('x');
        outChars.add('y');
        outChars.add('z');
        outChars.add('q');
        System.out.println(outChars);

        Cipher cipher = new Cipher(inputChars, outChars);
        System.out.println(cipher.initializeCypher());
        System.out.println(cipher.encrypt("slab"));
        System.out.println(cipher.decrypt("qsjs"));
    }
}
