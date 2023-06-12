package com.app.pojos;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "healthcare_providers")
@NoArgsConstructor
@Getter
@Setter
public class HealthcareProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String address;
    private String contactNumber;
    private String email;
    
}