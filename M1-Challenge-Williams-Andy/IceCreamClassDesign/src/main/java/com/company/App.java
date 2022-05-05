package com.company;

import com.company.pointofsale.IceCream;

public class App {
    public static void main(String[] args) {

        com.company.pointofsale.IceCream saleIceCream1 = new com.company.pointofsale.IceCream("Ben & Jerry's", "Americone Dream", 1, 7.50);
        com.company.factory.IceCream factoryIceCream1 = new com.company.factory.IceCream("Häagen-Dazs", "Pralines & Cream", 12, 24.50, 6, "Ice cream stuff");

        System.out.println("\nIce cream as it might be modeled in the point-of-sale system in an ice cream shop:");
        System.out.println("Brand: " + saleIceCream1.getBrand() + "\nFlavor: " + saleIceCream1.getFlavor() + "\nQuantity: " + saleIceCream1.getQuantity() + "\nPrice: " + saleIceCream1.getPrice());
        System.out.println("\nIce cream as it might be modeled in an ice cream factory:");
        System.out.println("Brand: " + factoryIceCream1.getBrand() + "\nFlavor: " + factoryIceCream1.getFlavor() + "\nQuantity: " + factoryIceCream1.getQuantity() + "\nProduction Cost: " + factoryIceCream1.getProductionCost() + "\nProduction Time: " + factoryIceCream1.getProductionTime() + "\nIngredients: " + factoryIceCream1.getIngredients());
    }
}
