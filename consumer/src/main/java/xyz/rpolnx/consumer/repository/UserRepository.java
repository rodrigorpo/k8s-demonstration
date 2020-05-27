package xyz.rpolnx.consumer.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.rpolnx.consumer.model.Customer;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<Customer, Long> {
}
