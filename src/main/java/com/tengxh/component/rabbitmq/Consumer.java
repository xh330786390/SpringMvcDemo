package com.tengxh.component.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 功能概要：消费接收
 *
 * @author linbingwen
 * @since 2016年1月15日
 */
public class Consumer implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void onMessage(Message message) {
        logger.info("receive message:{}", message);
    }
}
