package com.example.learningtasks.challenges;

public class MaximumMinimum {

    public Integer findSecondMaximum(int[] numbers) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num < firstMax && num > secondMax) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            return null;
        }

        return secondMax;
    }

    public Integer findSecondMinimum(int[] numbers) {

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num > firstMin && num < secondMin) {
                secondMin = num;
            }
        }

        if (secondMin == Integer.MAX_VALUE) {
            return null;
        }

        return secondMin;
    }
}

