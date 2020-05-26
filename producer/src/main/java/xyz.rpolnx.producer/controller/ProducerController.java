package xyz.rpolnx.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rpolnx.producer.PublishUser;
import xyz.rpolnx.producer.service.ProduceService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/produce")
@RequiredArgsConstructor
public class ProducerController {
    private ProduceService produceService;

    @Autowired
    public ProducerController(ProduceService produceService) {
        this.produceService = produceService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody PublishUser publishUser) throws JsonProcessingException {
        produceService.publishMessagesByNumber(publishUser.getCustomer(), publishUser.getNumberOfMessages());
    }
}
