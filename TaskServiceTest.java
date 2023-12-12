//package test;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {

    protected String testName, testDesc, updateName, updateDesc;
    protected String noName, longName, noDesc, longDesc, missingId, grabId;

    @BeforeEach
    void setUp() {
        testName = "Test Name";
        testDesc = "Test description";
        updateName = "Jack Skellington";
        updateDesc = "Nightmare before Christmas";
        noName = null;
        longName = "JackSallyZeroOogieBoogieMayorLockShockBarrel";
        noDesc = null;
        longDesc = "What's this? There's color everywhere! What's this? There are white things in the air! What's this?";
        missingId = "1";
        grabId = null;
    }


    @Test
    @DisplayName("Tasks can be created")
    void addTaskTest() {
        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        assertNotNull(service.getTaskMap());
    }


    @Test
    @DisplayName("Multiple tasks can be created, and IDs are unique")
    void addMultiTask() {

        TaskService service = new TaskService();
        for(int i = 0; i < 10; i++) {
            service.addTask(testName, testDesc);
        }
        System.out.println(service.getTaskMap().size() + " tasks created.");
        if(service.getTaskMap().size() < 10) {
            fail ("Due to duplicate IDs, not all tasks were created.");
        }


    }


    @Test
    @DisplayName("Duplicate ID Found")
    void duplicateId() {
        TaskService service = new TaskService();
        Task task = new Task(testName,testDesc);
        service.duplicateIdCheck(task.getTaskId(), task);
        service.displayTasks();
        Task task2 = new Task(testName,testDesc);
        service.duplicateIdCheck(task.getTaskId(), task2);
        service.displayTasks();
        assertTrue(service.getTaskMap().size() == 1);
    }


    @Test
    @DisplayName("Delete Task using TaskID")
    void deleteTaskTest() {
        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            service.deleteTasks(service.taskMap.get(i).getTaskId());
        }
        assertTrue(service.getTaskMap().isEmpty());
    }


    @Test
    @DisplayName("Update Task Name using TaskID")
    void updateTaskNameValidation () {

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.taskMap.get(i).getTaskId();
        }

        service.updateTaskName(updateName, grabId);
        service.displayTasks();
        assertEquals(updateName,service.getTaskMap().get(grabId).getTaskName(), "Task name was not updated.");

    }

    @Test
    @DisplayName("Update Task Name- Shall not be null")
    void updateTaskNameNullTest(){

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.taskMap.get(i).getTaskId();
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {service.updateTaskName(noName,service.getTaskMap().get(grabId).getTaskId());});
    }

    @Test
    @DisplayName("Update Task Name- Cannot exceed 20 characters")
    void updateTaskNameLongTest(){

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.taskMap.get(i).getTaskId();
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {service.updateTaskName(longName,service.getTaskMap().get(grabId).getTaskId());});
    }

    @Test
    @DisplayName("Update Task Description using TaskID")
    void updateTaskDescValidation () {

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.taskMap.get(i).getTaskId();
        }

        service.updateTaskDescription(updateDesc, grabId);
        service.displayTasks();
        assertEquals(updateDesc,service.getTaskMap().get(grabId).getTaskDescription(), "Task description was not updated.");

    }



    @Test
    @DisplayName("Update Task Description- Shall not be null")
    void updateTaskDescNullTest(){

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.getTaskMap().get(i).getTaskId();
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {service.updateTaskDescription(noDesc,service.getTaskMap().get(grabId).getTaskId());});
    }

    @Test
    @DisplayName("Update Task Description- Cannnot exceed 50 characters")
    void updateTaskNameDescTest(){

        TaskService service = new TaskService();
        service.addTask(testName, testDesc);
        service.displayTasks();
        for(String i: service.getTaskMap().keySet()) {
            grabId = service.taskMap.get(i).getTaskId();
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {service.updateTaskDescription(longDesc,service.getTaskMap().get(grabId).getTaskId());});;
    }

}
