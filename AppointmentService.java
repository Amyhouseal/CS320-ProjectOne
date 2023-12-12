package Appointment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    //Create Map for Appointments
    public Map<String, Appointment> appointmentMap = new HashMap<String, Appointment>();

    public void addAppointment(LocalDate appointmentDate, String appointmentDesc) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
        duplicateIdCheck(appointment.getAppointmentId(), appointment);
    }

    public void displayAppointments() {
        for( String i : appointmentMap.keySet()) {
            System.out.println("Appointment Id: " + appointmentMap.get(i).getAppointmentId());
            System.out.println("Appointment Date: " + appointmentMap.get(i).getAppointmentDate());
            System.out.println("Appointment Desc: " + appointmentMap.get(i).getAppointmentDesc());
        }
    }

    public void deleteAppointment(String appointmentId) {
        if(appointmentMap.containsKey(appointmentId)) {
            appointmentMap.remove(appointmentId);
            System.out.println("Appointment deleted.");
        }else {
            System.out.println("Appointment ID: " +appointmentId + " cannot be found");
        }
    }

    public Map<String,Appointment> getAppointmentMap(){
        return appointmentMap;
    }

    public void duplicateIdCheck(String instanceId, Appointment object) {

        if(appointmentMap.containsKey(instanceId)) {
            System.out.println("Appointment ID already exists.");
            return;
        }
        else {
            appointmentMap.put(instanceId, object);
        }
    }

}