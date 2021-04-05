package com.cg.cars.service;

import java.util.List;

import com.cg.cars.entities.Appointment;
import com.cg.cars.model.AppointmentDTO;

public interface IAppointmentService {

    public AppointmentDTO addAppointment(Appointment appointment);

    public AppointmentDTO removeAppointment(int id);
    
    public AppointmentDTO updateAppointment(int id, Appointment appointment);

    public AppointmentDTO getAppointment(int id);

    public List<AppointmentDTO> getAllAppointments();
    
    public List<AppointmentDTO> getOpenAppointments();
}
