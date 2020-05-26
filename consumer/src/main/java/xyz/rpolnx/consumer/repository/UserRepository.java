package xyz.rpolnx.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.rpolnx.consumer.model.Customer;

import java.util.List;

public interface UserRepository extends CrudRepository<Customer, Long> {
    @Override
    List<Customer> findAll();
}
