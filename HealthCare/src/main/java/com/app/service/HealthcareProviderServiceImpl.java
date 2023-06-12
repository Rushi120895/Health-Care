package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.HealthcareProviderRepository;
import com.app.dto.HealthcareProviderDTO;
import com.app.pojos.HealthcareProvider;

@Service
public class HealthcareProviderServiceImpl implements HealthcareProviderService {

	@Autowired
	private final HealthcareProviderRepository providerRepository;

	public HealthcareProviderServiceImpl(HealthcareProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@Override
	public List<HealthcareProviderDTO> getAllProviders() {

		List<HealthcareProvider> providers = providerRepository.findAll();

		return convertToDTOList(providers);
	}

	@Override
	public HealthcareProviderDTO getProviderById(Long id) {

		HealthcareProvider provider = providerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Healthcare Provider not found with id: " + id));

		return convertToDTO(provider);
	}

	private HealthcareProvider convertToEntity(HealthcareProviderDTO providerDTO) {
		HealthcareProvider healthcareProvider = new HealthcareProvider();
		healthcareProvider.setName(providerDTO.getName());
		healthcareProvider.setSpecialization(providerDTO.getSpecialization());
		healthcareProvider.setAddress(providerDTO.getAddress());
		healthcareProvider.setContactNumber(providerDTO.getContactNumber());
		healthcareProvider.setEmail(providerDTO.getEmail());

		return healthcareProvider;
	}

	private HealthcareProviderDTO convertToDTO(HealthcareProvider provider) {
		HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
		providerDTO.setId(provider.getId());
		providerDTO.setName(provider.getName());
		providerDTO.setSpecialization(provider.getSpecialization());
		providerDTO.setAddress(provider.getAddress());
		providerDTO.setContactNumber(provider.getContactNumber());
		providerDTO.setEmail(provider.getEmail());

		return providerDTO;
	}

	private List<HealthcareProviderDTO> convertToDTOList(List<HealthcareProvider> providers) {
		List<HealthcareProviderDTO> providerDTOList = new ArrayList<>();
		for (HealthcareProvider provider : providers) {
			HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
			providerDTO.setId(provider.getId());
			providerDTO.setName(provider.getName());
			providerDTO.setSpecialization(provider.getSpecialization());
			providerDTO.setAddress(provider.getAddress());
			providerDTO.setContactNumber(provider.getContactNumber());
			providerDTO.setEmail(provider.getEmail());

			providerDTOList.add(providerDTO);
		}
		return providerDTOList;
	}
}
