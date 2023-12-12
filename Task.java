package task;


import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    //Declared constants for character limits
    private static final int ID_MAX = 10;
    private static final int NAME_MAX = 20;
    private static final int DESC_MAX = 50;
    private static AtomicInteger createId = new AtomicInteger(1);

    //Variable for task id, set to private final to prevent the id from being updated
    private final String taskId;

    //Task variables
    private String taskName;
    private String taskDescription;



    //Constructor
    public Task (String taskName, String taskDescription) {

        this.taskId = "TS"+String.format("%08d", createId.getAndIncrement()); //Concatenates TS to the ID to note that the ID is a Task ID

        dataValidator(taskId, ID_MAX); //Call dataValidator method - passes taskId and ID_MAX as parameters

        dataValidator(taskName, NAME_MAX); //Call dataValidator method - passes taskName and NAME_MAX as parameters

        dataValidator(taskDescription, DESC_MAX); //Call dataValidator method - passes taskDescription and DESC_MAX as parameters


        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    //Getters
    public String getTaskId()
    {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    //Setters
    public void setTaskName(String taskName)
    {
        dataValidator(taskName, NAME_MAX);
        this.taskName= taskName;
    }

    public void setTaskDescription(String taskDescription) {
        dataValidator(taskDescription, DESC_MAX);
        this.taskDescription = taskDescription;
    }

    // Validates data passed through the parameters, checks if input is null and whether the input exceeds
    // charCriteria. Used to check taskId, taskName, and taskDescription

    private void dataValidator(String input, int charCriteria) {
        if(input == null){
            throw new IllegalArgumentException("Invalid. Data cannot be null.");
        }
        if(input.length()>charCriteria) {
            throw new IllegalArgumentException("Invalid. Data is " + input.length() +" characters and cannot exceed " + charCriteria + " characters.");
        }
    }
}
