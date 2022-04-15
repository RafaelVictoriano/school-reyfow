package com.br.schoolreyfow.teacher;

import com.br.schoolreyfow.teacher.dto.TeacherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping()
    public String create(@RequestBody TeacherDto teacherDto) {
        var teacherId = teacherService.create(teacherDto);
        log.info("Teacher created with success id {}", teacherId);
        return teacherId;
    }

    @GetMapping()
    public List<TeacherDto> get(Pageable pageable) {
        var teachers = teacherService.findALl(pageable);
        log.info("Consult whit success");
        return teachers;
    }
}
