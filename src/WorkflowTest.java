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

    
}
