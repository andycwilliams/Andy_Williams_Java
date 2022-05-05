package com.company;

import java.util.Objects;

public class Address {
    protected String address;
    protected String street1;
    protected String street;
    protected String city;
    protected String state;
    protected Integer zipCode;

    public Address(String address, String street1, String street, String city, String state, Integer zipCode) {
        this.address = address;
        this.street1 = street1;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(address, address1.address) && Objects.equals(street1, address1.street1) && Objects.equals(street, address1.street) && Objects.equals(city, address1.city) && Objects.equals(state, address1.state) && Objects.equals(zipCode, address1.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, street1, street, city, state, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", street1='" + street1 + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

//    protected String shippingAddress;
//    protected String shippingStreet1;
//    protected String shippingStreet2;
//    protected String shippingCity;
//    protected String shippingState;
//    protected Integer shippingZipCode;
//    protected String billingAddress;
//    protected String billingStreet1;
//    protected String billingStreet2;
//    protected String billingCity;
//    protected String billingState;
//    protected Integer billingZipCode;