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
    //Then checks that the
    @Test
    void testConstructor(){
        var fields = new ArrayList<Object>();
        fields.add("10/20/2023"); fields.add("anna@gmail.com"); fields.add(2); fields.add(1);
        fields.add("Charlie"); fields.add(134); fields.add(true); fields.add(1);

        decl1 = new Declaration(fields);

        //iterate through all the fields and make sure they've been correctly initialized.
        //the extra brace pair ensures idx goes out of scope afterwards
        {
        int idx = 0; for (Field f : Declaration.class.getFields()) {
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

        assertTrue(decl1 == Declaration.retrieveDeclaration(decl1.declarationID));
    }   
    
    //Checks that the retrieveDeclaration method correctly returns a Declaration object.
    @Test
    void testRetrieve2(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        decl.save();
        Declaration decl2 = new Declaration();
        assertTrue((decl2.retrieveDeclaration(2)) instanceof Declaration);
    }
    
    //Checks the validate function with valid formatting.
    @Test
    void test_validate_1(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        assertTrue(decl.validate());
    }
    
    //Checks the validate function with invalid formatting.
    @Test
    void test_validate_2(){
        Declaration decl = new Declaration("1/20/20", "B4RACK", "obama@gmail.com", 3, 2, "0bama", 221, false, 2);
        assertFalse(decl.validate());
    }

    //Checks the save function with a proper declaration
    @Test
    void test_save_1(){
        Declaration decl = new Declaration("06/12/23", "Bob", "bob@gmail.com", 2, 3, "Joe", 147, false, 3);
        assertTrue(decl.save());
    }

    //Checks the save function with a proper declaration
    @Test
    void test_save_2(){
        Declaration decl = new Declaration("05/04/22", "Mary", "mary@gmail.com", 1, 4, "Sue", 267, false, 4);
        assertTrue(decl.save());
    }
}
