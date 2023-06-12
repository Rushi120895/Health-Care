package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HealthRecordDTO;
import com.app.service.HealthRecordService;

@RestController
@RequestMapping("/records")
public class HealthRecordController {

	@Autowired
    private final HealthRecordService healthRecordService;

    public HealthRecordController(HealthRecordService healthRecordService) {
        this.healthRecordService = healthRecordService;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/create")
    public ResponseEntity<HealthRecordDTO> createHealthRecord(@RequestBody HealthRecordDTO healthRecordDTO) {
        HealthRecordDTO createdRecord = healthRecordService.createHealthRecord(healthRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{id}")
    public ResponseEntity<HealthRecordDTO> getHealthRecordById(@PathVariable Long id) {
        HealthRecordDTO healthRecord = healthRecordService.getHealthRecordById(id);
        return ResponseEntity.ok(healthRecord);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
  

}