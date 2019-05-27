package com.mq.springrabbit.serv;

import com.alibaba.fastjson.JSON;
import com.mq.springrabbit.config.Configinfo;
import com.mq.springrabbit.config.MessageDO;
import com.mq.springrabbit.config.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "")
public class Product {
    @Autowired
    RabbitTemplate rabbitTemplate;

    private static Logger logger =  LoggerFactory.getLogger(Product.class);

    /**
     * 生产者（send）
     */
    @RequestMapping(value = "message/send",method = RequestMethod.GET)
    public RestResult send(@RequestParam(required = false) String mess) {
        RestResult result = new RestResult();
        Map<String,Object> data = new HashMap<String, Object>();
        String message = "test";
        StringBuilder sad = new StringBuilder();
        sad.append("asdfffd");
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageName("message");
        messageDO.setMessageValue(message);
        messageDO.setMessageId(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(Configinfo.QUEUE, JSON.toJSON(messageDO).toString());
        data.put("message",messageDO);
        result.setResponseData(data);
        return result;
    }
}
