package xyz.rpolnx.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.rpolnx.consumer.model.Customer;
import xyz.rpolnx.consumer.service.UserService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    @ResponseStatus(OK)
    private List<Customer> getUser() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    private Customer getSingleUser(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    private void createUser(@RequestBody Customer customer) {
        service.create(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    private Customer updateUser(@PathVariable Long id, @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    private void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }
}