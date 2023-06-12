package com.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.HealthcareProviderDTO;
import com.app.service.HealthcareProviderService;

@RestController
@RequestMapping("/providers")
public class HealthcareProviderController {

	@Autowired
    private final HealthcareProviderService providerService;

    public HealthcareProviderController(HealthcareProviderService providerService) {
        this.providerService = providerService;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/allproviders")
    public ResponseEntity<List<HealthcareProviderDTO>> getAllProviders() {
        List<HealthcareProviderDTO> providers = providerService.getAllProviders();
        return ResponseEntity.ok(providers);
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{id}")
    public ResponseEntity<HealthcareProviderDTO> getProviderById(@PathVariable Long id) {
        HealthcareProviderDTO provider = providerService.getProviderById(id);
        return ResponseEntity.ok(provider);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

}