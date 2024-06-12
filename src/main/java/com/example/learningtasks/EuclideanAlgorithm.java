package com.example.learningtasks;

public class EuclideanAlgorithm {
    public void findTheGreatestCommonDivisor(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println(" a = " + a + ", b = " + b);
    }
}
