package com.br.schoolreyfow.note.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class NoteResponseDTO implements Serializable {
    private final BigDecimal firstNote;
    private final BigDecimal secondNote;
    private final BigDecimal threeNote;
    private final BigDecimal average;
    private final String matterName;
}
