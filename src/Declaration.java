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

    //Constructor
    public Declaration(){
        
    }

    //Constructor with parameters
    public Declaration(String date, String name, String email, int durationOfSupport, int applicantNumber, String immigrantName, int alienNumber, Boolean isExpired, int declarationID){
        
    }

    //Saves the Declaration to the Workflow.
    public Boolean save(){
        return null;
    }

    //Retrieves a specific Declaration from the Workflow.
    public Declaration retrieveDeclaration(int declarationID){
        return null;
    }

    //Does basic checks to ensure the user inputted information is correctly formatted.
    private Boolean validate(){
        return false;
    }

}
