package com.br.schoolreyfow.note.model.mapper;

import com.br.schoolreyfow.matter.model.Matter;
import com.br.schoolreyfow.matter.model.dto.MatterDTO;
import com.br.schoolreyfow.note.model.Note;
import com.br.schoolreyfow.note.model.dto.NoteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    @Mapping(target = "matterName", source = "matter.name")
    NoteResponseDTO noteToNoteDTO(Note note);
}
