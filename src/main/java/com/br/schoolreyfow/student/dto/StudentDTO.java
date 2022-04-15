package com.br.schoolreyfow.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class StudentDTO {
    private String name;
    private String email;
    private String courseName;
}
