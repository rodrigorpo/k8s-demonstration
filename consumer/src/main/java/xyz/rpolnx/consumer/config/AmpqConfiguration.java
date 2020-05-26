package xyz.rpolnx.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmpqConfiguration {
    @Value("${queue.exchange}")
    private String exchange;

    @Bean
    public Queue queue() {
        return new Queue(exchange, true);
    }
}
