/*************************
 * Name: Amy Houseal
 * Date: 11/10/23
 * Course: CS320
 * Description: This contact class creates & stores contact information,
 *************************/

package contact;

import java.util.concurrent.atomic.AtomicInteger;


public class Contact {
    //Length constants
    private final static int MAX_LENGTH = 10;
    private final static int MAX_ADDRESS = 30;
    private final static String REGEX = "[0-9]+";
    private static AtomicInteger createId = new AtomicInteger(1);
    //Contact variables
    private final String contactId; //Set the private final to prevent ID from being updated
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;




    //Constructor
    public Contact(String  firstName, String lastName, String phoneNum, String address)
    {
        this.contactId = "CT"+String.format("%08d", createId.getAndIncrement()); //Concatenates CT to the ID to note that the ID is a Contact ID

        //Calls dataValidator and phoneValidator methods
        dataValidator(this.contactId, MAX_LENGTH);

        dataValidator(firstName, MAX_LENGTH);

        dataValidator(lastName, MAX_LENGTH);

        phoneValidator(phoneNum);

        dataValidator(address, MAX_ADDRESS);



        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;


    }


    //Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }



    //Setters
    public void setFirstName(String firstName) {
        dataValidator(firstName, MAX_LENGTH);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        dataValidator(lastName, MAX_LENGTH);
        this.lastName = lastName;

    }

    public void setPhoneNum(String phoneNum) {

        phoneValidator(phoneNum);
        this.phoneNum = phoneNum;

    }
    public void setAddress(String address) {
        dataValidator(address, MAX_ADDRESS);
        this.address = address;

    }


    // Validates data, ensuring not null and adheres to character lengths
    private void dataValidator(String input, int charCriteria) {
        if(input == null){
            throw new IllegalArgumentException("Invalid. Data cannot be null.");
        }
        if(input.length()>charCriteria) {
            throw new IllegalArgumentException("Invalid. Data is " + input.length() +" characters and cannot exceed " + charCriteria + " characters.");
        }
    }


    //Validates phoneNum. Checks for null, length and digits
    private void phoneValidator(String phoneNum) {
        if(phoneNum == null) {
            throw new IllegalArgumentException("Invalid. Data cannot be null.");
        }

        if(phoneNum.length()!=MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid. Phone number must be exactly " + MAX_LENGTH + " digits.");
        }
        if(!phoneNum.matches(REGEX)) {
            throw new IllegalArgumentException("Invalid. Phone number must consist only of digits 0-9.");
        }
    }
}
