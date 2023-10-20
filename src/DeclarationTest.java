import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class DeclarationTest { 

    @Test
    void test_1(){
        Declaration decl = new Declaration("10/20/2023", "Anna", "anna@gmail.com", 2, 1, "Charlie", 134, true, 1);
        assertEquals("10/20/2023", decl.getDate());
        assertEquals("Anna", decl.getName());
        assertEquals("anna@gmail.com", decl.getEmail());
        assertEquals(2, decl.getDuration());
        assertEquals(1, decl.getApplicantNumber());
        assertEquals("Charlie", decl.getImmigrantName());
        assertEquals(134, decl.getAlienNumber());
        assertEquals(true, decl.getIsExpired());
        assertEquals(1, decl.getDeclarationID());
    }

    @Test
    void test_2(){
        Declaration decl = new Declaration("10/20/2023", "Hannah", "hannah@gmail.com", 3, 2, "Jackson", 221, false, 2);
        Declaration decl2 = new Declaration();
        assertEquals(decl, decl2.retrieveDeclaration(2));
    }   
}
