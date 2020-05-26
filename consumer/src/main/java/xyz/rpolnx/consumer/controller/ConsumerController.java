package xyz.rpolnx.consumer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pereira.rodrigo.consumer.contract.UserContract;
import com.pereira.rodrigo.consumer.model.Customer;
import com.pereira.rodrigo.consumer.model.CustomerData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private final UserContract userContract;

    @Autowired
    public ConsumerController(UserContract userContract) {
        this.userContract = userContract;
    }

    @RabbitListener(queues = "user")
    public void receive(@Payload String customer) throws JsonProcessingException {
        CustomerData customerData = new ObjectMapper().readValue(customer, CustomerData.class);
        userContract.createUser(mapperCustomerData(customerData));
    }

    private Customer mapperCustomerData(CustomerData customerData) {
        return Customer.builder()
                .birthday(customerData.getBirthday())
                .cpf(customerData.getCpf())
                .id(customerData.getId())
                .email(customerData.getEmail())
                .kafkaOrder(customerData.getKafkaOrder())
                .name(customerData.getName())
                .build();
    }

    ;
}
