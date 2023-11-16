import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/*
 * This is the class which represents a user's declaration of financial support for an alien.
 * All of the relevant information is stored here before being sent to the Workflow/DB.
 * Basic validation also occurs here to ensure proper formatting.
 */
public class Declaration {
    public String date = null;
    public String name = null;
    public String email = null;
    public int durationOfSupport = -1; //days
    public int applicantNumber = -1;
    public String immigrantName;
    public int alienNumber = -1;
    public Boolean isExpired = true;
    public int declarationID = -1;

    Random rand = new Random();
    
    public static Declaration create() {
        return null;
    }

    public Declaration(String date, String name, String email, int durationOfSupport,
        int applicantNumber, String immigrantName, int alienNumber, Boolean isExpired, int declarationID) {
            this.date = date; this.name = name; this.email = email;
            this.durationOfSupport = durationOfSupport; this.applicantNumber = applicantNumber;
            this.immigrantName = immigrantName;  this.alienNumber = alienNumber;
            this.isExpired = isExpired;
            //generate a random unique DeclarationID to identify this object
            this.declarationID = rand.nextInt(5000);
        }

    //Does basic checks to ensure the user inputted information is correctly formatted.
    public Boolean validate(){
        return false;
    }
}
