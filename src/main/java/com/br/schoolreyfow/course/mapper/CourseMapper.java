package com.br.schoolreyfow.course.mapper;

import com.br.schoolreyfow.course.Course;
import com.br.schoolreyfow.course.dto.CourseDTO;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    Course courseDTOToCourse(CourseDTO courseDTO);

    CourseDTO courseToCourseDTO(Course course);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourseFromCourseDTO(CourseDTO courseDTO, @MappingTarget Course course);

}
