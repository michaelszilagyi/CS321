import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WorkflowTest {
    
    @Test
    void test_1(){
        Queue<Tuple> temp = new LinkedList<Tuple>();
        Tuple task = new Tuple(1, "Review");
        temp.add(task);
        WorkflowTable.addTask(1, "Review");
        assertEquals(temp, WorkflowTable.tasks);
    }

    @Test
    void test_2(){
        WorkflowTable temp = new WorkflowTable();
        int declID =temp.getNextItem("Review");
        assertEquals(1, declID);
    }

    @Test
    void test_3(){
        Tuple task = new Tuple(1, "Review");
        Tuple removedTask = WorkflowTable.removeTask();
        assertEquals(task, removedTask);
    }



    
}
