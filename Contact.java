/*
 * @title: Contact.java 
 * @auth:  Brian Kittrell
 * @date:  9-18-2022
 * @desc:  Create a type object containing contact information.
 * 
 * Requirements:
 * The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updateable.
 * The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
 * The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
 * The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
 * The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
 */

public class Contact {
    private String id, firstName, lastName, phone, address;
    private static int idLength = 10, nameLength = 10, phoneLength = 10, addressLength = 30; // Input length rules. ID included only for system expansion, if needed.
    // Error messages
    private String 
        nameError = "There was a problem with the name entry.",
        phoneError = "There was a problem with the phone entry.",
        addressError = "There was a problem with the address entry.";

    public Contact(String inputFirstName, String inputLastName, String inputPhone, String inputAddress) {
        // Constructor
        // Validate the input first, and then assign.
        if (validate(inputFirstName, "name") 
         && validate(inputLastName, "name")
         && validate(inputPhone, "phone")
         && validate(inputAddress, "address")) {
            this.id = setId(idLength);
            this.firstName = inputFirstName;
            this.lastName = inputLastName;
            this.phone = inputPhone;
            this.address = inputAddress;
            }
        else {
        	throw new IllegalArgumentException("One or more values does not validate.");
        }
    } 

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public boolean setFirstName(String input) {
    	boolean result = false;
        if (validate(input, "name")) { 
            this.firstName = input; 
            result = true;
        } else {
            System.out.println(nameError);
            result = false;
        }
        return result;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean setLastName(String input) {
    	boolean result = false;
        if (validate(input, "name")) { 
            this.lastName = input; 
            result = true;
        } else {
            System.out.println(nameError);
            result = false;
        }
        return result;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean setPhone(String input) {
    	boolean result = false;
        if (validate(input, "phone")) { 
            this.phone = input; 
            result = true;
        } else {
        	System.out.println(phoneError);
        	result = false;
        }
        return result;
    }

    public String getAddress() {
        return this.address;
    }

    public boolean setAddress(String input) {
    	boolean result = false;
        if (validate(input, "address")) { 
            this.address = input; 
            result = true;
        } else {
            System.out.println(addressError);
            result = false;
        }
        return result;
    }

    public static boolean validate(String input, String type) {
        // private byte nameLength = 10, phoneLength = 10, addressLength = 30; // Input length rules
    	boolean result = false;
        if (type == "name" && input.length() > 0) {
            if (input.length() > nameLength || input == null || input == "") {
                System.out.println("Name length cannot be greater than 10 or empty on name: " + input);
                result = false;
            } else {
            	result = true;
            }
        } 
        if (type == "phone" && input.length() > 0) {
            if (input.length() != phoneLength || input == null || input == "") {
                System.out.println("Length must be exactly 10 and not empty.");
                result = false;
            } else if (!input.matches("[0-9]+")) {
                System.out.println("Phone input must be numbers only.");
                result = false;
            } else {
            	result = true;
            }
        } 
        if (type == "address" && input.length() > 0) {
            if (input.length() > addressLength || input == null || input == "") {
                System.out.println("Address length cannot be greater than 30 or empty.");
                result = false;
            } else {
            	result = true;
            }
        } 
        return result;
    }
    
    // For now, generate a random alphanumeric ID string for a new contact. For purposes of this assignment, the internal random generators will be sufficient.
	// Using a Nano ID generator, for a 1% chance of ID collision with an existing contact, we would need to generate 1000 IDs per hour for about 15 years.
	// Source: https://alex7kom.github.io/nano-nanoid-cc/?alphabet=0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz&size=10&speed=1000&speedUnit=hour
	// We should be at least half as good with a random number generator without using the Nano ID library, so I will do that here.
    
    private static String setId(int idLength) {
    	String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    			 + "0123456789"
    			 + "abcdefghijklmnopqrstuvxyz";
     
    	StringBuilder generatedId = new StringBuilder(idLength);
     
    	for (int i = 0; i < idLength; i++) {
    		int index = (int)(alphaNumericString.length() * Math.random());
    		generatedId.append(alphaNumericString.charAt(index));
    	}
    	return generatedId.toString();
    }
}