package com.company.MonthAPI.model;

import java.util.Objects;

public class Month {

    private Integer number;
    private String name;

    public Month(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Month(){}

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(number, month.number) && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

//    static void ConverterSwitch(int number) {
//        switch (number) {
//            case 1 -> System.out.println("The corresponding day for " + number + " is Sunday.");
//            case 2 -> System.out.println("The corresponding day for " + number + " is Monday.");
//            case 3 -> System.out.println("The corresponding day for " + number + " is Tuesday.");
//            case 4 -> System.out.println("The corresponding day for " + number + " is Wednesday.");
//            case 5 -> System.out.println("The corresponding day for " + number + " is Thursday.");
//            case 6 -> System.out.println("The corresponding day for " + number + " is Friday.");
//            case 7 -> System.out.println("The corresponding day for " + number + " is Saturday.");
//            default -> System.out.println("Error. Please enter a number between 1 and 7.");
//        }
//    }