package xyz.rpolnx.consumer.service;

import com.google.common.collect.Lists;
import com.pereira.rodrigo.consumer.contract.UserContract;
import com.pereira.rodrigo.consumer.model.Customer;
import com.pereira.rodrigo.consumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService implements UserContract {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Customer> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public Customer getSingleUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(Customer customer) {
        String[] list = new String[]{"Rodrigo", "Maycon", "Rogerio", "Tayrone", "Thiago", "Eduardo"};
        int index = new Random().nextInt(list.length);
        customer.setName(list[index]);
        userRepository.save(customer);
    }

    @Override
    public Customer updateUser(Long id, Customer newCustomer) {
        newCustomer.setId(id);
        return userRepository.save(newCustomer);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
