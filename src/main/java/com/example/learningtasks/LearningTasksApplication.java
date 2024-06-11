package com.example.learningtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTasksApplication.class, args);
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzzBuzz();
    }

}
