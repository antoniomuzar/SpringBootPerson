package com.antonio.springbootpersonapplication.api.v1.mapper;

import com.antonio.springbootpersonapplication.api.v1.model.PersonDTO;
import com.antonio.springbootpersonapplication.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDtoToPerson(PersonDTO personDTO);
}
