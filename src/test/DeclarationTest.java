package test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

//import Declaration;

import java.lang.reflect.*;
import java.lang.Integer;
import java.util.ArrayList;

/*
 * This is the tester class for the Declaration busines object. 
 */
public class DeclarationTest { 
    Declaration decl1;
    Declaration decl2;
    ArrayList<Object> fields;

    //Checks that the Declaration constructor is correctly initializing variables.
    @Test
    void testConstructor(){
        fields = new ArrayList<Object>();
        fields.add("10/20/2023"); fields.add("Charlie"); fields.add("anna@gmail.com");
        fields.add(134); fields.add(111); fields.add(134); fields.add(true); fields.add(1);

        decl1 = Declaration.create(fields);

        /* iterate through all the fields and make sure they've been correctly initialized.
         * the extra brace pair ensures index goes out of scope afterwards.
         * this is not safe code, since getFields does not guarantee ordering,
         * but most java btyecode compilers tends to play nice.
         * It should be ok for a minimum viable product, but ought to be refactored later.
         * The fix is to turn fields into a hashmap where the field names are the keys. Then
         * the order of getFields() can be ignored.
        */
        { int idx = 0; for (Field f : Declaration.class.getFields()) {
            try {
                assertEquals(fields.get(idx), f.get(decl1));
            } catch(Exception e) {
                System.err.println(e);
                System.err.println("this should never run unless the test itself has an error.");
                System.exit(idx);
            }
            idx++;
        }}
    }

    //Checks the validate function with valid formatting.
    @Test
    void testValidate(){

        //later on validate may not be public, but it's easier to test like this
        assertTrue(decl1.validate());

        decl2 = Declaration.create();

        //empty declaration should not validate
        assertFalse(decl2.validate());

        decl2.applicantNumber = 1121;
        decl2.declarationID = 44121;
        decl2.name = "Andrei Astapienia";
        

        //incomplete declaration should not validate
        { int idx = 0; for (Field f : Declaration.class.getFields()) {

            if (idx >= 8) { break; }

            try {
            f.set(decl2, fields.get(idx));

            assertFalse(decl2.validate());

            } catch(Exception e) {
                System.err.println(e);
                System.exit(idx);
            }
            idx++;
        }}

        //once completed, should validate
        decl2.declarationID = 11211;
        assertTrue(decl2.validate());

        //checking that negative entries don't validate
        { int idx = 0; for (Field f : Declaration.class.getFields()) {
            try {
            if(f.getType() == Integer.class) {
                int number = (Integer) fields.get(idx);
                f.set(decl2, -number);

                //negative entries should not validate
                assertFalse(decl2.validate());

                //should validate after entry has been fixed
                f.set(decl2, number);
                assertTrue(decl2.validate());
            }
            } catch(Exception e) {
                System.err.println(e);
                System.exit(idx);
            }
            idx++;
        }}
    }


    //checks that the save function saves on a declaration that validates only
    @Test
    void testSaveAndRetrieve(){
        //Checks that the save function works with a proper declaration
        assertTrue(decl1.save());

        //assert that the declaration can be retrieved correctly
        assertTrue(decl1 == Declaration.retrieveDeclaration(decl1.declarationID));

        decl2.date = null;

        //declaration that does not validate should not save
        assertFalse(decl2.save());
        assertTrue(null == Declaration.retrieveDeclaration(decl2.applicantNumber));
    }
}
