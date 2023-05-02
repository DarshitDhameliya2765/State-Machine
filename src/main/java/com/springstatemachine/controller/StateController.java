package com.springstatemachine.controller;

import com.springstatemachine.service.StateMachineBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.ObjectStateMachine;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.data.redis.RedisStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StateController {

    @Autowired
    public StateMachineBuilderService stateMachineBuilderService;

    public static final String HASH_KEY = "StateMachine";

    @Autowired
    private StateMachinePersister<String, String, String> stateMachinePersister;

//    @Autowired
//    private StateMachine<String, String> stateMachinefromredis;

//    @Autowired
//    private StateMachineFactory<String, String> stateMachineFactory;

    @GetMapping("/getState")
    public ResponseEntity<?> getState(@RequestParam("id") String workflowId) {

        try {
            StateMachine<String, String> stateMachine = stateMachineBuilderService.buildStateMachine(workflowId);
            stateMachine.start();
            stateMachinePersister.persist(stateMachine, workflowId);

//            stateMachine.sendEvent("E1");
            return ResponseEntity.ok(stateMachine.getState().getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }
    @GetMapping("/getStateFromRedis")
    public ResponseEntity<?> getStateFromRedis(@RequestParam("id") String workflowId) {

        try {
            StateMachine<String, String> stateMachine = resetStateMachineFromStore(workflowId);
            stateMachine.start();
            stateMachine.sendEvent("E1");
            return ResponseEntity.ok(stateMachine.getState().getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }

    private StateMachine<String, String> resetStateMachineFromStore(String user) throws Exception {
         StateMachine<String, String> stateMachineRedis = stateMachineBuilderService.stateMachineTarget();


        return stateMachinePersister.restore(stateMachineRedis,"2");
    }
}
