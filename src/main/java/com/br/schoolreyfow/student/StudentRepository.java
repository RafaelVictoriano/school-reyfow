package com.br.schoolreyfow.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    @EntityGraph(attributePaths = "course", type = EntityGraph.EntityGraphType.FETCH)
    Page<Student> findAll(Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.course.id =?1")
    Optional<List<Student>> findByCourseId(String courseId);
}