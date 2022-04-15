package com.br.schoolreyfow.note;

import com.br.schoolreyfow.course.CourseService;
import com.br.schoolreyfow.note.model.Note;
import com.br.schoolreyfow.note.model.dto.NoteDTO;
import com.br.schoolreyfow.note.model.dto.NoteResponseDTO;
import com.br.schoolreyfow.note.model.mapper.NoteMapper;
import com.br.schoolreyfow.note.repository.NoteRepository;
import com.br.schoolreyfow.student.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteService {

    private final CourseService courseService;
    private final NoteRepository noteRepository;
    private final NoteMapper mapper = Mappers.getMapper(NoteMapper.class);

    public void create(Student student, String courseId) {
        var course = courseService.findById(courseId);
        this.courseService.checkRegistrationNewStudent(course);

        var notes = course.getMatters().stream()
                .map(m -> {
                    var note = new Note();
                    note.setMatter(m);
                    note.setStudent(student);

                    return note;
                }).collect(toList());

        this.noteRepository.saveAll(notes);
        log.info("student {} notes have been created successfully", student.getName());
    }


    public void update(String studentId, String matterId, NoteDTO noteDTO) {
        var note = this.noteRepository.findByStudentIdAndMatterId(studentId, matterId);
        note.ifPresentOrElse(n -> {
            noteDTO.getFirstNote().ifPresent(n::setFirstNote);
            noteDTO.getSecondNote().ifPresent(n::setSecondNote);
            noteDTO.getThreeNote().ifPresent(n::setThreeNote);
            this.noteRepository.save(n);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        });
    }


    public List<NoteResponseDTO> findAll(String studentId) {
        var notesOfStudent = noteRepository.findAllByStudentId(studentId);
        return notesOfStudent.stream().map(this.mapper::noteToNoteDTO)
                .collect(toList());
    }
}
