import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WorkflowTest {
    
    @Test
    void testConstructor(){
        Queue<Task> temp = new LinkedList<Task>();
        Task task = new Task(1, "Review");
        temp.add(task);
        WorkflowTable.addTask(task);
        assertEquals(temp, WorkflowTable.tasks);
    }

    @Test
    void testGetTask(){
        var test_task = new Task(1, "")

        var declID = WorkflowTable.getTask(WorkflowTable.Step.REVIEW);
        assertEquals(1, declID.id);
    }

    @Test
    void testAddTask() {

    }

    @Test
    void testRemoveTask(){
        int id = 12;
        Task task = new Task(id, WorkflowTable.Step.REVIEW);
        Task removedTask = WorkflowTable.removeTask(id);
        assertEquals(task, removedTask);
    }



    
}
