public class Tuple {
    private int id;
    private String step;

    public Tuple(int declarationID, String step){
        this.id = declarationID;
        this.step = step;
    }

    public int getID(){
        return this.id;
    }

    public String getStep(){
        return this.step;
    }
}