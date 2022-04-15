package com.br.schoolreyfow.course.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CourseMatterKey implements Serializable {

    @Column(name = "matters_id")
    private String mattersId;

    @Column(name = "courses_id")
    private String coursesId;
}
