import static org.junit.Assert.*;
import org.junit.Test;

public class ContactServiceTest {
	int count = 0;

	// These tests should all pass.
    @Test
    public void testCreatePass() {
	    ContactService contactService = new ContactService();
	    Contact contact1 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	    Contact contact2 = new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street");
	    Contact contact3 = new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street");
	    assertEquals(true, contactService.create(contact1));
	    assertEquals(true, contactService.create(contact2));
	    assertEquals(true, contactService.create(contact3));
    }

    // These tests should fail in multiple ways.
    @Test
    public void testCreateFail() {
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

    // This should delete every contact.
    @Test
    public void testDeletePass() {
	    ContactService contactService = new ContactService();
	    Contact contact7 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	    Contact contact8 = new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street");
	    Contact contact9 = new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street");
	    assertEquals(true, contactService.create(contact7));
	    assertEquals(true, contactService.create(contact8));
	    assertEquals(true, contactService.create(contact9));
	
	    assertEquals(true, contactService.delete(contact7.getId()));
	    assertEquals(true, contactService.delete(contact8.getId()));
	    assertEquals(true, contactService.delete(contact9.getId()));
    }

    // These should fail and report cannot find the contact.
    @Test
    public void testDeleteFail() {
	    ContactService contactService = new ContactService();
	    Contact contact1 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	    Contact contact2 = new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street");
	    Contact contact3 = new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street");
	    assertEquals(true, contactService.create(contact1));
	    assertEquals(true, contactService.create(contact2));
	    assertEquals(true, contactService.create(contact3));
	
	    assertEquals(false, contactService.delete("Bobby"));
	    assertEquals(false, contactService.delete("Cruella"));
    }

    // These should update the contact correctly.
    @Test
    public void testUpdatePass() {
	    ContactService contactService = new ContactService();
	    Contact contact4 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	    Contact contact5 = new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street");
	    Contact contact6 = new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street");
	    assertEquals(true, contactService.create(contact4));
	    assertEquals(true, contactService.create(contact5));
	    assertEquals(true, contactService.create(contact6));

	    assertEquals(true, contactService.update(contact5.getId(), "Warren", "Smitherns", "5556667777", "1295 Anywhere Street"));
	    assertEquals(true, contactService.update(contact6.getId(), "Jacob", "Walsh", "5556667778", "1279 Anywhere Street"));
    }

    // These tests should fail in the update request.
    @Test
    public void testUpdateFail() {
	    ContactService contactService = new ContactService();
	    Contact contact1 = new Contact("John", "Smith", "5555555555", "123 Anywhere Street");
	    Contact contact2 = new Contact("Wayne", "Smith", "5555555565", "125 Anywhere Street");
	    Contact contact3 = new Contact("Justin", "Smith", "5555555575", "127 Anywhere Street");
	    assertEquals(true, contactService.create(contact1));
	    assertEquals(true, contactService.create(contact2));
	    assertEquals(true, contactService.create(contact3));
	
	    assertEquals(false, contactService.update(contact1.getId(), "Johnny", "Smith", "", ""));
	    assertEquals(false, contactService.update(contact2.getId(), "Wanda", "Rawls", "", "129 Anywhere Street"));
    }

}