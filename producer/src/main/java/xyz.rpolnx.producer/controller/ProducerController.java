package xyz.rpolnx.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.rpolnx.producer.model.PublishUser;
import xyz.rpolnx.producer.service.ProducerService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/produce")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody PublishUser publishUser) throws JsonProcessingException {
        service.publishMessagesByNumber(publishUser.getCustomer(), publishUser.getNumberOfMessages());
    }
}
