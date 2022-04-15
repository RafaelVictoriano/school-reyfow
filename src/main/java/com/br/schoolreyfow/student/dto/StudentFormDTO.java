package com.br.schoolreyfow.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentFormDTO {

    @NotNull @NotEmpty
    private String name;
    @Email(message = "Email is invalid")
    private String email;
    @NotNull
    @Min(10) @Max(18)
    private Integer age;
    @NotNull
    private Long phone;
    @NotNull
    private String courseId;
}

