package com.company;

public class ConverterSwitch {

    static void ConverterSwitch(int number) {
        switch (number) {
            case 1 -> System.out.println("The corresponding day for " + number + " is Sunday.");
            case 2 -> System.out.println("The corresponding day for " + number + " is Monday.");
            case 3 -> System.out.println("The corresponding day for " + number + " is Tuesday.");
            case 4 -> System.out.println("The corresponding day for " + number + " is Wednesday.");
            case 5 -> System.out.println("The corresponding day for " + number + " is Thursday.");
            case 6 -> System.out.println("The corresponding day for " + number + " is Friday.");
            case 7 -> System.out.println("The corresponding day for " + number + " is Saturday.");
            default -> System.out.println("Error. Please enter a number between 1 and 7.");
        }
    }
}
