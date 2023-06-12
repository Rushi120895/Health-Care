package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AppointmentDTO {

    private Long id;
    private Long userId;
    private Long providerId;
    private LocalDateTime appointmentDateTime;
    private String status;

}
