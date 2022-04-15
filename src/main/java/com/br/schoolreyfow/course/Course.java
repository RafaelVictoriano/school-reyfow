package com.br.schoolreyfow.course;

import com.br.schoolreyfow.matter.model.Matter;
import com.br.schoolreyfow.student.Student;
import com.br.schoolreyfow.teacher.Teacher;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "integer default 0")
    private Integer quantityStudents = 0;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private final Set<Student> students = new HashSet<>();

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<Matter> matters = new HashSet<>();

    public boolean addStudent() {
        return this.quantityStudents >= 40;
    }

}