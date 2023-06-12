package com.app.service;

import java.util.List;

import com.app.dto.HealthcareProviderDTO;

public interface HealthcareProviderService {

	List<HealthcareProviderDTO> getAllProviders();

	HealthcareProviderDTO getProviderById(Long id);

}
