package Repository;

/* CustomerRepositoryImpl.java
CustomerRepositoryImpl class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private List<Customer> customer = new ArrayList<>();

    @Override
    public void create (Customer entity){
        customer.add(entity);
    }

    @Override
    public Customer read(String id){
        return customer.stream()
                .filter(c -> c.getCustomerId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Customer entity){
        Customer exist = read(entity.getCustomerId());
        if(exist != null){
            customer.remove(exist);
            customer.add(entity);
        }
    }

    @Override
    public void delete(String id) {
        customer.removeIf(c -> c.getCustomerId().equals(id));
    }
}
