package com.app.service;

import com.app.dto.AppointmentDTO;

public interface AppointmentService {

	AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

	AppointmentDTO getAppointmentById(Long id);

}
