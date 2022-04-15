package com.br.schoolreyfow.course.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDTO implements Serializable {
    private String id;
    private String name;
    private Integer quantityStudents;
}
