package com.mq.springrabbit.serv;

import com.mq.springrabbit.config.Configinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = Configinfo.QUEUE)
    public void receive(String message) {
        logger.info("消息:" + message);
    }
}
