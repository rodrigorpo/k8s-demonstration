package xyz.rpolnx.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.rpolnx.producer.model.CustomerData;

@Service
public class ProduceService {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    @Autowired
    public ProduceService(RabbitTemplate rabbitTemplate, @Value("${queue.name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void publishMessagesByNumber(CustomerData customerData, Long numberOfMessages) throws JsonProcessingException {
        for (int i = 0; i < numberOfMessages; i++) {
            customerData.setKafkaOrder((long) i);
            rabbitTemplate.convertAndSend(queueName, new ObjectMapper().writeValueAsString(customerData));
        }
    }
}
