//package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;


class AppointmentTest {

    protected LocalDate testDate, pastDate, noDate;
    protected String testDesc, longDesc, noDesc;

    @BeforeEach
    void setUp() {
        testDate = LocalDate.of(2023, 12, 11);
        pastDate = LocalDate.of(2020, 1, 1);
        noDate = null;
        testDesc = "Pass description";
        longDesc = "This description is way too long to be a description and should fail the test.";
        noDesc = null;

    }


    @Test
    @DisplayName("Appointment Class Creation Test")
    void appointmentTest() {
        Appointment appointment = new Appointment(testDate, testDesc);
        assertTrue(appointment.getAppointmentDate().equals(testDate));
        assertTrue(appointment.getAppointmentDesc().equals(testDesc));
        System.out.println(appointment.getAppointmentId() + ": " + appointment.getAppointmentDate() + " | " + appointment.getAppointmentDesc());

    }


    @Test
    @DisplayName("Appointment ID Length greater than 10")
    void appointmentIdLength() {
        Appointment appointment = new Appointment(testDate, testDesc);
        assertFalse(appointment.getAppointmentId().length()>10);
    }

    @Test
    @DisplayName("Appointment ID Length less than or equal to 10")
    void appointmentIdLengthLessThanTen() {
        Appointment appointment = new Appointment(testDate, testDesc);
        assertTrue(appointment.getAppointmentId().length()<=10);
        }

    @Test
    @DisplayName("Appointment ID Length equals 10")
    void appointmentIdLengthEqualsTen() {
        Appointment appointment = new Appointment(testDate, testDesc);
        assertTrue(appointment.getAppointmentId().length() == 10);
    }






    @Test
    @DisplayName("Appointment ID is not null")
    void appointmentNullId() {
        Appointment appointment = new Appointment(testDate, testDesc);
        System.out.println(appointment.getAppointmentId());
        if (appointment.getAppointmentId() == null) {
            fail("ID is null");
        }
    }



    //Confirms Unique ID
    @Test
    @DisplayName("Task ID must be unique")
    void uniqueTaskId() {
        Appointment appt1 = new Appointment(testDate, testDesc);
        Appointment appt2 = new Appointment(testDate, testDesc);
        Appointment appt3 = new Appointment(testDate, testDesc);

        String id1 = appt1.getAppointmentId();
        String id2 = appt2.getAppointmentId();
        String id3 = appt3.getAppointmentId();

        System.out.println("1: " + id1 + " 2: " + id2 + " 3: " + id3);

        assertNotEquals(id1, id2, "IDs not unique");
        assertNotEquals(id2, id3, "IDs not unique");
        assertNotEquals(id1, id3, "IDs not unique");
    }


    @Test
    @DisplayName("Date must not be null")
    void nullDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new Appointment(noDate, testDesc);
        });
    }


    @Test
    @DisplayName("Date must not be in the past")
    void pastDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new Appointment(pastDate, testDesc);
        });
    }


    @Test
    @DisplayName("Description must not be null")
    void nullDesc() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new Appointment(testDate, noDesc);
        });
    }

    @Test
    @DisplayName("Description must not be greater than 50 characters.")
    void longDesc() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new Appointment(testDate, longDesc);
        });
    }


    @Test
    @DisplayName("Description is less than 50 characters.")
    void validDesc() {
        Assertions.assertDoesNotThrow(() -> {
            Appointment appointment = new Appointment(testDate,testDesc);
            Assertions.assertEquals(testDesc,appointment.getAppointmentDesc());
            Assertions.assertTrue(appointment.getAppointmentDesc().length()<50);
        });
    }


    @Test
    @DisplayName("Description equal to 50 characters.")
    void fiftyLengthDesc() {
        String fiftyLengthDesc = "fsdufhdskljhfkjdslhfsjkdfhdsfdsgfffhgdshfddfggfssd";
        Assertions.assertDoesNotThrow(() -> {
            Appointment appointment = new Appointment(testDate,fiftyLengthDesc);
            Assertions.assertEquals(fiftyLengthDesc,appointment.getAppointmentDesc());
            Assertions.assertEquals(50,appointment.getAppointmentDesc().length());
        });
    }

}




