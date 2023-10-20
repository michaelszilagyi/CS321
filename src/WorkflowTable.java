import java.util.*;

public class WorkflowTable {
    public enum Step {
        ENTRY,
        REVIEW,
        APPROVAL
    }
    public static Queue<Task> tasks;

    /* work */
    public WorkflowTable(){
        tasks = new LinkedList<Task>();
    }

    public Task getTask(Step step){
        return null;
    }

    public void addTask(Task t){

    }

    /* This should remove the task with the given id, and then return it */
    public Task removeTask(int id){
        return null;
    }
}
