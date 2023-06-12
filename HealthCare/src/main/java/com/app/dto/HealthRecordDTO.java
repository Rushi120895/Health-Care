package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HealthRecordDTO {

    private Long id;
    private Long userId;
    private String recordType;
    private String recordData;

}
