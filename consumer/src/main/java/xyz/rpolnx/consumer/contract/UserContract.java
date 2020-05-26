package xyz.rpolnx.consumer.contract;

import com.pereira.rodrigo.consumer.model.Customer;

import java.util.List;

public interface UserContract {
    List<Customer> getUsers();

    Customer getSingleUser(Long id);

    void createUser(Customer customer);

    Customer updateUser(Long id, Customer newCustomer);

    void deleteUser(Long id);
}
