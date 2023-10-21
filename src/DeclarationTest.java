import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.*;
import java.util.ArrayList;

/*
 * This is the tester class for the Declaration busines object. 
 */
public class DeclarationTest { 
    Declaration decl1;

    //Checks that the Declaration constructor is correctly initializing variables.
    @Test
    void testConstructor(){
        var fields = new ArrayList<Object>();
        fields.add("10/20/2023"); fields.add("anna@gmail.com"); fields.add(2); fields.add(1);
        fields.add("Charlie"); fields.add(134); fields.add(true); fields.add(1);

        decl1 = new Declaration(fields);

        //iterate through all the fields and make sure they've been correctly initialized.
        //the extra brace pair ensures idx goes out of scope afterwards
        { int idx = 0; for (Field f : Declaration.class.getFields()) {
            try {
                assertEquals(fields.get(idx), f.get(decl1));
            } catch(Exception e) {
                System.err.println("this should never run");
                System.exit(idx);
            }
            idx++;
        }}
    }

    //Checks that the retrieveDeclaration method returns the correct Declaration object.
    @Test
    void testRetrieve(){

        //This should just work without needing to do anything anywhere else in the codebase
        decl1.save();

        //assert that the declaration can be retrieved correctly
        assertTrue(decl1 == Declaration.retrieveDeclaration(decl1.declarationID));

        //this might be redundant given the above assertion. to be refactored
        assertTrue((decl1.retrieveDeclaration(decl1.declarationID)) instanceof Declaration);
    }
    
    //Checks the validate function with valid formatting.
    @Test
    void test_validate_1(){

        //later on validate may not be public, but it's easier to test like this
        assertTrue(decl1.validate());

        var decl2 = new Declaration();

        //empty declaration should not validate
        assertFalse(decl2.validate());
        
    }


    @Test
    void test_save_1(){
        //Checks the save function with a proper declaration
        assertTrue(decl1.save());

        //Checks the save function with an  improper declaration
        assertTrue(decl2.save());
    }
}
