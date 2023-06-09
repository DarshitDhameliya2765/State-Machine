//package com.springstatemachine.statemachinedifferentexample;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.config.EnableStateMachine;
//import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
//
//@Configuration
//@EnableStateMachine
//public class TaskStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {
//
//    @Override
//    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
//        states
//                .withStates()
//                .initial("TODO")
//                .state("IN_PROGRESS")
//                .end("DONE");
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
//        transitions
//                .withExternal()
//                .source("TODO").target("IN_PROGRESS").event("start")
//                .and()
//                .withExternal()
//                .source("IN_PROGRESS").target("DONE").event("complete");
//    }
//}