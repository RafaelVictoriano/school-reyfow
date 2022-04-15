package com.br.schoolreyfow.course;

import com.br.schoolreyfow.course.dto.CourseDTO;
import com.br.schoolreyfow.course.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    public Course findById(String id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    public List<CourseDTO> findAll() {
        var courses = this.courseRepository.findAll();
        return courses.stream().map(mapper::courseToCourseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(String name) {
        var course = new Course();
        course.setName(name);
        return this.courseRepository.save(course).getId();
    }

    public void checkRegistrationNewStudent(Course course) {
        if (course.addStudent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "It was not possible to register the student in the "
                    + course.getName() + " course, the course is currently out of vacancies");
        }
        course.setQuantityStudents(course.getQuantityStudents() + 1);
        this.courseRepository.save(course);
    }
}
