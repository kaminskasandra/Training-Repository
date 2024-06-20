package com.example.learningtasks;

public class LetterReverser {

    public String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }

        return reversed.toString();
    }
}
