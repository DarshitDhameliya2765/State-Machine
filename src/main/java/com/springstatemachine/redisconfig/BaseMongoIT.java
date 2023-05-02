//package com.springstatemachine.redisconfig;
//
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.testcontainers.containers.GenericContainer;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public abstract class BaseMongoIT {
//
//    private static final Integer MONGO_PORT = 27017;
//    private static GenericContainer mongo =
//            new GenericContainer("mongo:latest")
//                    .withExposedPorts(MONGO_PORT);
//
//    static {
//        mongo.start();
//        System.setProperty("spring.data.mongodb.host", mongo.getContainerIpAddress());
//        System.setProperty("spring.data.mongodb.port", mongo.getMappedPort(MONGO_PORT).toString());
//    }
//
//    @Autowired
//    protected MongoTemplate mongoTemplate;
//}
