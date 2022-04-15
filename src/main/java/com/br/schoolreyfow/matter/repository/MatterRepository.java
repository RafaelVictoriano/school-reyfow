package com.br.schoolreyfow.matter.repository;

import com.br.schoolreyfow.matter.model.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MatterRepository extends JpaRepository<Matter, String> {

}