package com.br.schoolreyfow.student;

import com.br.schoolreyfow.course.Course;
import com.br.schoolreyfow.note.model.Note;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Long phone;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Course course;

    @OneToMany(mappedBy = "student")
    private List<Note> notes;

    @PrePersist
    private void prePersist() {
        if (!this.active) {
            this.active = true;
        }
    }

}