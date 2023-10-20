import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class DeclarationTest { 

    @Test
    void test_1(){
        Declaration decl = new Declaration();
        assertNull(decl);
    }

    @Test
    void test_2(){
        Declaration decl = new Declaration("10/19/2023", "John", "john@gmail.com", 4, 3, "Smith", 195, false, 1);
        assertNull(decl);
    }
    
    @Test
    void test_3(){
        Declaration decl = new Declaration("10/20/2023", "Anna", "anna@gmail.com", 2, 1, "Charlie", 134, true, 1);
        assertEquals("10/20/2023", decl.);
        assertEquals("Anna", decl.name);
        assertEquals("anna@gmail.com", decl.email);
        assertEquals(2, decl.durationOfSupport);
        assertEquals(1, decl.applicantNumber);
        assertEquals("Charlie", decl.immigrantName);
        assertEquals(134, decl.alienNumber);
        assertEquals(true, decl.isExpired);
        assertEquals(1, decl.declarationID);
    }

    @Test
    void test_4(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        decl.save();
        Declaration decl2 = new Declaration();
        assertEquals(decl, decl2.retrieveDeclaration(2));
    }   
}
