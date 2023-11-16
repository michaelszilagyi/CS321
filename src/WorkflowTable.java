import java.util.*;
import java.util.HashMap;


public class WorkflowTable {
    public enum Step {
        ENTRY,
        REVIEW,
        APPROVAL
    }
    private static LinkedHashMap<Integer,Step> WF;

    /* work */
    public WorkflowTable(){
        WF = new LinkedHashMap<Integer,Step>();
    }

    public Integer getTask(Step step){
        Set<Integer> keys = WF.keySet();
        for(Integer key : keys){
            if(WF.get(key) == step){
                //since they are kept in the order they are inserted, this will find the first
                //task of a given step

                //return the unique Declaration ID of this Task, which can then be used to find the Declaration
                //object in the fake database
                return key;
            }
        }
        //return null if there are no Tasks for the given Step
        return null;
    }

    public void addTask(Integer DeclarationID, Step step){
        //puts the given information at the end of the LinkedHashMap
        WF.put(DeclarationID,step);
    }

    /* This should remove the task with the given id*/
    public void removeTask(Integer DeclarationID){
        WF.remove(DeclarationID);
    }
}
