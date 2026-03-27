package Domain;

/* OrderTest.java
OrderTest class
Author: Matthew Ferreira (230048870)
Date: 18 March 2026*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order order;

    @BeforeEach
    public void setup(){
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
    public void orderCreatedTest(){
        assertNotNull(order);
    }

    @Test
    public void createOrderAllFieldsTest(){
        assertEquals("ORD001",order.getOrderNum());
        assertEquals("CUST001",order.getCustomerId());
        assertEquals("1/Jan/2026",order.getOrderDate());
        assertEquals("6/Jan/2026",order.getDeliveryDate());
        assertEquals(10000.0 ,order.getTotalAmount());
        assertEquals("Delivered",order.getStatus());
        assertEquals("Signed Baseball bat MLB",order.getItem());

        assertNotNull(order);
    }
}
