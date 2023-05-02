//package statemachinedifferentexample;
//
//import com.springstatemachine.statemachinedifferentexample.TaskStateMachineConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TaskStateMachineConfig.class)
//public class TaskStateMachineConfigTest {
//
//    @Autowired
//    private StateMachine<String, String> stateMachine;
//
//    @Test
//    public void startTask() {
//        stateMachine.getStates();
//        stateMachine.start();
//        stateMachine.sendEvent("start");
//
//        assertEquals("IN_PROGRESS", stateMachine.getState().getId());
//    }
//
//    @Test
//    public void completeTask() {
//        stateMachine.getStates();
//        stateMachine.sendEvent("complete");
//    }
//}
