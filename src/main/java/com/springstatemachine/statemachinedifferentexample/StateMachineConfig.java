//package com.springstatemachine.statemachinedifferentexample;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.StateMachinePersist;
//import org.springframework.statemachine.config.EnableStateMachine;
//import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
//import org.springframework.statemachine.persist.StateMachineRuntimePersister;
//
//@Configuration
//@EnableStateMachine
//public class StateMachineConfig extends StateMachineConfigurerAdapter<String, String> {
//
//
//    @Autowired
//    private StateMachineRuntimePersister<String, String, String> stateMachineRuntimePersister;
//
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<String, String> config)
//            throws Exception {
//        config
//                .withPersistence()
//                .runtimePersister(stateMachineRuntimePersister);
//    }
//}
