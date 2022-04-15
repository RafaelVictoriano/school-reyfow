package com.br.schoolreyfow.teacher.mapper;


import com.br.schoolreyfow.teacher.Teacher;
import com.br.schoolreyfow.teacher.dto.TeacherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toEntity(TeacherDto teacherDto);

    TeacherDto toDto(Teacher teacher);
}
