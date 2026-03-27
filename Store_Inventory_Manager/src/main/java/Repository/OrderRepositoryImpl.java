package Repository;

/* OrderRepositoryImpl.java
OrderRepositoryImpl class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import Domain.Order;

import java.util.ArrayList;
import java.util.List;

import Domain.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderRepositoryImpl implements IOrderRepository {
    private static OrderRepositoryImpl repository = null;
    private List<Order> order = new ArrayList<>();

    public static OrderRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new OrderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Order create(Order entity) {
        boolean success = order.add(entity);
        if (success) {
            return entity;
        }
        return null;
    }

    @Override
    public Order read(String orderNum) {
        for (Order o : order) {
            if (o.getOrderNum().equals(orderNum)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Order update(Order entity) {
        String orderNum = entity.getOrderNum();
        Order oldOrder = read(orderNum);
        if (oldOrder == null) {
            return null;
        }
        boolean success = order.remove(oldOrder);
        if (!success) {
            return null;
        }
        if (order.add(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(String orderNum) {
        Order orderToDelete = read(orderNum);
        if (orderToDelete == null) {
            return false;
        }
        return order.remove(orderToDelete);
    }

    @Override
    public Set<Order> getAll() {
        return new HashSet<>(order);
    }
}