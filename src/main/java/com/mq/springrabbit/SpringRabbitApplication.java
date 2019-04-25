package com.mq.springrabbit;

import com.mq.springrabbit.config.Configinfo;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(Configinfo.QUEUE);
    }
}
