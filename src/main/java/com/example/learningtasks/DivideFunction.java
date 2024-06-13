package com.example.learningtasks;

import java.util.ArrayList;
import java.util.List;

public class DivideFunction {
    public List<Integer> findDivisibles(int a, int b, int x) {
        List<Integer> divisibleNumbers = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            if (i % x == 0) {
                divisibleNumbers.add(i);
            }
        }
        return divisibleNumbers;
    }
}
