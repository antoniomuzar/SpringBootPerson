package com.antonio.springbootpersonapplication.bootstrap;

import com.antonio.springbootpersonapplication.domain.Person;
import com.antonio.springbootpersonapplication.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final PersonRepository personRepository;

    public Bootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
    private void loadData(){

        Person person1= new Person();
        person1.setId(1L);
        person1.setName("Brian");
        person1.setSurname("Buck");
        person1.setAge(36);
        person1.setPhoneNumber("565486562266");
        person1.setUserUrl("api/v1/persons/1");

        personRepository.save(person1);

        Person person2= new Person();
        person2.setId(2L);
        person2.setName("Jen");
        person2.setSurname("Milles");
        person2.setAge(45);
        person2.setPhoneNumber("432534645645");
        person2.setUserUrl("api/v1/persons/2");


        personRepository.save(person2);

        Person person3= new Person();
        person3.setId(3L);
        person3.setName("Sara");
        person3.setSurname("Fritz");
        person3.setAge(28);
        person3.setPhoneNumber("4534765785723");
        person3.setUserUrl("api/v1/persons/3");

        personRepository.save(person3);

        Person person4= new Person();
        person4.setId(4L);
        person4.setName("Jelena");
        person4.setSurname("Horvat");
        person4.setAge(23);
        person4.setPhoneNumber("54353453454354");
        person4.setUserUrl("api/v1/persons/4");

        personRepository.save(person4);

        Person person5= new Person();
        person5.setId(5L);
        person5.setName("Ivan");
        person5.setSurname("Mikić");
        person5.setAge(52);
        person5.setPhoneNumber("345643654363456");
        person5.setUserUrl("api/v1/persons/5");

        personRepository.save(person5);

    }
}
