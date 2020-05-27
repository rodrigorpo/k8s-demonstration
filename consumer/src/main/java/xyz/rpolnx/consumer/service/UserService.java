package xyz.rpolnx.consumer.service;

import org.springframework.data.domain.Page;
import xyz.rpolnx.consumer.model.Customer;

public interface UserService {
    Page<Customer> getAll(int i, int page);

    Customer get(Long id);

    void create(Customer customer);

    Customer update(Long id, Customer newCustomer);

    void delete(Long id);
}
