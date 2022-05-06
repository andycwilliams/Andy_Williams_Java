package com.company;

public class App {
    public static void main(String[] args) {
        Customer JohnS = new Customer();
        Customer SmithJ = new Customer("1", "2", "3", "4", "5", 6);

        JohnS.setFirstName("John");
        JohnS.setLastName("Sprinkles");
        JohnS.setEmailAddress("email@address.net");
        JohnS.setPhoneNo(1234567890);
        JohnS.setRewardsMember(true);

        JohnS.setAddress("Bovine Industries");
        JohnS.setStreet1("1234 Pork Street");
        JohnS.setStreet2("1106");
        JohnS.setCity("Burger City");
        JohnS.setState("Beef State");
        JohnS.setZipCode(6);

        System.out.println(JohnS);
        System.out.println(SmithJ);
    }
}