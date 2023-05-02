package com.springstatemachine.Repository;

import com.springstatemachine.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAllByWorkflowId(String workflowId);

}