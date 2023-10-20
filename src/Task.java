public class Task {
    public int id;
    public WorkflowTable.Step step;

    public Task(int declarationID, WorkflowTable.Step step){
        this.id = declarationID;
        this.step = step;
    }
}