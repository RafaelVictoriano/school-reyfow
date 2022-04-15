package com.br.schoolreyfow.matter.model;

import com.br.schoolreyfow.course.Course;
import com.br.schoolreyfow.note.model.Note;
import com.br.schoolreyfow.teacher.Teacher;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Matter {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private Set<Course> courses;

    @OneToMany(mappedBy = "matter")
    private Set<Note> note;

}
