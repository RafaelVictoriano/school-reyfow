package com.br.schoolreyfow.course;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "matters")
    @Override
    Optional<Course> findById(String s);
}