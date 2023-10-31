import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*
 * This is the class which represents a user's declaration of financial support for an alien.
 * All of the relevant information is stored here before being sent to the Workflow/DB.
 * Basic validation also occurs here to ensure proper formatting.
 */
public class Declaration {
    public String date;
    public String name;
    public String email;
    public int durationOfSupport; //days
    public int applicantNumber;
    public int immigrantName;
    public int alienNumber;
    public Boolean isExpired;
    public int declarationID;

    //for this minimum viable product, Declaration will just own the
    //workflow table.
    private static WorkflowTable table;

    public static Declaration create() {
        return null;
    }

    public static Declaration create(Map<String,Object> fields) {
        var possible_fields = new HashMap<String, String>();
        return null;
    }

    //Constructor with table of parameters
    private Declaration(Map<String, Object> fields) {
        
    }

    //Saves the Declaration to the Workflow.
    public Boolean save(){
        return null;
    }

    //Retrieves a specific Declaration from the Workflow.
    public static Declaration retrieveDeclaration(int declarationID){
        return null;
    }

    //Does basic checks to ensure the user inputted information is correctly formatted.
    public Boolean validate(){
        return false;
    }
}
