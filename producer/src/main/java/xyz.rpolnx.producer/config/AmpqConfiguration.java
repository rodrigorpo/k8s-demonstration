package xyz.rpolnx.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmpqConfiguration {
    private final String exchange;

    public AmpqConfiguration(@Value("${queue.exchange}") String exchange) {
        this.exchange = exchange;
    }

    @Bean
    Queue queue() {
        return new Queue(exchange, true);
    }
}
