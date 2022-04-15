package com.br.schoolreyfow.note.model;

import com.br.schoolreyfow.matter.model.Matter;
import com.br.schoolreyfow.student.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal firstNote = BigDecimal.ZERO;
    private BigDecimal secondNote = BigDecimal.ZERO;
    private BigDecimal threeNote = BigDecimal.ZERO;
    private BigDecimal average = BigDecimal.ZERO;
    @ManyToOne()
    private Matter matter;
    @ManyToOne
    private Student student;

    @PreUpdate
    public void preUpdate() {
        var sumNotes = firstNote.add(secondNote.add(threeNote));
        var divisor = new BigDecimal("3.00");
        var divide = sumNotes.divide(divisor, RoundingMode.HALF_UP);
        this.average = divide;
    }

}