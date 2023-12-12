/*************************
 * Name: Amy Houseal
 * Date: 11/10/23
 * Course: CS320
 * Description: ContactService.Java maintains the list of contacts. Adding, deleting and updating name, phone number & addresses can be done through this.
 *************************/

package contact;


import java.util.HashMap;
import java.util.Map;






public class ContactService {
    //Array stores contacts
    public Map<String,Contact> contactMap = new HashMap<String,Contact>();

    //Add contact to list
    public void addContact(String firstName, String lastName, String phoneNum, String address) {

        Contact contact = new Contact(firstName,lastName,phoneNum,address);
        //Retrieves contract ID from instance
        String id = contact.getContactId();
        //Checks dupe ID through contactList
        duplicateIdCheck(id, contact);

    }


    //List of contacts for testing
    public void displayContacts() {
        for (String i : contactMap.keySet()) {
            System.out.println("Contact Id: " + contactMap.get(i).getContactId());
            System.out.println("First Name: " + contactMap.get(i).getFirstName());
            System.out.println("Last Name: " + contactMap.get(i).getLastName());
            System.out.println("Phone: " + contactMap.get(i).getPhoneNum());
            System.out.println("Address: " + contactMap.get(i).getAddress());
        }
    }


    //Deletes contacts
    public void deleteContact (String contactId) {
        if(contactMap.containsKey(contactId)) {
            contactMap.remove(contactId);
        } else {
            System.out.println("Contact Id: " + contactId + " cannot be found.");
        }
    }


    //Updates first name
    public void updateFirstName (String updatedFirstName, String contactId) {
        if(contactMap.containsKey(contactId)) {
            contactMap.get(contactId).setFirstName(updatedFirstName);
        } else {
            System.out.println("Contact Id: " + contactId + " cannot be found.");
        }
    }


    //Updates last name
    public void updateLastName (String updatedLastName, String contactId) {
        if(contactMap.containsKey(contactId)) {
            contactMap.get(contactId).setLastName(updatedLastName);
        } else {
            System.out.println("Contact Id: " + contactId + " cannot be found.");
        }

    }

    //Updates phone number
    public void updateNumber (String updatedNumber, String contactId) {
        if(contactMap.containsKey(contactId)) {
            contactMap.get(contactId).setPhoneNum(updatedNumber);
        } else {
            System.out.println("Contact Id: " + contactId + " cannot be found.");
        }

    }

    //Update address
    public void updateAddress (String updatedAddress, String contactId) {
        if(contactMap.containsKey(contactId)) {
            contactMap.get(contactId).setAddress(updatedAddress);
        } else {
            System.out.println("Contact Id: " + contactId + " cannot be found.");
        }
    }



    //Return contactMap
    public Map<String, Contact> getContactMap(){
        return contactMap;
    }

    public void duplicateIdCheck(String instanceId, Contact object) {

        if(contactMap.containsKey(instanceId)) {
            System.out.println("Contact ID already exists.");
            return;
        }
        else {
            contactMap.put(instanceId, object);
        }
    }

}
