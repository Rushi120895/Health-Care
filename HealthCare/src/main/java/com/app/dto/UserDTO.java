package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String Name;
    private int age;
   // private LocalDate dateOfBirth;
    private String address;
    private String contactNumber;

}
