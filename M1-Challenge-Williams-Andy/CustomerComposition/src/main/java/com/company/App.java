package com.company;

public class App {
    public static void main(String[] args) {
        Customer customerComposition = new Customer();

        customerComposition.setFirstName("John");

        System.out.println("Customer: " + customerComposition);
    }
}