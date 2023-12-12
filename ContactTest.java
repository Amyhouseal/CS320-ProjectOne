/*************************
 * Name: Amy Houseal
 * Date: 11/10/23
 * Course: CS320
 * Description: This is the unit tests for the contact class (ContactTest).
 *************************/
//package test;

import static org.junit.jupiter.api.Assertions.*;


import Appointment.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;


class ContactTest {
    protected String   testFirstName,  testLastName,  testPhoneNum,  testAddress;
    protected String   noFirstName,  longFirstName,  noLastName, longLastName,
            noPhoneNum,  shortPhoneNum,  longPhoneNum,  invalidPhoneNum,  noAddress,  longAddress, tenFName, tenLName;

    @BeforeEach
    void setUp() {
        testFirstName = "Daniel";
        testLastName = "Ricciardo";
        testPhoneNum = "1231234567";
        testAddress = "123 Cota Ln";
        noFirstName = null;
        longFirstName = "DanielValterriMax";
        noLastName = null;
        longLastName = "RicciardoBottasVerstappen";
        noPhoneNum = null;
        shortPhoneNum = "1234";
        longPhoneNum = "12312345677";
        invalidPhoneNum = "123-123-123";
        noAddress = null;
        longAddress = "This address is longer than thirty characters, this address should fail the test";
        tenFName = "QWERTYUIOP";
        tenLName = "asdfghjklp";
    }


    @Test
    @DisplayName("Class creation Test")
    void testContact() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getFirstName().equals(testFirstName));
        assertTrue(contact.getLastName().equals(testLastName));
        assertTrue(contact.getPhoneNum().equals(testPhoneNum));
        assertTrue(contact.getAddress().equals(testAddress));
        System.out.println(contact.getContactId());
    }


    @Test
    @DisplayName("Contact ID Cannot be greater than 10 characters")
    void testContactId() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertFalse(contact.getContactId().length() > 10);
    }

    @Test
    @DisplayName("Contact ID less than or equal to 10 characters")
    void testContactIdLessThanTen() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getContactId().length() <= 10);
    }

    @Test
    @DisplayName("Contact ID equal to 10 characters")
    void testContactIdEqualTen() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getContactId().length() == 10);
    }





    @Test
    @DisplayName("Contact ID cannot be null.")
    void nullId() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        System.out.println(contact.getContactId());
        if(contact.getContactId() == null) {
            fail("Contact ID is null");
        }

    }


//Contact ID cannot be updated, the contactId variable in the class is set to private final and has no setter method therefore cannot be updated

    @Test
    @DisplayName("Contact ID must be unique.")
    void uniqueId() {
        Contact contact1 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        Contact contact2 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        Contact contact3 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);

        String id1 = contact1.getContactId();
        String id2 = contact2.getContactId();
        String id3 = contact3.getContactId();

        System.out.println("1: " + id1 + " 2: " + id2 + " 3: " + id3);

        assertNotEquals(id1, id2, "IDs not unique.");
        assertNotEquals(id2, id3, "IDs not unique.");
        assertNotEquals(id1, id3, "IDs not unique.");
    }



    @Test
    @DisplayName("First name not null")
    void nullFirstNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(noFirstName,testLastName,testPhoneNum,testAddress);});

    }


    @Test
    @DisplayName("First name not greater than 10 characters")
    void firstNameTooLong() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertFalse(contact.getFirstName().length() > 10);
    }

    @Test
    @DisplayName("First name less than equal to 10 characters")
    void firstNameLessThanTen() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getFirstName().length() <= 10);
    }

    @Test
    @DisplayName("First name equal to 10 characters")
    void firstNameEqualToTen() {
        Contact contact = new Contact(tenFName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getFirstName().length() == 10);
    }





    @Test
    @DisplayName("Last name not null")
    void nullLastNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,noLastName,testPhoneNum,testAddress);});

    }


    @Test
    @DisplayName("Last name not greater than 10 characters")
    void lastNameTooLong() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertFalse(contact.getLastName().length() > 10);
    }

    @Test
    @DisplayName("Last name less than equal to 10 characters")
    void lastNameLessThanTen() {
        Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
        assertTrue(contact.getLastName().length() <= 10);
    }

    @Test
    @DisplayName("Last name equal to 10 characters")
    void lastNameEqualToTen() {
        Contact contact = new Contact(testFirstName,tenLName,testPhoneNum,testAddress);
        assertTrue(contact.getLastName().length() == 10);
    }


    @Test
    @DisplayName("Phone number not null")
    void nullPhoneTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,noPhoneNum,testAddress);});

    }

    @Test
    @DisplayName("Phone number not greater than 10 characters")
    void phoneTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,longPhoneNum,testAddress);});

    }

    @Test
    @DisplayName("Phone number not less than 10 characters")
    void phoneNotLongEnough() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,shortPhoneNum,testAddress);});

    }

    @Test
    @DisplayName("Phone number must only be digits")
    void phoneIllegalCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,invalidPhoneNum,testAddress);});

    }


    @Test
    @DisplayName("Address not null")
    void nullAddressTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,testPhoneNum,noAddress);});

    }


    @Test
    @DisplayName("Address not greater than 30 characters")
    void addressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {new Contact(testFirstName,testLastName,testPhoneNum,longAddress);});

    }

    @Test
    @DisplayName("Address is less than 30 characters.")
    void validAddress() {
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
            Assertions.assertEquals(testAddress,contact.getAddress());
            Assertions.assertTrue(contact.getAddress().length()<30);
        });
    }


    @Test
    @DisplayName("Address equal to 30 characters.")
    void thirtyLengthAddress() {
        String thirtyLengthAddress = "qwertyuiopasdfghjklzxcvbnmqwef";
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,thirtyLengthAddress);
            Assertions.assertEquals(thirtyLengthAddress,contact.getAddress());
            Assertions.assertEquals(30,contact.getAddress().length());
        });
    }

}