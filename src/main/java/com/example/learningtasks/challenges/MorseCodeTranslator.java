package com.example.learningtasks.challenges;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    private static final Map<Character, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
    }

    public String translateToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase();
        for (char character : text.toCharArray()) {
            String morseChar = morseCodeMap.get(character);
            if (morseChar != null) {
                morseCode.append(morseChar).append(" ");
            } else {
                morseCode.append("? ");
            }
        }
        return morseCode.toString().trim();
    }
}