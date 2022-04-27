package com.antonio.springbootpersonapplication.api.v1.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String personUrl;

}
