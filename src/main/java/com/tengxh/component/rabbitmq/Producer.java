package com.tengxh.component.rabbitmq;
import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

/**
 * 功能概要：消息产生,提交到队列中去
 *
 * @author linbingwen
 * @since 2016年1月15日
 */
@Service
public class Producer {

//    @Resource(name = "myAmqpTemplate")
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        amqpTemplate.convertAndSend("hello", message);
    }
}
