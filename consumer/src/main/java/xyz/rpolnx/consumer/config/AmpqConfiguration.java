package xyz.rpolnx.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
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
