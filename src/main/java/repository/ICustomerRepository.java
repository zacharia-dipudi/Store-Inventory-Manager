package repository;

/* ICustomerRepository.java
ICustomerRepository class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Customer;
import Domain.Product;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, String> {
    List<Customer>getAll();
}
