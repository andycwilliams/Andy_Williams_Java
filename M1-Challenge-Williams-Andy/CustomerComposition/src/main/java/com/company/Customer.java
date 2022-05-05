package com.company;

import java.util.Objects;

public class Customer {

    protected String firstName;
    protected String lastName;
    protected String emailAddress;
    protected Integer phoneNo;
    protected String shippingAddress;
    protected String shippingStreet1;
    protected String shippingStreet2;
    protected String shippingCity;
    protected String shippingState;
    protected Integer shippingZipCode;
    protected String billingAddress;
    protected String billingStreet1;
    protected String billingStreet2;
    protected String billingCity;
    protected String billingState;
    protected Integer billingZipCode;
    protected Boolean isRewardsMember;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingStreet1() {
        return shippingStreet1;
    }

    public void setShippingStreet1(String shippingStreet1) {
        this.shippingStreet1 = shippingStreet1;
    }

    public String getShippingStreet2() {
        return shippingStreet2;
    }

    public void setShippingStreet2(String shippingStreet2) {
        this.shippingStreet2 = shippingStreet2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public Integer getShippingZipCode() {
        return shippingZipCode;
    }

    public void setShippingZipCode(Integer shippingZipCode) {
        this.shippingZipCode = shippingZipCode;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingStreet1() {
        return billingStreet1;
    }

    public void setBillingStreet1(String billingStreet1) {
        this.billingStreet1 = billingStreet1;
    }

    public String getBillingStreet2() {
        return billingStreet2;
    }

    public void setBillingStreet2(String billingStreet2) {
        this.billingStreet2 = billingStreet2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public Integer getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(Integer billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public Boolean getRewardsMember() {
        return isRewardsMember;
    }

    public void setRewardsMember(Boolean rewardsMember) {
        isRewardsMember = rewardsMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(phoneNo, customer.phoneNo) && Objects.equals(shippingAddress, customer.shippingAddress) && Objects.equals(shippingStreet1, customer.shippingStreet1) && Objects.equals(shippingStreet2, customer.shippingStreet2) && Objects.equals(shippingCity, customer.shippingCity) && Objects.equals(shippingState, customer.shippingState) && Objects.equals(shippingZipCode, customer.shippingZipCode) && Objects.equals(billingAddress, customer.billingAddress) && Objects.equals(billingStreet1, customer.billingStreet1) && Objects.equals(billingStreet2, customer.billingStreet2) && Objects.equals(billingCity, customer.billingCity) && Objects.equals(billingState, customer.billingState) && Objects.equals(billingZipCode, customer.billingZipCode) && Objects.equals(isRewardsMember, customer.isRewardsMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailAddress, phoneNo, shippingAddress, shippingStreet1, shippingStreet2, shippingCity, shippingState, shippingZipCode, billingAddress, billingStreet1, billingStreet2, billingCity, billingState, billingZipCode, isRewardsMember);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNo=" + phoneNo +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingStreet1='" + shippingStreet1 + '\'' +
                ", shippingStreet2='" + shippingStreet2 + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingZipCode=" + shippingZipCode +
                ", billingAddress='" + billingAddress + '\'' +
                ", billingStreet1='" + billingStreet1 + '\'' +
                ", billingStreet2='" + billingStreet2 + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingZipCode=" + billingZipCode +
                ", isRewardsMember=" + isRewardsMember +
                '}';
    }
}
