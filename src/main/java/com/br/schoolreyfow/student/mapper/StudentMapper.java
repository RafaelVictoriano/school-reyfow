package com.br.schoolreyfow.student.mapper;


import com.br.schoolreyfow.student.Student;
import com.br.schoolreyfow.student.dto.StudentDTO;
import com.br.schoolreyfow.student.dto.StudentFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "course.id", source = "courseId")
    public abstract Student studentFormDTOToStudent(StudentFormDTO studentFormDTO);

    @Mapping(target = "courseName", source = "course.name")
    public abstract StudentDTO studentToStudentDTO(Student student);


}
