package com.br.schoolreyfow.student;

import com.br.schoolreyfow.aws.SNSSend;
import com.br.schoolreyfow.note.NoteService;
import com.br.schoolreyfow.student.dto.StudentDTO;
import com.br.schoolreyfow.student.dto.StudentFormDTO;
import com.br.schoolreyfow.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);
    private final NoteService noteService;
    private final SNSSend snsSend;

    @Transactional
    public void create(StudentFormDTO studentFormDTO) {
        var student = this.mapper.studentFormDTOToStudent(studentFormDTO);
        this.studentRepository.save(student);
        this.noteService.create(student, studentFormDTO.getCourseId());
        this.snsSend.pubTopic(student, Map.of("email", student.getEmail()));
    }

    public List<StudentDTO> findAll(Pageable pageable) {
        var pageStudents = this.studentRepository.findAll(pageable);
        var students = pageStudents.getContent();
        return students.stream().map(mapper::studentToStudentDTO)
                .collect(Collectors.toList());
    }

}
