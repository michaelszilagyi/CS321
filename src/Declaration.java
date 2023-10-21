import java.util.ArrayList;
/*
 * This is the class which represents a user's declaration of financial support for an alien.
 * All of the relevant information is stored here before being sent to the Workflow/DB.
 * Basic validation also occurs here to ensure proper formatting.
 */
public class Declaration {
    public String date;
    public String name;
    public String email;
    public int durationOfSupport;
    public int applicantNumber;
    public String immigrantName;
    public int alienNumber;
    public Boolean isExpired;
    public int declarationID;

    //for this minimum viable product, Declaration will just own the
    //workflow table.
    private static WorkflowTable table;

    //Constructor
    public Declaration(){
        
    }

    /* This is definitely an antipattern but makes
     * the class easy to test; to be refactored.
     */
    //Constructor with list of parameters
    public Declaration(ArrayList<Object> fields) {
        
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
