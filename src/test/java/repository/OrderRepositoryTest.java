package repository;

/* OrderRepositoryTest.java
OrderRepository class
Author: Matthew Ferreira (230048870)
Date: 20 March 2026*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import Domain.Order;

public class OrderRepositoryTest {

    private IOrderRepository repository;
    private Order order;

    @BeforeEach
    public void setup() {
        repository = OrderRepositoryImpl.getRepository();
        repository.getAll().clear();

        order = new Order.Builder()
                .setOrderNum("ORD001")
                .setCustomerId("CUST001")
                .setOrderDate("1/Jan/2026")
                .setDeliveryDate("6/Jan/2026")
                .setTotalAmount(10000.0)
                .setStatus("Delivered")
                .setItem("Signed Baseball bat MLB")
                .build();
    }

    @Test
    public void createOrderTest() {
        Order created = repository.create(order);
        assertNotNull(created);
        assertEquals("ORD001", created.getOrderNum());
    }

    @Test
    public void readOrderTest() {
        repository.create(order);
        Order retrieved = repository.read("ORD001");
        assertNotNull(retrieved);
        assertEquals("CUST001", retrieved.getCustomerId());
        assertEquals(10000.0, retrieved.getTotalAmount());
    }

    @Test
    public void updateOrderTest() {
        repository.create(order);
        Order update = new Order.Builder()
                .setOrderNum("ORD001")
                .setCustomerId("CUST001")
                .setOrderDate("1/Jan/2026")
                .setDeliveryDate("6/Jan/2026")
                .setTotalAmount(15000.0)
                .setStatus("Shipped")
                .setItem("Signed Baseball bat MLB")
                .build();

        Order updated = repository.update(update);
        assertNotNull(updated);
        assertEquals(15000.0, updated.getTotalAmount());
        assertEquals("Shipped", updated.getStatus());
    }

    @Test
    public void deleteOrderTest() {
        repository.create(order);
        boolean deleted = repository.delete("ORD001");
        assertTrue(deleted);
        Order retrievedOrd = repository.read("ORD001");
        assertNull(retrievedOrd);
    }

    @Test
    public void getAllOrderTest() {
        repository.create(order);
        assertFalse(repository.getAll().isEmpty());
    }
}