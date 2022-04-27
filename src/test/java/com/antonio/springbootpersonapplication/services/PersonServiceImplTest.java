package com.antonio.springbootpersonapplication.services;

import com.antonio.springbootpersonapplication.api.v1.mapper.PersonMapper;
import com.antonio.springbootpersonapplication.api.v1.model.PersonDTO;
import com.antonio.springbootpersonapplication.domain.Person;
import com.antonio.springbootpersonapplication.repositories.PersonRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    PersonMapper personMapper=PersonMapper.INSTANCE;

    PersonService personService;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        personService = new PersonServiceImpl(personMapper, personRepository);
    }

    @Test
    void getAllPersons() throws Exception{

        Person person1 = new Person();
        person1.setId(1l);
        person1.setName("Joe");
        person1.setSurname("Muck");

        Person person2 = new Person();
        person2.setId(2l);
        person2.setName("Helen");
        person2.setSurname("Wallace");

        when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));


        List<PersonDTO> personDTOS = personService.getAllPersons();


        assertEquals(2, personDTOS.size());

    }

    @Test
    void getPersonById() throws Exception {


        Person person1 = new Person();
        person1.setId(1l);
        person1.setName("Logan");
        person1.setSurname("Lennon");

        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(person1));


        PersonDTO personDTO = personService.getPersonById(1L);

        assertEquals("Logan", personDTO.getName());
    }


    @Test
    void deletePersonById() {

        Long id = 1L;

        personRepository.deleteById(id);

        verify(personRepository, times(1)).deleteById(anyLong());
    }


}