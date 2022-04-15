package com.br.schoolreyfow.student;

import com.br.schoolreyfow.student.dto.StudentDTO;
import com.br.schoolreyfow.student.dto.StudentFormDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

import static com.br.schoolreyfow.auth.user.Role.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @RolesAllowed({STUDENT, TEACHER, COORDINATOR})
    @GetMapping
    private ResponseEntity<List<StudentDTO>> get(Pageable pageable) {
        var students = this.studentService.findAll(pageable);
        log.info("Consult with success");
        return ResponseEntity.ok(students);
    }


    @RolesAllowed(COORDINATOR)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@Valid @RequestBody StudentFormDTO studentFormDTO) {
        this.studentService.create(studentFormDTO);
        log.info("Student created with success");
    }


}
