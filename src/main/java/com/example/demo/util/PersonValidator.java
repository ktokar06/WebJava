package com.example.demo.util;

import com.example.demo.models.Person;
import com.example.demo.securities.PersonDetailsServices;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsServices personDetailsServices;

    public PersonValidator(PersonDetailsServices personDetailsServices) {
        this.personDetailsServices = personDetailsServices;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        try {
            personDetailsServices.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ex) {
            return;
        }

        errors.rejectValue("username", "", "Person not found exception.");

    }
}
