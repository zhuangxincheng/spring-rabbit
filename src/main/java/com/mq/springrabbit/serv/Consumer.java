package com.mq.springrabbit.serv;

import com.alibaba.fastjson.JSON;
import com.mq.springrabbit.config.Configinfo;
import com.mq.springrabbit.config.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * 消费者
     * @param message
     */
    @RabbitListener(queues = Configinfo.QUEUE)
    public void receive(Message message) {

        logger.info("消息:" + JSON.toJSONString(message));
        byte[] body = message.getBody();
        String s = new String(body);
        logger.info("----"+s);
        MessageDTO messageDTO = JSON.parseObject(s, MessageDTO.class);
        logger.info("消息body:" + JSON.toJSONString(messageDTO));
    }
}
