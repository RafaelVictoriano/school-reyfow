package com.br.schoolreyfow.matter.model.dto;

import com.br.schoolreyfow.course.Course;
import com.br.schoolreyfow.course.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class MatterDTO implements Serializable {
    private final String name;
    private final String teacherId;
    private final Set<CourseDTO> courses;
}
