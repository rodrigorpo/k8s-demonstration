package xyz.rpolnx.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.rpolnx.consumer.model.Customer;
import xyz.rpolnx.consumer.repository.UserRepository;
import xyz.rpolnx.consumer.service.UserService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    
    private final String[] randomNameList = "Nagato,Deidara,Konan,Itachi,Zetsu,Orochimaru,Kisame,Kakuzu,Hidan,Sasori,Obito".split(",");

    @Override
    public Page<Customer> getAll(int page, int size) {
        Pageable limit = PageRequest.of(page, size);
        return userRepository.findAll(limit);
    }

    @Override
    public Customer get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Customer customer) {
        int index = new Random().nextInt(randomNameList.length);
        customer.setName(randomNameList[index]);
        customer.setId(null); //always recreate
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
