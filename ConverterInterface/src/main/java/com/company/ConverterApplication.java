package com.company;

public class ConverterApplication {
    static void ConverterIf(int monthNumber) {
        if (monthNumber == 1) {
            System.out.println("The corresponding month for " + monthNumber + " is January.");
        } else if (monthNumber == 2) {
            System.out.println("The corresponding month for " + monthNumber + " is February.");
        } else if (monthNumber == 3) {
            System.out.println("The corresponding number for " + monthNumber + " is March.");
        } else if (monthNumber == 4) {
            System.out.println("The corresponding number for " + monthNumber + " is April.");
        } else if (monthNumber == 5) {
            System.out.println("The corresponding number for " + monthNumber + " is June.");
        } else if (monthNumber == 7) {
            System.out.println("The corresponding number for " + monthNumber + " is July.");
        } else if (monthNumber == 8) {
            System.out.println("The corresponding number for " + monthNumber + " is August.");
        } else if (monthNumber == 9) {
            System.out.println("The corresponding number for " + monthNumber + " is September.");
        } else if (monthNumber == 10) {
            System.out.println("The corresponding number for " + monthNumber + " is October.");
        } else if (monthNumber == 11) {
            System.out.println("The corresponding number for " + monthNumber + " is November.");
        } else if (monthNumber == 12) {
            System.out.println("The corresponding number for " + monthNumber + " is December.");
        } else {
            System.out.println("Error. Please enter a number between 1 and 12.");
        }
    }

    static void ConverterSwitch(int dayNumber) {
        switch (dayNumber) {
            case 1 -> System.out.println("The corresponding day for " + dayNumber + " is Sunday.");
            case 2 -> System.out.println("The corresponding day for " + dayNumber + " is Monday.");
            case 3 -> System.out.println("The corresponding day for " + dayNumber + " is Tuesday.");
            case 4 -> System.out.println("The corresponding day for " + dayNumber + " is Wednesday.");
            case 5 -> System.out.println("The corresponding day for " + dayNumber + " is Thursday.");
            case 6 -> System.out.println("The corresponding day for " + dayNumber + " is Friday.");
            case 7 -> System.out.println("The corresponding day for " + dayNumber + " is Saturday.");
            default -> System.out.println("Error. Please enter a number between 1 and 7.");
        }
    }

    static void main(String[] args) {
        ConverterIf(7);
        ConverterSwitch(7);
    }
}
