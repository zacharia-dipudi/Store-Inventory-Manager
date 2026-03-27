package Factory;

/* CustomerFactory.java
Customer Factory class
Author: Matthew Ferreira (230048870)
Date: 16 March 2026*/

import Domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(
            String customerId,
            String firstName,
            String surname,
            String email,
            String phoneNumber,
            String address,
            String city,
            String postalCode,
            String country){
        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setSurname(surname)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setCity(city)
                .setPostalCode(postalCode)
                .setCountry(country)
                .build();
    }
}
