package com.br.schoolreyfow.note.repository;

import com.br.schoolreyfow.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findByStudentIdAndMatterId(String studentId, String matterId);

    List<Note> findAllByStudentId(String studentId);
}