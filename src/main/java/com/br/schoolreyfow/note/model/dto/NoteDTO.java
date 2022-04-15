package com.br.schoolreyfow.note.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class NoteDTO implements Serializable {
    private Optional<BigDecimal> firstNote;
    private Optional<BigDecimal> secondNote;
    private Optional<BigDecimal> threeNote;
}
