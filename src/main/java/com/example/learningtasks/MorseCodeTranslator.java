package com.example.learningtasks;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    private static final Map<String, Character> morseToTextMap = new HashMap<>();

    public void putIntoMap() {
        morseToTextMap.put(".-", 'A');
        morseToTextMap.put("-...", 'B');
        morseToTextMap.put("-.-.", 'C');
        morseToTextMap.put("-..", 'D');
        morseToTextMap.put(".", 'E');
        morseToTextMap.put("..-.", 'F');
        morseToTextMap.put("--.", 'G');
        morseToTextMap.put("....", 'H');
        morseToTextMap.put("..", 'I');
        morseToTextMap.put(".---", 'J');
        morseToTextMap.put("-.-", 'K');
        morseToTextMap.put(".-..", 'L');
        morseToTextMap.put("--", 'M');
        morseToTextMap.put("-.", 'N');
        morseToTextMap.put("---", 'O');
        morseToTextMap.put(".--.", 'P');
        morseToTextMap.put("--.-", 'Q');
        morseToTextMap.put(".-.", 'R');
        morseToTextMap.put("...", 'S');
        morseToTextMap.put("-", 'T');
        morseToTextMap.put("..-", 'U');
        morseToTextMap.put("...-", 'V');
        morseToTextMap.put(".--", 'W');
        morseToTextMap.put("-..-", 'X');
        morseToTextMap.put("-.--", 'Y');
        morseToTextMap.put("--..", 'Z');
        morseToTextMap.put(".----", '1');
        morseToTextMap.put("..---", '2');
        morseToTextMap.put("...--", '3');
        morseToTextMap.put("....-", '4');
        morseToTextMap.put(".....", '5');
        morseToTextMap.put("-....", '6');
        morseToTextMap.put("--...", '7');
        morseToTextMap.put("---..", '8');
        morseToTextMap.put("----.", '9');

        morseToTextMap.put("-----", '0');
        morseToTextMap.putAll(morseToTextMap);
    }
}
