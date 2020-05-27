package xyz.rpolnx.producer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.rpolnx.producer.model.CustomerData;
import xyz.rpolnx.producer.service.ProducerService;

@Service
@RequiredArgsConstructor
public class ProduceServiceImpl implements ProducerService {
    private final RabbitTemplate rabbitTemplate;
    @Value("${queue.name}")
    private String queueName;

    public void publishMessagesByNumber(CustomerData customerData, Long numberOfMessages) throws JsonProcessingException {
        for (int i = 0; i < numberOfMessages; i++) {
            customerData.setKafkaOrder((long) i);
            rabbitTemplate.convertAndSend(queueName, new ObjectMapper().writeValueAsString(customerData));
        }
    }
}
