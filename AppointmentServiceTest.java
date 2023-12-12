//package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;



class AppointmentServiceTest {
    protected LocalDate testDate, pastDate, noDate;
    protected String testDesc, longDesc, noDesc, idMissMatch;
    @BeforeEach
    void setUp() {
        testDate = LocalDate.of(2023, 12, 12);
        pastDate = LocalDate.of(2020,1,1);
        noDate = null;
        testDesc = "Pass description";
        longDesc = "This description is way too long to be a description and should fail the test.";
        noDesc = null;
        idMissMatch = "1";
    }



    @Test
    @DisplayName("Create an appointment test")
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(testDate, testDesc);
        service.displayAppointments();
        assertNotNull(service.getAppointmentMap());
    }


    @Test
    @DisplayName("Create multiple appointments with no collisions test")
    void multipleAppointments() {
        AppointmentService service  = new AppointmentService();

        for(int i = 0; i < 10; i++) {
            service.addAppointment(testDate, testDesc);
        }
        System.out.println(service.getAppointmentMap().size() + " appointments created.");
        if(service.getAppointmentMap().size() < 10) {
            fail ("Duplicate IDs - Cannot create additional appointments");
        }
    }


    @Test
    @DisplayName("Duplicate IDs should not save to appointmentMap test")
    void duplicateId() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(testDate,testDesc);
        service.duplicateIdCheck(appointment.getAppointmentId(), appointment);
        service.displayAppointments();
        Appointment appointment2 = new Appointment(testDate,testDesc);
        service.duplicateIdCheck(appointment.getAppointmentId(), appointment2);
        service.displayAppointments();
        assertTrue(service.getAppointmentMap().size() == 1);
    }


    @Test
    @DisplayName("Delete appointment test")
    void deleteAppointmentTest() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(testDate, testDesc);
        service.displayAppointments();
        for(String i: service.getAppointmentMap().keySet()) {
            service.deleteAppointment(service.appointmentMap.get(i).getAppointmentId());
        }
        assertTrue(service.getAppointmentMap().isEmpty());
    }


    @Test
    @DisplayName("Test ID cannot be found")
    void idNotFoundTest() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(testDate, testDesc);
        service.displayAppointments();
        service.deleteAppointment(idMissMatch);
    }

}
