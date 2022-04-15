package com.br.schoolreyfow.student;

import com.br.schoolreyfow.student.dto.StudentFormDTO;
import com.br.schoolreyfow.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CreateStudent {

    private StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Test
    public void mustReturnAStudentEntity() {
        var studentFormDTO = new StudentFormDTO("Rafael Victoriano", "rafaelvictoriano@hotmail.com", 20, 14997509483l,"");
        var student = mapper.studentFormDTOToStudent(studentFormDTO);

        assertEquals(studentFormDTO.getAge(), student.getAge());
        assertEquals(studentFormDTO.getName(), student.getName());
        assertEquals(studentFormDTO.getEmail(), student.getEmail());
        assertEquals(studentFormDTO.getCourseId(), student.getCourse().getId());
    }


//    @Test
//    public void whenConvertPostDtoToPostEntity_thenCorrect() {
//        var studentFormDTO = new StudentFormDTO("Rafael Victoriano", "rafaelvictoriano@hotmail.com", 20);
//        var student = modelMapper.map(studentFormDTO, Student.class);
//
//        assertEquals(studentFormDTO.getAge(), student.getAge());
//        assertEquals(studentFormDTO.getName(), student.getName());
//        assertEquals(studentFormDTO.getEmail(), student.getEmail());
//    }
}
