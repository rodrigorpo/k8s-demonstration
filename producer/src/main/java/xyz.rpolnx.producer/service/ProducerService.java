package xyz.rpolnx.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import xyz.rpolnx.producer.model.CustomerData;

public interface ProducerService {
    void publishMessagesByNumber(CustomerData customerData, Long numberOfMessages) throws JsonProcessingException;
}
