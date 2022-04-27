package com.antonio.springbootpersonapplication.services;

import com.antonio.springbootpersonapplication.api.v1.model.PersonDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO createNewPerson(PersonDTO personDTO);


    void deletePersonById(Long id);
}
