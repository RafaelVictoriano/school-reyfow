package com.br.schoolreyfow.note;

import com.br.schoolreyfow.note.model.dto.NoteDTO;
import com.br.schoolreyfow.note.model.dto.NoteResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/note")
public record NoteController(NoteService noteService) {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{studentId}/{matterId}")
    public void put(@PathVariable String studentId, @PathVariable String matterId,
                    @RequestBody NoteDTO noteDTO) {
        this.noteService.update(studentId, matterId, noteDTO);
        log.info("Note updated with success, studentId {}", studentId);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<NoteResponseDTO>> getAll(@PathVariable String studentId) {
        var notesOfStudent = this.noteService.findAll(studentId);
        return ResponseEntity.ok(notesOfStudent);
    }
}
