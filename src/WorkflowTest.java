import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.util.*;

/* Test the methods in WorkflowTable.
 * Tests must be run from top to bottom, as subsequent tests use
 * persistent state from previous ones.
 */
public class WorkflowTest {
    int id = 1;
    WorkflowTable table;
    @Test
    void testConstructor(){
        table = new WorkflowTable();
        Queue<Task> temp = new LinkedList<Task>();

        Task task = new Task(++id, WorkflowTable.Step.REVIEW);
        temp.add(task);
        table.addTask(task);
        assertEquals(temp, WorkflowTable.tasks);
    }

    /* Tests getTask and addTask.
     * Assumes table was properly initialized in previous test
     */
    @Test
    void testAddAndGet(){
        var task1 = new Task(++id, WorkflowTable.Step.REVIEW);
        var task2 = new Task(++id, WorkflowTable.Step.APPROVAL);
        var task3 = new Task(++id, WorkflowTable.Step.REVIEW);

        table.addTask(task1);
        table.addTask(task2);
        table.addTask(task3);

        var dec1 = table.getTask(WorkflowTable.Step.REVIEW);
        var dec2 = table.getTask(WorkflowTable.Step.APPROVAL);
        assertEquals(task3.id, dec1.id);
        assertEquals(task2.id, dec2.id);
    }

    /* Tests the removeTask method.
     * Assumes table has been initialized.
     */
    @Test
    void testRemoveTask(){
        Task task = new Task(++id, WorkflowTable.Step.REVIEW);
        Task removedTask = table.removeTask(id);
        assertEquals(task, removedTask);
    }



    
}
