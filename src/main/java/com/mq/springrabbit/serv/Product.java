package com.mq.springrabbit.serv;

import com.mq.springrabbit.config.Configinfo;
import com.mq.springrabbit.config.RestResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "")
public class Product {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 生产者（send）
     */
    @RequestMapping(value = "message/send",method = RequestMethod.GET)
    public RestResult send() {
        RestResult result = new RestResult();
        Map<String,Object> data = new HashMap<String, Object>();
        String message = "test";
        rabbitTemplate.convertAndSend(Configinfo.QUEUE, message);
        return result;
    }
}
