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

    public Declaration(){
        
    }

    public Declaration(String date, String name, String email, int durationOfSupport, int applicantNumber, String immigrantName, int alienNumber, Boolean isExpired, int declarationID){
        
    }

    public Boolean save(){
        return null;
    }

    public Declaration retrieveDeclaration(int declarationID){
        return null;
    }

    private void validate(){

    }

    public void create(){

    }

    public void checkPrevDeclaration(int applicantNumber){

    }

    /* Getter and Setter Methods */
    public String getDate(){
        return null;
    }

    public void setDate(String date){
        this.date = null;
    }

    public String getName(){
        return null;
    }

    public void setName(String name){
        this.name = null;
    }

    public String getEmail(){
        return null;
    }

    public void setEmail(String email){
        this.email = null;
    }

    public int getDuration(){
        return -1;
    }

    public void setDuration(int duration){
        this.durationOfSupport = -1;
    }

    public int getApplicantNumber(){
        return -1;
    }

    public void setApplicantNumber(int applicantNumber){
        this.applicantNumber = -1;
    }

    public String getImmigrantName(){
        return null;
    }

    public void setImmigrantName(String immigrantName){
        this.immigrantName = null;
    }

    public int getAlienNumber(){
        return -1;
    }

    public void setAlienNumber(int alienNumber){
        this.alienNumber = -1;
    }

    public Boolean getIsExpired(){
        return null;
    }

    public void setIsExpired(Boolean isExpired){
        this.isExpired = null;
    }

    public int getDeclarationID(){
        return -1;
    }

    public void setDelarationID(int declarationID){
        this.declarationID = -1;
    }

}
