package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.HealthRecordRepository;
import com.app.dto.HealthRecordDTO;
import com.app.pojos.HealthRecord;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

	@Autowired
	private final HealthRecordRepository healthRecordRepository;

	public HealthRecordServiceImpl(HealthRecordRepository healthRecordRepository) {
		this.healthRecordRepository = healthRecordRepository;
	}

	@Override
	public HealthRecordDTO createHealthRecord(HealthRecordDTO healthRecordDTO) {

		HealthRecord healthRecord = convertToEntity(healthRecordDTO);

		HealthRecord savedRecord = healthRecordRepository.save(healthRecord);

		return convertToDTO(savedRecord);
	}

	@Override
	public HealthRecordDTO getHealthRecordById(Long id) {

		HealthRecord healthRecord = healthRecordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Health Record not found with id: " + id));

		return convertToDTO(healthRecord);
	}

	private HealthRecord convertToEntity(HealthRecordDTO healthRecordDTO) {
		HealthRecord healthRecord = new HealthRecord();

		healthRecord.setRecordType(healthRecordDTO.getRecordType());
		healthRecord.setRecordData(healthRecordDTO.getRecordData());

		return healthRecord;
	}

	private HealthRecordDTO convertToDTO(HealthRecord healthRecord) {
		HealthRecordDTO healthRecordDTO = new HealthRecordDTO();

		healthRecordDTO.setRecordType(healthRecord.getRecordType());
		healthRecordDTO.setRecordData(healthRecord.getRecordData());

		return healthRecordDTO;
	}
}
