package xyz.rpolnx.consumer.service;

import xyz.rpolnx.consumer.model.Customer;

import java.util.List;

public interface UserService {
    List<Customer> getAll();

    Customer get(Long id);

    void create(Customer customer);

    Customer update(Long id, Customer newCustomer);

    void delete(Long id);
}
