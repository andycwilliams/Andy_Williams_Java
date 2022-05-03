package com.company;

public class ConverterIf {

    static void ConverterIf(int number) {
        if (number == 1) {
            System.out.println("The corresponding month for " + number + " is January.");
        } else if (number == 2) {
            System.out.println("The corresponding month for " + number + " is February.");
        } else if (number == 3) {
            System.out.println("The corresponding month for " + number + " is March.");
        } else if (number == 4) {
            System.out.println("The corresponding month for " + number + " is April.");
        } else if (number == 5) {
            System.out.println("The corresponding month for " + number + " is June.");
        } else if (number == 7) {
            System.out.println("The corresponding month for " + number + " is July.");
        } else if (number == 8) {
            System.out.println("The corresponding month for " + number + " is August.");
        } else if (number == 9) {
            System.out.println("The corresponding month for " + number + " is September.");
        } else if (number == 10) {
            System.out.println("The corresponding month for " + number + " is October.");
        } else if (number == 11) {
            System.out.println("The corresponding month for " + number + " is November.");
        } else if (number == 12) {
            System.out.println("The corresponding month for " + number + " is December.");
        } else {
            System.out.println("Error. Please enter a number between 1 and 12.");
        }
    }
}
