package com.springstatemachine.Repository;

import org.springframework.statemachine.data.mongodb.MongoDbStateMachineRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyMongoStateMachineRepo extends MongoDbStateMachineRepository {
}