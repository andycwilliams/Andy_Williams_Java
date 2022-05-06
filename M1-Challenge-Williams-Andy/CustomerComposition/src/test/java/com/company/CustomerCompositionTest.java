package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CustomerCompositionTest {

    private Customer customer;
    @Before
    public void SetUp() throws Exception {
        customer = new Customer();
    }

    @Test
    public void shouldReturnSameCustomer() {
        assertEquals("John", customer.getFirstName());
    }
}

//        JohnS.setFirstName("John");
//                JohnS.setLastName("Sprinkles");
//                JohnS.setEmailAddress("email@address.net");
//                JohnS.setPhoneNo(1234567890);
//                JohnS.setRewardsMember(true);
//
//                JohnS.setAddress("Bovine Industries");
//                JohnS.setStreet1("1234 Pork Street");
//                JohnS.setStreet2("1106");
//                JohnS.setCity("Burger City");
//                JohnS.setState("Beef State");
