package br.com.codenation.logstackapi.builders;
import br.com.codenation.logstackapi.model.entity.Customer;

import java.util.UUID;

public class CustomerBuilder {

    private Customer customer;

    private CustomerBuilder() {
    }

    public static CustomerBuilder umCustomer() {
        CustomerBuilder builder = new CustomerBuilder();
        builder.customer = Customer.builder().user(UserBuilder.admin().build())
                .apiKey(UUID.randomUUID())
                .id(UUID.randomUUID())
                .build();
        return builder;
    }

    public static CustomerBuilder doisCustomer() {
        CustomerBuilder builder = new CustomerBuilder();
        builder.customer = Customer.builder().user(UserBuilder.codenation().build())
                .apiKey(UUID.randomUUID())
                .id(UUID.randomUUID())
                .build();
        return builder;
    }

    public Customer build() {
        return customer;
    }

}
