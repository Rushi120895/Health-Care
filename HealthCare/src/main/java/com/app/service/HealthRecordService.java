package com.app.service;

import com.app.dto.HealthRecordDTO;

public interface HealthRecordService {

	HealthRecordDTO createHealthRecord(HealthRecordDTO healthRecordDTO);

	HealthRecordDTO getHealthRecordById(Long id);

}
