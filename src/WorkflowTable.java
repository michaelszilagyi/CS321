import java.util.*;

public class WorkflowTable {
    public enum Step {
        ENTRY,
        REVIEW,
        APPROVAL
    }
    public static Queue<Task> tasks = new LinkedList<Task>();

    public WorkflowTable(){

    }

    public static Task getTask(Step step){
        return null;
    }

    public static void addTask(Task t){

    }

    /* This should remove the task with the given id, and then return it */
    public static Task removeTask(int id){
        return null;
    }
}
