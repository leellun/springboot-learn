package com.newland.bootdata.service;

import com.newland.bootdata.pojo.Person;
import com.newland.bootdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired(required = false)
    private PersonRepository personRepsotory;

    @Transactional
    public void savePersons(List<Person> persons) {
        personRepsotory.saveAll(persons);
    }

    @Transactional
    public void updatePersonEmail(String email, Integer id) {
        personRepsotory.updatePersonEmail(id, email);
    }
}
