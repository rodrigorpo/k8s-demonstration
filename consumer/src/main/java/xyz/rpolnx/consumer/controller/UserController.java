package xyz.rpolnx.consumer.controller;

import com.pereira.rodrigo.consumer.contract.UserContract;
import com.pereira.rodrigo.consumer.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserContract userContract;

    public UserController(UserContract userContract) {
        this.userContract = userContract;
    }

    @GetMapping
    @ResponseStatus(OK)
    private List<Customer> getUser() {
        return userContract.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    private Customer getSingleUser(@PathVariable Long id) {
        return userContract.getSingleUser(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    private void createUser(@RequestBody Customer customer) {
        userContract.createUser(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    private Customer updateUser(@PathVariable Long id, @RequestBody Customer customer) {
        return userContract.updateUser(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    private void deleteUser(@PathVariable Long id) {
        userContract.deleteUser(id);
    }
}