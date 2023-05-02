package com.springstatemachine.Repository;

import com.springstatemachine.model.State;
import com.springstatemachine.model.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransitionRepository extends JpaRepository<Transition, Long> {

    List<Transition> findAllByWorkflowId(String workflowId);
}
