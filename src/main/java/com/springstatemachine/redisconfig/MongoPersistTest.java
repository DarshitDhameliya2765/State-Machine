//package com.springstatemachine.redisconfig;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.config.StateMachineFactory;
//import org.springframework.statemachine.persist.StateMachinePersister;
//
//public class MongoPersistTest extends BaseMongoIT {
//
//    @Autowired
//    private StateMachinePersister<String, String, String> persister;
//    @Autowired
//    private StateMachineFactory<String, String> stateMachineFactory;
//
//    @Test
//    public void testMongoPersist() throws Exception {
//        // Arrange
//        StateMachine<String, String> firstStateMachine = stateMachineFactory.getStateMachine();
//        StateMachine<String, String> secondStateMachine = stateMachineFactory.getStateMachine();
////
////        firstStateMachine.sendEvent(Events.START_FEATURE);
////        firstStateMachine.sendEvent(Events.DEPLOY);
//
//        // Act
//        persister.persist(firstStateMachine,"2");
////        persister.persist(secondStateMachine, "2");
//        persister.restore(secondStateMachine, "2");
//
//        // Asserts
////        Assertions.assertThat(secondStateMachine.getState().getId())
////                .isEqualTo(States.IN_PROGRESS);
////
////        boolean deployed = (boolean) secondStateMachine.getExtendedState()
////                .getVariables()
////                .get("deployed");
////
////        Assertions.assertThat(deployed).isEqualTo(true);
////
////        // Mongo specific asserts:
////        Assertions.assertThat(mongoTemplate.getCollectionNames())
////                .isNotEmpty();
////
////        List<Document> documents = mongoTemplate.findAll(Document.class,
////                "MongoDbRepositoryStateMachine");
////
////        Assertions.assertThat(documents).hasSize(2);
////        Assertions.assertThat(documents)
////                .flatExtracting(Document::values)
////                .contains(firstStateMachine.getUuid().toString(),
////                        secondStateMachine.getUuid().toString())
////                .contains(firstStateMachine.getState().getId().toString(),
////                        secondStateMachine.getState().getId().toString());
//    }
//}
