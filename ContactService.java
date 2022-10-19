import java.util.ArrayList;

public class ContactService {
    
    private ArrayList<Contact> book;

    public ContactService() {
        // Constructor
        book = new ArrayList<>();
    }
    
    public boolean create(Contact contactToAdd) {
        boolean match = false, result = false;
        	// Search array for matches
	        for (Contact item : book) {
	            if (item.equals(contactToAdd)) {
	            match = true;
	            }
	        }
	        // If match is not found, add new contact. Else report that it already exists.
	        if (!match) {
        		book.add(contactToAdd);
	            System.out.println("Added new contact.");
	            result = true;
        } 
	return result;
    }


    public boolean create(String contactId, String firstName, String lastName, String phone, String address) {
        boolean match = false, result = false;
        if (Contact.validate(firstName, "name") &&
    		Contact.validate(lastName, "name") &&
    		Contact.validate(phone, "phone") &&
    		Contact.validate(address, "address")) {
		        
        		Contact contactToAdd = new Contact(firstName, lastName, phone, address);
        		// Search array for matches
		        for (Contact item : book) {
		            if (item.equals(contactToAdd)) {
		            match = true;
		            }
		        }
		        // If match is not found, add new contact. Else report that it already exists.
		        if (!match) {
	        		book.add(contactToAdd);
		            System.out.println("Added new contact.");
		            result = true;
	        	}
	        } else {
	            System.out.println("Contact invalid.");
	            result = false;
	        }
        return result;
    }

    public boolean delete(String contactId) {

        for (Contact item : book) {
            if (item.getId() == contactId) {
                book.remove(item);
                System.out.println("Deleted contacted.");
                return true;
            }
        }
        return false;
    }

    public boolean update(String contactId, String firstName, String lastName, String phone, String address) {
        // Find the contact in the array
    	boolean result = false;
        for (Contact item : book) {
            if (item.getId() == contactId) {
            	if (Contact.validate(firstName, "name") &&
            		Contact.validate(lastName, "name") &&
            		Contact.validate(phone, "phone") &&
            		Contact.validate(address, "address")) {
		                item.setFirstName(firstName); 
		                item.setLastName(lastName);
		                item.setPhone(phone); 
		                item.setAddress(address);
		                System.out.println("Operation complete on " + item.getId() + ", " + firstName + ", " + lastName + ", " + phone + ", " + address);
		                System.out.println("Result: " + item.setFirstName(firstName) + ", " + item.setLastName(lastName) + ", " + item.setPhone(phone) + ", " + item.setAddress(address));
		            	System.out.println(item.getId() + " = " + contactId);
		                result = true;
            	}
            } 
		}
        return result;
    }
}