import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {
	
	/* Less testing performed here because far more testing is performed in ContactServiceTest
	 * which calls all of the getter and setter methods. But we will test the constructor and getters
	 * here at the minimum.
	 */

	// Test constructor with valid information.
    @Test
    public void testConstructorPass() {
	    assertNotNull(new Contact("John", "Smith", "5555555555", "123 Anywhere Street"));
	    assertNotNull(new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street"));
	    assertNotNull(new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street"));
    }

    // These tests should fail in multiple ways and throw an exception in the constructor.
    @Test
    public void testConstructorFail() {
        String expectedMessage = "One or more values does not validate.";
    	
    	Exception exception = assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("John Mark Paul", "Smith Watson Finch", "5555555555A", "123 Anywhere Street in Saint Paul Minnesota Behind the Barn to the Left.");
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        
    	exception = assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("Wayne Terrence John", "Smith Jones Dupree", "B5555555565", "125 Anywhere Street where the rivers flow and converge into one, giant river.");
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    	exception = assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("Justin", "Smith Carrol Mays", "T5555555575", "127 Anywhere Street, the most happening spot on the planet earth this side of the Mississippi.");
        });
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test public getter methods in Contact
    @Test
    public void testPublicPass() {
	    Contact contact1 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	
	    assertNotNull(contact1.getId());
	    assertNotNull(contact1.getFirstName());
	    assertNotNull(contact1.getLastName());
	    assertNotNull(contact1.getPhone());
	    assertNotNull(contact1.getAddress());
    }
}