package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HealthcareProviderDTO {

    private Long id;
    private String name;
    private String specialization;
    private String address;
    private String contactNumber;
    private String email;
   

}