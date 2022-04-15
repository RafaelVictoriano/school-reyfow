package com.br.schoolreyfow.teacher;

import com.br.schoolreyfow.teacher.dto.TeacherDto;
import com.br.schoolreyfow.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper mapper = Mappers.getMapper(TeacherMapper.class);

    public String create(TeacherDto teacherDto) {
        var teacher = this.mapper.toEntity(teacherDto);
        var teacherSaved = this.teacherRepository.save(teacher);

        return teacherSaved.getId();
    }

    public List<TeacherDto> findALl(Pageable pageable) {
        Page<Teacher> teachers = teacherRepository.findAll(pageable);
        return teachers.stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
