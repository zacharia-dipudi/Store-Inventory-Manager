package Repository;

/* CustomerRepositoryTest.java
CustomerRepository class
Author: Matthew Ferreira (230048870)
Date: 20 March 2026*/

import Domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRepositoryTest {
    private ICustomerRepository repository;
    private Customer customer;

    @BeforeEach
    public void setup(){
        repository = new CustomerRepositoryImpl();
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
    public void createCustomerTest(){
        repository.create(customer);
        Customer retrieved = repository.read("CUST001");
        assertNotNull(retrieved);
    }

    @Test
    public void readCustomerTest(){
        repository.create(customer);
        Customer retrievedCus = repository.read("CUST001");
        assertNotNull(retrievedCus);
        assertEquals("CUST001",retrievedCus.getCustomerId());
        assertEquals("Lex", retrievedCus.getFirstName());
        assertEquals("Fridman", retrievedCus.getSurname());
        assertEquals("Lex8Fridman@gmail.com", retrievedCus.getEmail());
        assertEquals("+27 84 797 2480", retrievedCus.getPhoneNumber());
        assertEquals("28 Space road Stellenbosche", retrievedCus.getAddress());
        assertEquals("Cape Town", retrievedCus.getCity());
        assertEquals("7599", retrievedCus.getPostalCode());
        assertEquals("South Africa", retrievedCus.getCountry());
    }

    @Test
    public void updateCustomerTest(){
        repository.create(customer);
        Customer update = new Customer.Builder()
                .setCustomerId("CUST001")
                .setFirstName("Lex")
                .setSurname("Fridman")
                .setEmail("LexFridman1975@gmail.com")
                .setPhoneNumber("+27 84 600 2480")
                .setAddress("28 Space road Stellenbosche")
                .setCity("Cape Town")
                .setPostalCode("7599")
                .setCountry("South Africa")
                .build();

        repository.update(update);
        Customer retrievedCus = repository.read("CUST001");
        assertEquals("LexFridman1975@gmail.com", retrievedCus.getEmail());
        assertEquals("+27 84 600 2480", retrievedCus.getPhoneNumber());
    }

    @Test
    public void deleteCustomerTest(){
        repository.create(customer);
        repository.delete("CUST001");
        Customer retrievedCus = repository.read("CUST001");
        assertNull(retrievedCus);
    }
}
