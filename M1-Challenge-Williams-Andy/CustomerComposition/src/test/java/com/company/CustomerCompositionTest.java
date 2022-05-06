package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CustomerCompositionTest {

    private Customer customer;
    @Before
    public void SetUp() throws Exception {
        customer = new Customer();

        customer.setFirstName("John");
        customer.setLastName("Sprinkles");
        customer.setEmailAddress("email@address.net");
        customer.setPhoneNo(1234567890);
        customer.setRewardsMember(true);

        customer.setAddress("Bovine Industries");
        customer.setStreet1("1234 Pork Street");
        customer.setStreet2("1106");
        customer.setCity("Burger City");
        customer.setState("Beef State");
    }

    @Test
    public void shouldReturnCustomerFirstName() {
        assertEquals("John", customer.getFirstName());
    }

    @Test
    public void shouldReturnCustomerPhoneNo() {
        assertEquals(true, customer.getRewardsMember());
    }

    @Test
    public void shouldReturnCustomerBillingAddress() {
        assertEquals("Bovine Industries", customer.getAddress());
    }
}

