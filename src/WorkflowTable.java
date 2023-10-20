import java.util.*;

public class WorkflowTable {
    public static Queue<Tuple> tasks = new LinkedList<Tuple>();

    public WorkflowTable(){

    }

    public int getNextItem(String step){
        return -1;
    }

    public static void addTask(int id, String step){

    }

    public static Tuple removeTask(){
        return null;
    }
}
