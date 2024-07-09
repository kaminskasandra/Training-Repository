package com.example.learningtasks.challenges;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeDifference {

    public static long calculateMinutes(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        LocalTime start = LocalTime.parse(startTime.toUpperCase(), formatter);
        LocalTime end = LocalTime.parse(endTime.toUpperCase(), formatter);

        return ChronoUnit.MINUTES.between(start, end);
    }
}