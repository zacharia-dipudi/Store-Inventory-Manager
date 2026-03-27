package repository;

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
        repository = CustomerRepositoryImpl.getRepository();
        repository.getAll().clear();

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
        Customer created = repository.create(customer);
        assertNotNull(created);
        assertEquals("CUST001", created.getCustomerId());
    }

    @Test
    public void readCustomerTest(){
        repository.create(customer);
        Customer retrievedCus = repository.read("CUST001");
        assertNotNull(retrievedCus);
        assertEquals("CUST001", retrievedCus.getCustomerId());
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
                .setFirstName("Alexander")  // Changed
                .setSurname("Fridman")
                .setEmail("LexFridman1975@gmail.com")
                .setPhoneNumber("+27 84 600 2480")
                .setAddress("28 Space road Stellenbosche")
                .setCity("Cape Town")
                .setPostalCode("7599")
                .setCountry("South Africa")
                .build();

        Customer updated = repository.update(update);
        assertNotNull(updated);
        assertEquals("Alexander", updated.getFirstName());
        assertEquals("LexFridman1975@gmail.com", updated.getEmail());
        assertEquals("+27 84 600 2480", updated.getPhoneNumber());
    }

    @Test
    public void deleteCustomerTest(){
        repository.create(customer);
        boolean deleted = repository.delete("CUST001");
        assertTrue(deleted);
        Customer retrievedCus = repository.read("CUST001");
        assertNull(retrievedCus);
    }

    @Test
    public void getAllTest(){
        repository.create(customer);
        assertFalse(repository.getAll().isEmpty());
    }
}
