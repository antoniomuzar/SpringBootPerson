package com.antonio.springbootpersonapplication.repositories;

import com.antonio.springbootpersonapplication.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
