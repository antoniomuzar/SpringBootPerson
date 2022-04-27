package com.antonio.springbootpersonapplication.controllers.v1;


import com.antonio.springbootpersonapplication.api.v1.model.PersonDTO;
import com.antonio.springbootpersonapplication.api.v1.model.PersonListDTO;
import com.antonio.springbootpersonapplication.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    public static final String BASE_URL = "/api/v1/persons";

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonListDTO getListOfPersons(){
        return new PersonListDTO(personService.getAllPersons());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getPersonByID(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createNewPerson(@RequestBody PersonDTO personDTO){
        return personService.createNewPerson(personDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable Long id){
        personService.deletePersonById(id);
    }
}



