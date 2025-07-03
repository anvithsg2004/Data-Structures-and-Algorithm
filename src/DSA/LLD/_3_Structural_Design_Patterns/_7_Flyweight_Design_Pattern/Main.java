package DSA.LLD._3_Structural_Design_Patterns._7_Flyweight_Design_Pattern;

import java.util.HashMap;
import java.util.Map;

class Letter {
    private char symbol;

    public Letter(char symbol) {
        this.symbol = symbol;
        System.out.println("Creating new Letter object: " + symbol);
    }

    public void display(int position) {
        System.out.println("Displaying '" + symbol + "' at position " + position);
    }
}

class LetterFactory {
    private Map<Character, Letter> map = new HashMap<>();

    public Letter getLetter(char c) {
        if (!map.containsKey(c)) {
            map.put(c, new Letter(c));
        }
        return map.get(c);
    }
}

public class Main {
    public static void main(String[] args) {
        LetterFactory factory = new LetterFactory();

        String word = "HELLO";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Letter letter = factory.getLetter(c);  // reused if already exists
            letter.display(i);
        }
    }
}
