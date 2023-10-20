import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/*
 * This is the tester class for the Declaration busines object. 
 */
public class DeclarationTest { 

    @Test
    void test_constructor_1(){
        Declaration decl = new Declaration();
        assertNull(decl);
    }

    @Test
    void test_constructor_2(){
        Declaration decl = new Declaration("10/19/2023", "John", "john@gmail.com", 4, 3, "Smith", 195, false, 1);
        assertNull(decl);
    }
    
    //Checks that the Declaration constructor is correctly initializing variables.
    @Test
    void test_constructor_3(){
        Declaration decl = new Declaration("10/20/2023", "Anna", "anna@gmail.com", 2, 1, "Charlie", 134, true, 1);
        assertEquals("10/20/2023", decl.date);
        assertEquals("Anna", decl.name);
        assertEquals("anna@gmail.com", decl.email);
        assertEquals(2, decl.durationOfSupport);
        assertEquals(1, decl.applicantNumber);
        assertEquals("Charlie", decl.immigrantName);
        assertEquals(134, decl.alienNumber);
        assertEquals(true, decl.isExpired);
        assertEquals(1, decl.declarationID);
    }
    
    //Checks that the Declaration constructor correctly creates an instance of the Declaration class.
    @Test
    void test_constructor_4(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        assertTrue(decl instanceof Declaration);
    }

    //Checks that the retrieveDeclaration method returns the correct Declaration object.
    @Test
    void test_retrieve_1(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        decl.save();
        Declaration decl2 = new Declaration();
        assertTrue(decl2.retrieveDeclaration(2));
    }   
    
    //Checks that the retrieveDeclaration method correctly returns a Declaration object.
    @Test
    void test_retrieve_2(){
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
}
