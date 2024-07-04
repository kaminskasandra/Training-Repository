package com.example.learningtasks.challenges;

public class PlaceSwitcher {

    public void switchPlace(int a, int b) {
        int c = a;
        a = b;
        b = c;
        System.out.println("a = " + a + " b = " + b);
    }

    public void switchPlaceWithoutExtraVariable(int a, int b) {
       a = b - a;
       b = b - a;
       a = a + b;
       System.out.println("a = " + a + " b = " + b);
    }
}
