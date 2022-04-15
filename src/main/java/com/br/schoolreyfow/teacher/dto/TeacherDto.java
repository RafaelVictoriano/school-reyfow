package com.br.schoolreyfow.teacher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter @Setter
public class TeacherDto implements Serializable {

    @NotNull @NotEmpty
    private final String name;
    @Email
    private final String email;
    @NotNull
    private final Long phone;
}
