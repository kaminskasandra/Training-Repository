package com.example.learningtasks;

import com.example.learningtasks.challenges.MorseCodeTranslator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTasksApplication.class, args);
        MorseCodeTranslator translator = new MorseCodeTranslator();
        String text = "JAVA TEST";
        String morseCode = translator.translateToMorse(text);
        System.out.println("Text: " + text);
        System.out.println("Morse Code: " + morseCode);
    }
}