package com.company.pointofsale;

import java.util.Objects;

public class IceCream {

    public void FreeIceCreamDay() {
        System.out.println("We don't have a free ice cream day.");
    }

    public void IceCreamOnSaleDay() {
        System.out.println("We don't ever put our ice cream on sale.");
    }

    public void IceCreamInStock() {
        System.out.println("We don't have any ice cream in stock either.");
    }

    public IceCream(String brand, String flavor, int quantity, double price) {
        this.brand = brand;
        this.flavor = flavor;
        this.quantity = quantity;
        this.price = price;
    }

    public String brand;
    public String flavor;
    public int quantity;
    public double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return quantity == iceCream.quantity && Double.compare(iceCream.price, price) == 0 && Objects.equals(brand, iceCream.brand) && Objects.equals(flavor, iceCream.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, flavor, quantity, price);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "brand='" + brand + '\'' +
                ", flavor='" + flavor + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
