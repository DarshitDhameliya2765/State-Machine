//package com.springstatemachine.redisconfig;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.SerializationException;
//import org.springframework.statemachine.ObjectStateMachine;
//
//import java.io.IOException;
//
//public class ObjectStateMachineSerializer implements RedisSerializer<ObjectStateMachine<?,?>> {
//
//    private final ObjectMapper mapper;
//
//    public ObjectStateMachineSerializer(ObjectMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    @Override
//    public byte[] serialize(ObjectStateMachine<?,?> stateMachine) throws SerializationException {
//        try {
//            return mapper.writeValueAsBytes(stateMachine);
//        } catch (JsonProcessingException e) {
//            throw new SerializationException("Error serializing object state machine", e);
//        }
//    }
//
//    @Override
//    public ObjectStateMachine<?,?> deserialize(byte[] bytes) throws SerializationException {
//        try {
//            return mapper.readValue(bytes, ObjectStateMachine.class);
//        } catch (IOException e) {
//            throw new SerializationException("Error deserializing object state machine", e);
//        }
//    }
//}