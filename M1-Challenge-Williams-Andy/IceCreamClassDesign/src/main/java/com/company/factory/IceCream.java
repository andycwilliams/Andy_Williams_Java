package com.company.factory;

import java.util.Objects;

public class IceCream {
    public IceCream(String brand, String flavor, int quantity, double productionCost, int productionTime, String ingredients) {
        this.brand = brand;
        this.flavor = flavor;
        this.quantity = quantity;
        this.productionCost = productionCost;
        this.productionTime = productionTime;
        this.ingredients = ingredients;
    }
    public String brand;
    public String flavor;
    public int quantity;
    public double productionCost;
    public int productionTime;
    public String ingredients;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return quantity == iceCream.quantity && Double.compare(iceCream.productionCost, productionCost) == 0 && productionTime == iceCream.productionTime && Objects.equals(brand, iceCream.brand) && Objects.equals(flavor, iceCream.flavor) && Objects.equals(ingredients, iceCream.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, flavor, quantity, productionCost, productionTime, ingredients);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "brand='" + brand + '\'' +
                ", flavor='" + flavor + '\'' +
                ", quantity=" + quantity +
                ", productionCost=" + productionCost +
                ", productionTime=" + productionTime +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}