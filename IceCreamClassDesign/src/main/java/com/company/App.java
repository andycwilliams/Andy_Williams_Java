package com.company;

public class App {
    public static void main(String[] args) {
        com.company.pointofsale.IceCream saleIceCream1 = new com.company.pointofsale.IceCream("Ben & Jerry's", "Americone Dream", 1, 7.50);
        com.company.factory.IceCream factoryIceCream1 = new com.company.factory.IceCream("Ben & Jerry's", "Americone Dream", 12, 24.50, 6, "Ice cream stuff");

        System.out.println(saleIceCream1);
        System.out.println(factoryIceCream1);
    }
}