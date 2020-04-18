package com.test.controller;

import com.test.entity.PersonBean;
import com.test.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class CrudController {

    final PersonService personService;

    public CrudController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("")
    void create(@RequestBody PersonBean personBean){
        personService.create(personBean);
    }

    @GetMapping("")
    List<PersonBean> getAll(){
        return personService.getAll();
    }

    @GetMapping("/getPersonByFirstName/{username}")
    PersonBean read(@PathVariable String username){
        return personService.read(username);
    }

    @PutMapping("/{username}")
    boolean update(@PathVariable String username, @RequestBody PersonBean personBean){
        return personService.update(username, personBean);
    }

    @DeleteMapping("/{username}")
    void delete(@PathVariable String username){
        personService.delete(username);
    }
}
