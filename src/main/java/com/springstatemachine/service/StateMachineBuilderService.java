package com.springstatemachine.service;

import com.springstatemachine.Repository.StateRepository;
import com.springstatemachine.Repository.TransitionRepository;
import com.springstatemachine.model.State;
import com.springstatemachine.model.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StateMachineBuilderService {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    TransitionRepository transitionRepository;

    @Autowired
    StateMachineRuntimePersister stateMachineRuntimePersister;

    public StateMachine<String, String> buildStateMachine(String workflowId) throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();

        // Query the database to get the states
        List<State> states = stateRepository.findAllByWorkflowId(workflowId);

        List<String> statesName = new ArrayList<>();

        for (State state : states) {
            statesName.add(state.getState());
        }

        // Add the states to the builder
        builder.configureStates()
                .withStates()
                .initial("SI")
                .states(new HashSet<>(statesName));

        // Query the database to get the transitions
        List<Transition> transitions = transitionRepository.findAllByWorkflowId(workflowId);

        // Add the transitions to the builder
        for (Transition transition : transitions) {
            builder.configureTransitions()
                    .withExternal()
                    .source(transition.getStateFrom())
                    .target(transition.getStateTo())
                    .event(transition.getEvent());
        }

        return builder.build();
    }

    public StateMachine<String, String> stateMachineTarget() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();

        builder.configureConfiguration().withPersistence().runtimePersister(stateMachineRuntimePersister);
        // Add the states to the builder
        builder.configureStates()
                .withStates()
                .initial("SI")
                .state("S1");

            builder.configureTransitions()
                    .withExternal()
                    .source("SI")
                    .target("S1")
                    .event("E1");

        return builder.build();
    }

}