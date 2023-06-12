package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AppointmentRepository;
import com.app.dto.AppointmentDTO;
import com.app.pojos.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private final AppointmentRepository appointmentRepository;

	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {

		Appointment appointment = convertToEntity(appointmentDTO);

		Appointment savedAppointment = appointmentRepository.save(appointment);

		return convertToDTO(savedAppointment);
	}

	@Override
	public AppointmentDTO getAppointmentById(Long id) {

		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));

		return convertToDTO(appointment);
	}

	private Appointment convertToEntity(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();

		appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
		appointment.setStatus(appointmentDTO.getStatus());

		return appointment;

	}

	private AppointmentDTO convertToDTO(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();

		appointmentDTO.setAppointmentDateTime(appointment.getAppointmentDateTime());
		appointmentDTO.setStatus(appointment.getStatus());

		return appointmentDTO;

	}

}
