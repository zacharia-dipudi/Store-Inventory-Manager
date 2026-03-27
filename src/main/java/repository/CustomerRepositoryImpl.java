package repository;

/* CustomerRepositoryImpl.java
CustomerRepositoryImpl class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static CustomerRepositoryImpl repository = null;
    private List<Customer> customer = new ArrayList<>();

    public static synchronized CustomerRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new CustomerRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Customer create(Customer entity) {
        boolean success = customer.add(entity);
        if (success) {
            return entity;
        }
        return null;
    }

    @Override
    public Customer read(String id) {
        for (Customer c : customer) {
            if (c.getCustomerId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer entity) {
        String id = entity.getCustomerId();
        Customer oldCustomer = read(id);
        if (oldCustomer == null) {
            return null;
        }
        boolean success = customer.remove(oldCustomer);
        if (!success) {
            return null;
        }
        if (customer.add(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Customer customerToDelete = read(id);
        if (customerToDelete == null) {
            return false;
        }
        return customer.remove(customerToDelete);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customer);
    }
}