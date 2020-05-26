package xyz.rpolnx.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.rpolnx.consumer.model.Customer;
import xyz.rpolnx.consumer.repository.UserRepository;
import xyz.rpolnx.consumer.service.UserService;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<Customer> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Customer get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Customer customer) {
        String[] list = new String[]{"Rodrigo", "Maycon", "Rogerio", "Tayrone", "Thiago", "Eduardo"};
        int index = new Random().nextInt(list.length);
        customer.setName(list[index]);
        userRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer newCustomer) {
        newCustomer.setId(id);
        return userRepository.save(newCustomer);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
