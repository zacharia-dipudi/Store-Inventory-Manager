package Repository;

/* CustomerRepositoryImpl.java
CustomerRepositoryImpl class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Customer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static CustomerRepositoryImpl repository = null;
    private List<Customer> customer = new ArrayList<>();

    public static CustomerRepositoryImpl getRepository() {
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
    public Set<Customer> getAll() {
        return new HashSet<>(customer);
    }
}
