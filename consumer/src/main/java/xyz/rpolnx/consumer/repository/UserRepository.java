package xyz.rpolnx.consumer.repository;

import com.pereira.rodrigo.consumer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Customer, Long> {
}
