//package test;

import static org.junit.jupiter.api.Assertions.*;

import Appointment.Appointment;
import contact.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import task.Task;

class TaskTest {

    protected String testName, testDesc, tenName;
    protected String noName, longName, noDesc, longDesc;

    @BeforeEach
    void setUp() {
        testName = "Test Task";
        testDesc = "Test description";
        noName = null;
        longName = "MaverickGooseTomHangmanMerlinViperJester";
        noDesc = null;
        longDesc = "This description is over fifty characters and thus should fail the test";
        tenName = "asdfghjklpasdfghjklp";
    }


    @Test
    @DisplayName("Test class creation")
    void testTask() {
        Task task = new Task (testName, testDesc);
        assertTrue(task.getTaskName().equals(testName));
        assertTrue(task.getTaskDescription().equals(testDesc));
        System.out.println(task.getTaskId());
    }


    @Test
    @DisplayName("Task ID Cannot be greater than 10 characters")
    void testTaskIdLength() {
        Task task = new Task(testName, testDesc);
        assertFalse(task.getTaskId().length()>10);
    }

    @Test
    @DisplayName("Task ID less than or equal to 10 characters")
    void testTaskIdLessThanEqTen() {
        Task task = new Task(testName, testDesc);
        assertTrue(task.getTaskId().length()<=10);
    }

    @Test
    @DisplayName("Task ID less than or equal to 10 characters")
    void testTaskIdEqTen() {
        Task task = new Task(testName, testDesc);
        assertTrue(task.getTaskId().length()==10);
    }





    @Test
    @DisplayName("Task ID cannot be null.")
    void nullId() {
        Task task = new Task(testName, testDesc);
        System.out.println(task.getTaskId());
        if(task.getTaskId() == null) {
            fail("Task ID is null");
        }

    }


    @Test
    @DisplayName("Task ID must be unique")
    void uniqueTaskId() {
        Task task1 = new Task(testName, testDesc);
        Task task2 = new Task(testName, testDesc);
        Task task3 = new Task(testName, testDesc);

        String id1 = task1.getTaskId();
        String id2 = task2.getTaskId();
        String id3 = task3.getTaskId();

        System.out.println("1: "+ id1 +" 2: "+ id2 +" 3: " + id3);

        assertNotEquals(id1, id2, "IDs are not unique");
        assertNotEquals(id2, id3, "IDs are not unique");
        assertNotEquals(id1, id3, "IDs are not unique");
    }


    @Test
    @DisplayName("Task name may not be null")
    void nullTaskNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Task(noName,testDesc);});
    }



    @Test
    @DisplayName("Task Name Cannot be greater than 20 characters")
    void longTaskNameTest() {
        Task task = new Task(testName,testDesc);
        assertFalse(task.getTaskName().length()>20);
    }

    @Test
    @DisplayName("Task Name less than equal to 20 characters")
    void shortTaskNameTest() {
        Task task = new Task(testName,testDesc);
        assertTrue(task.getTaskName().length()<=20);
    }

    @Test
    @DisplayName("Task Name equal to 20 characters")
    void equalTwentyTaskNameTest() {
        Task task = new Task(tenName,testDesc);
        assertTrue(task.getTaskName().length()==20);
    }



    @Test
    @DisplayName("Task description may not be null")
    void nullTaskDescriptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Task(testName,noDesc);});

    }


    @Test
    @DisplayName("Task description cannot be greater than 50 characters")
    void longTaskDescriptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Task(testName,longDesc);});

    }

    @Test
    @DisplayName("Task description is less than 50 characters.")
    void validDescription() {
        Assertions.assertDoesNotThrow(() -> {
            Task task = new Task(testName,testDesc);
            Assertions.assertEquals(testDesc,task.getTaskDescription());
            Assertions.assertTrue(task.getTaskDescription().length()<50);
        });
    }


    @Test
    @DisplayName("Address equal to 50 characters.")
    void fiftyLengthTaskDesc() {
        String fiftyLengthTaskDesc = "fsdufhdskljhfkjdslhfsjkdfhdsfdsgfffhgdshfddfggfssd";
        Assertions.assertDoesNotThrow(() -> {
            Task task = new Task(testName,fiftyLengthTaskDesc);
            Assertions.assertEquals(fiftyLengthTaskDesc,task.getTaskDescription());
            Assertions.assertEquals(fiftyLengthTaskDesc,task.getTaskDescription());
            Assertions.assertEquals(50,task.getTaskDescription().length());
        });
    }
}
