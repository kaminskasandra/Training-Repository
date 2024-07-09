package com.example.learningtasks;

import com.example.learningtasks.challenges.TimeDifference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTasksApplication.class, args);
        long minutesBetween = TimeDifference.calculateMinutes("11:00am", "8:00pm");
        System.out.println("Liczba minut: " + minutesBetween);
    }
}