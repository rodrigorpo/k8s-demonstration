package xyz.rpolnx.consumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;
import xyz.rpolnx.consumer.model.Customer;
import xyz.rpolnx.consumer.model.CustomerData;
import xyz.rpolnx.consumer.service.UserService;

@RestController
@RequiredArgsConstructor
public class EventListener {
    private final UserService service;

    @RabbitListener(queues = "${queue.name}")
    public void receive(@Payload String customer) throws JsonProcessingException {
        CustomerData customerData = new ObjectMapper().readValue(customer, CustomerData.class);
        service.create(buildCustomerData(customerData));
    }

    private Customer buildCustomerData(CustomerData customerData) {
        return Customer.builder()
                .birthday(customerData.getBirthday())
                .cpf(customerData.getCpf())
                .id(customerData.getId())
                .email(customerData.getEmail())
                .kafkaOrder(customerData.getKafkaOrder())
                .name(customerData.getName())
                .build();
    }
}
