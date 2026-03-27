package Repository;

/* OrderRepositoryImpl.java
OrderRepositoryImpl class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements IOrderRepository {
    private List<Order> order = new ArrayList<>();

    @Override
    public void create (Order entity){
        order.add(entity);
    }

    @Override
    public Order read(String orderNum){
        return order.stream()
                .filter(o -> o.getOrderNum().equals(orderNum))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Order entity){
        Order exist = read(entity.getOrderNum());
        if(exist != null){
            order.remove(exist);
            order.add(entity);
        }
    }

    @Override
    public void delete(String orderNum) {
        order.removeIf(o -> o.getOrderNum().equals(orderNum));
    }
}

