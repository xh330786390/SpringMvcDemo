package com.tengxh;

import com.tengxh.component.ealsticsearch.CustomRepository;
import com.tengxh.component.ealsticsearch.impl.ArticleRepositoryImpl;
import com.tengxh.entity.ArticleInfo;
import com.tengxh.service.ArticleService;
import com.tengxh.service.impl.ArticleServiceImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JavaApplication {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.setValidating(false);
        context.load("spring/applicationContext.xml");
        context.refresh();

        //ES
        CustomRepository customRepository = context.getBean(ArticleRepositoryImpl.class);

        //es索引，没有则创建
        String indexName = "my_index";
        if (!customRepository.isIndexExists(indexName)) {
            customRepository.createIndex(indexName);
        }

        ArticleService articleService = context.getBean(ArticleServiceImpl.class);
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleId("001");
        articleInfo.setArticleTitle("title001");

        articleService.save(articleInfo);

        ArticleInfo vvv = articleService.findOneById("001");


        System.out.println("完成");

        //RabbitMq
        //Producer producer = context.getBean(Producer.class);
        //producer.sendMessage("tengxh");

        //Reids 单机
//        UserService userService =  (UserService) context.getBean("userService");

        //Redis集群
        //UserService userService =  (UserService) context.getBean("userClusterService");

//        User user1 = new User(1, "User 1");
//        User user2 = new User(2, "User 2");
//
//        userService.put(user1);
//        userService.put(user2);
//
//        System.out.println("User should be in redis yet: " + userService.get(user1));
//        System.out.println("User should be in redis yet: " + userService.get(user2));

//        System.out.println("==== deleting objects from redis ====");
//        userService.delete(user1);
//        userService.delete(user2);
//
//        System.out.println("==== getting objects from redis ====");
//        System.out.println("User is not in redis yet: " + userService.get(user1));
//        System.out.println("User is not in redis yet: " + userService.get(user2));

        //访问数据库
//        DataInfoService service = context.getBean(DataInfoService.class);
//        List<DataInfo> list = service.selectInfo();
//        for (int i = 0; i < list.size(); i++) {
//            DataInfo data = list.get(i);
//            System.out.println(data.getDataName());
//        }
    }
}


