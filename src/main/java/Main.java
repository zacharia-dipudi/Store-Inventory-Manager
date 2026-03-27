/* Main.java
Main class
Author: Matthew Ferreira (230048870)
Date: 24 March 2026*/

/*Author : Zacharia dipidi
Date: 24 march 2026
 */

import Domain.Customer;
import Domain.Order;
import Factory.CustomerFactory;
import Factory.OrderFactory;
import repository.CustomerRepositoryImpl;
import repository.OrderRepositoryImpl;
import Domain.Product;
import Domain.Store;
import Factory.StoreFactory;
import Factory.productFactory;

public class Main {
        public static void main(String[] args) {
            System.out.println("|--------Customer--------|");

            CustomerRepositoryImpl customerRepo = CustomerRepositoryImpl.getRepository();
            customerRepo.getAll().clear();

            Customer cust1 = CustomerFactory.createCustomer("CUST001", "Lex", "Fridman", "lex@example.com",
                    "+27 84 797 2480", "28 Space road", "Cape Town", "7599", "South Africa");
            Customer cust2 = CustomerFactory.createCustomer("CUST002", "John", "David", "johnDavid@gmail.com",
                    "+27 74 519 456", "12 Eagle St", "Cape Town", "7479", "South Africa");

            customerRepo.create(cust1);
            customerRepo.create(cust2);

            Customer retrievedCus1 = customerRepo.read("CUST001");
            System.out.println("Customer 1");
            System.out.println("Customer ID: " + retrievedCus1.getCustomerId());
            System.out.println("Name: " + retrievedCus1.getFirstName() + " " + retrievedCus1.getSurname());
            System.out.println("Email: " + retrievedCus1.getEmail());
            System.out.println("Phone Number: " + retrievedCus1.getPhoneNumber());
            System.out.println("Address: " + retrievedCus1.getAddress());
            System.out.println("City: " + retrievedCus1.getCity());
            System.out.println("Postal Code: " + retrievedCus1.getPostalCode());
            System.out.println("Country: " + retrievedCus1.getCountry() + "\n");

            Customer retrievedCus2 = customerRepo.read("CUST002");
            System.out.println("Customer 2");
            System.out.println("Customer ID: " + retrievedCus2.getCustomerId());
            System.out.println("Name: " + retrievedCus2.getFirstName() + " " + retrievedCus2.getSurname());
            System.out.println("Email: " + retrievedCus2.getEmail());
            System.out.println("Phone Number: " + retrievedCus2.getPhoneNumber());
            System.out.println("Address: " + retrievedCus2.getAddress());
            System.out.println("City: " + retrievedCus2.getCity());
            System.out.println("Postal Code: " + retrievedCus2.getPostalCode());
            System.out.println("Country: " + retrievedCus2.getCountry() + "\n");

            System.out.println("Updated Customer 1 (name change)");
            Customer custUpdate = new Customer.Builder()
                    .setCustomerId("CUST001")
                    .setFirstName("Alexander")
                    .setSurname("Fridman")
                    .setEmail("alex@gmail.com")
                    .setPhoneNumber("+27 84 797 2480")
                    .setAddress("28 Space road")
                    .setCity("Cape Town")
                    .setPostalCode("7599")
                    .setCountry("South Africa")
                    .build();
            customerRepo.update(custUpdate);
            System.out.println("Customer ID: " + customerRepo.read("CUST001").getCustomerId());
            System.out.println("Customer Name: " + customerRepo.read("CUST001").getFirstName() + " " + customerRepo.read("CUST001").getSurname());
            System.out.println("Email: " + customerRepo.read("CUST001").getEmail());
            System.out.println("Phone Number: " + customerRepo.read("CUST001").getPhoneNumber());
            System.out.println("Address: " + customerRepo.read("CUST001").getAddress());
            System.out.println("City: " + customerRepo.read("CUST001").getCity());
            System.out.println("Postal Code: " + customerRepo.read("CUST001").getPostalCode());
            System.out.println("Country: " + customerRepo.read("CUST001").getCountry() + "\n");

            System.out.println("Deleting customer CUST002");
            customerRepo.delete("CUST002");
            System.out.println("Deleted: " + customerRepo.read("CUST002") + "\n");

            System.out.println("|--------Order--------|\n");

            OrderRepositoryImpl orderRepo = OrderRepositoryImpl.getRepository();
            orderRepo.getAll().clear();

            Order order1 = OrderFactory.createOrder(
                    "ORD001", "CUST001", "1/Jan/2026", "6/Jan/2026",
                    10000.0, "Pending", "Signed Baseball bat");
            Order order2 = OrderFactory.createOrder(
                    "ORD002", "CUST002", "12/Feb/2026", "14/Feb/2026",
                    3000.0, "Delivered", "Air Fryer");
            orderRepo.create(order1);
            orderRepo.create(order2);

            Order retrievedOrd1 = orderRepo.read("ORD001");
            System.out.println("Order 1");
            System.out.println("OrderNum: " + retrievedOrd1.getOrderNum());
            System.out.println("Customer ID: " + retrievedOrd1.getCustomerId());
            System.out.println("Order Date: " + retrievedOrd1.getOrderDate());
            System.out.println("Delivery Date: " + retrievedOrd1.getDeliveryDate());
            System.out.println("Total Amount: " + retrievedOrd1.getTotalAmount());
            System.out.println("Status: " + retrievedOrd1.getStatus());
            System.out.println("Item: " + retrievedOrd1.getItem() + "\n");

            Order retrievedOrd2 = orderRepo.read("ORD002");
            System.out.println("Order 2");
            System.out.println("OrderNum: " + retrievedOrd2.getOrderNum());
            System.out.println("Customer ID: " + retrievedOrd2.getCustomerId());
            System.out.println("Order Date: " + retrievedOrd2.getOrderDate());
            System.out.println("Delivery Date: " + retrievedOrd2.getDeliveryDate());
            System.out.println("Total Amount: " + retrievedOrd2.getTotalAmount());
            System.out.println("Status: " + retrievedOrd2.getStatus());
            System.out.println("Item: " + retrievedOrd2.getItem() + "\n");

            System.out.println("Updated Order 1 (status change)");
            Order orderUpdate = new Order.Builder()
                    .setOrderNum("ORD001")
                    .setCustomerId("CUST001")
                    .setOrderDate("1/Jan/2026")
                    .setDeliveryDate("6/Jan/2026")
                    .setTotalAmount(10000.0)
                    .setStatus("Shipped")
                    .setItem("Signed Baseball bat")
                    .build();
            orderRepo.update(orderUpdate);
            System.out.println("Order Number: " + orderRepo.read("ORD001").getOrderNum());
            System.out.println("Customer ID: " + orderRepo.read("ORD001").getCustomerId());
            System.out.println("Order Date: " + orderRepo.read("ORD001").getOrderDate());
            System.out.println("Delivery Date: " + orderRepo.read("ORD001").getDeliveryDate());
            System.out.println("Total Amount: " + orderRepo.read("ORD001").getTotalAmount());
            System.out.println("Order Status: " + orderRepo.read("ORD001").getStatus());
            System.out.println("Item: " + orderRepo.read("ORD001").getItem() + "\n");

            System.out.println("Deleting order ORD002");
            orderRepo.delete("ORD002");
            System.out.println("Deleted: " + orderRepo.read("ORD002") + "\n");
            Product product = productFactory.createProduct("1234", "Iphone17", "promax", "R29000");


            Store store = StoreFactory.createStore("410", "Istore", "0114101754", "cape town"
                    ,product);
            System.out.println(store.toString());


        }
}