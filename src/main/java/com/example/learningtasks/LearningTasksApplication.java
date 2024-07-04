package com.example.learningtasks;

import com.example.learningtasks.challenges.Palindrome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTasksApplication.class, args);
        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.isPalindrome("kajak");
        System.out.println(result);
    }

}
