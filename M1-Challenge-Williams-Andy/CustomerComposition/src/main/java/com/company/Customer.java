package com.company;

import java.util.Objects;

public class Customer extends Address{

    protected String firstName;
    protected String lastName;
    protected String emailAddress;
    protected Integer phoneNo;
    protected Boolean isRewardsMember;

    public Customer(String address, String street1, String street, String city, String state, Integer zipCode) {
        super(address, street1, street, city, state, zipCode);
    }

    public Customer() {
    }

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
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(phoneNo, customer.phoneNo) && Objects.equals(isRewardsMember, customer.isRewardsMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, emailAddress, phoneNo, isRewardsMember);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNo=" + phoneNo +
                ", isRewardsMember=" + isRewardsMember +
                ", address='" + address + '\'' +
                ", street1='" + street1 + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
