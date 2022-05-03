package com.company;

public class App {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.addInt(1, 1);
        calculator.subtractInt(23, 52);
        calculator.multiplyInt(34, 2);
        calculator.divideInt(12, 3);
        calculator.divideInt(12, 7);
        calculator.addDouble(3.4, 2.3);
        calculator.multiplyDouble(6.7, 4.4);
        calculator.subtractDouble(5.5,0.5);

//        System.out.println(calculator.addInt(14,17));
    }
}

