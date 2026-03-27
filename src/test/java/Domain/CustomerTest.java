package Domain;

/* CustomerTest.java
CustomerTest class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import Domain.Customer;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setup(){
        customer = new Customer.Builder()
                .setCustomerId("CUST001")
                .setFirstName("Lex")
                .setSurname("Fridman")
                .setEmail("Lex8Fridman@gmail.com")
                .setPhoneNumber("+27 84 797 2480")
                .setAddress("28 Space road Stellenbosche")
                .setCity("Cape Town")
                .setPostalCode("7599")
                .setCountry("South Africa")
                .build();
    }
    @Test
    public void customerCreatedTest(){
        assertNotNull(customer);
    }

    @Test
    public void createCustomerAllFieldsTest(){
        assertEquals("CUST001", customer.getCustomerId());
        assertEquals("Lex", customer.getFirstName());
        assertEquals("Fridman", customer.getSurname());
        assertEquals("Lex8Fridman@gmail.com", customer.getEmail());
        assertEquals("+27 84 797 2480", customer.getPhoneNumber());
        assertEquals("28 Space road Stellenbosche", customer.getAddress());
        assertEquals("Cape Town", customer.getCity());
        assertEquals("7599", customer.getPostalCode());
        assertEquals("South Africa", customer.getCountry());

        assertNotNull(customer);
    }
}
