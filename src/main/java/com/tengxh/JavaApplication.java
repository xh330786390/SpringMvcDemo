package com.tengxh;

import com.mysteel.cache.redis.AbstractRedisCache;
import com.mysteel.cache.redis.AbstractRedisCacheImpl;
import com.tengxh.component.ealsticsearch.OrderEsCommonRepository;
import com.tengxh.component.rabbitmq.MessageTest;
import com.tengxh.component.rabbitmq.Producer;
import com.tengxh.entity.DataInfo;
import com.tengxh.entity.User;
import com.tengxh.component.redis.UserService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tengxh.service.DataInfoService;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.List;

public class JavaApplication {
    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.setValidating(false);
        context.load("classpath:/spring/applicationContext.xml");
        context.refresh();

//        UserService userService =  (UserService) context.getBean("userService");
        UserService userService =  (UserService) context.getBean("userClusterService");


        User user1 = new User("user1ID", "User 1");
        User user2 = new User("user2ID", "User 2");

        userService.put(user1);
        userService.put(user2);

        System.out.println("User should be in redis yet: " + userService.get(user1));
        System.out.println("User should be in redis yet: " + userService.get(user2));

//        System.out.println("==== deleting objects from redis ====");
//        userService.delete(user1);
//        userService.delete(user2);
//
//        System.out.println("==== getting objects from redis ====");
//        System.out.println("User is not in redis yet: " + userService.get(user1));
//        System.out.println("User is not in redis yet: " + userService.get(user2));

//        OrderEsCommonRepository esCommonRepository = context.getBean(OrderEsCommonRepository.class);
//        esCommonRepository.createOrderIndex();

        /*
        ApplicationContext acc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        AmqpTemplate template = acc.getBean(AmqpTemplate.class);
        RabbitAdmin rabbitAdmin = acc.getBean(RabbitAdmin.class);

        String changeName = "queueTest";
        String queueName = "queueTest";
//创建exchange, queue及binding, 如果不存在的话
        rabbitAdmin.declareExchange(new DirectExchange(changeName));  //name为要建立的queue名
        rabbitAdmin.declareQueue(new Queue(queueName));
        rabbitAdmin.declareBinding(new Binding(changeName, Binding.DestinationType.QUEUE, queueName, "", null));
//data要发往queue中的数据
        template.convertAndSend(queueName, "123456");
*/

//        Producer redisCache = context.getBean(Producer.class);
//        redisCache.sendMessage("123");

        //Redis集群调用
        /*
        AbstractRedisCache redisCache = context.getBean(AbstractRedisCacheImpl.class);
        redisCache.set("a1", "a1");
        String strValue = redisCache.get("a1", "");
        System.out.println(strValue);
        */


        //访问数据库
//        DataInfoService service = context.getBean(DataInfoService.class);
//        List<DataInfo> list = service.selectInfo();
//        for (int i = 0; i < list.size(); i++) {
//            DataInfo data = list.get(i);
//            System.out.println(data.getDataName());
//        }
    }
}


