package com.br.schoolreyfow.course;

import com.br.schoolreyfow.course.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid CourseDTO courseDTO) {
        var courseUuid = courseService.create(courseDTO.getName());
        log.info("Course of {} created success", courseDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(courseUuid);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> get() {
        var courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable String id) {
        var course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }
}
