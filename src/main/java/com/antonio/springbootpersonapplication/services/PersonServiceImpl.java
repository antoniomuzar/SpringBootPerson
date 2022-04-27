package com.antonio.springbootpersonapplication.services;

import com.antonio.springbootpersonapplication.api.v1.mapper.PersonMapper;
import com.antonio.springbootpersonapplication.api.v1.model.PersonDTO;
import com.antonio.springbootpersonapplication.controllers.v1.PersonController;
import com.antonio.springbootpersonapplication.domain.Person;
import com.antonio.springbootpersonapplication.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
       return  personRepository
                .findAll()
                .stream()
                .map(person -> {
                    PersonDTO personDTO = personMapper.personToPersonDTO(person);
                    personDTO.setPersonUrl(getPersonUrl(person.getId()));
                    return personDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::personToPersonDTO)
                .map(personDTO -> {
                    personDTO.setPersonUrl(getPersonUrl(id));
                    return personDTO;
                })
        .orElseThrow(RuntimeException::new);
    }

    @Override
    public PersonDTO createNewPerson(PersonDTO personDTO) {
        return saveAndReturnDTO(personMapper.personDtoToPerson(personDTO));

    }
    private PersonDTO saveAndReturnDTO(Person person){
        Person savedPerson= personRepository.save(person);

        PersonDTO returnDto = personMapper.personToPersonDTO(person);

        returnDto.setPersonUrl(getPersonUrl(savedPerson.getId()));

        return  returnDto;
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);

    }
    private String getPersonUrl(Long id){
        return PersonController.BASE_URL + "/" + id;
    }
}
