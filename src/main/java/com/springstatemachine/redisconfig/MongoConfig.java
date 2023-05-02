package com.springstatemachine.redisconfig;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.MongoConfigurationSupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.data.mongodb.MongoDbPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.mongodb.MongoDbStateMachineRepository;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

@Configuration
public class MongoConfig {

//    @Value("${spring.data.mongodb.host}")
//    private String host;
//
//    @Value("${spring.data.mongodb.port}")
//    private int port;
//
//    @Value("${spring.data.mongodb.database}")
//    private String database;
//
//    @Override
//    protected String getDatabaseName() {
//        return database;
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new MongoClient(host, port);
//    }
    @Bean
    public StateMachineRuntimePersister<String, String, String> mongoRuntimePersist(
        MongoDbStateMachineRepository repository) {
    return new MongoDbPersistingStateMachineInterceptor<>(repository);
}

    @Bean
    public StateMachinePersister<String, String, String> persister(
            StateMachinePersist<String, String, String> defaultPersist) {

        return new DefaultStateMachinePersister<>(defaultPersist);
    }
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/mydb");
//        MongoClient mongoClient = new MongoClient(uri);
//        return new MongoTemplate(mongoClient, "mydb");
//    }
//
//    @Bean
//    public StateMachinePersist<String, String, String> stateMachinePersist(MongoTemplate mongoTemplate) {
//        return new MongoDbPersistingStateMachineInterceptor<>(new MongoDbStateMachineRepository(mongoTemplate));
//    }

}

