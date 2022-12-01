package com.example.block13mongodb.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/getAll")
    public List<PersonDTO> getAll(@RequestParam(defaultValue = "1")int pagenum, @RequestParam(defaultValue = "5")int pagesize){
        List<Person> people=mongoTemplate.findAll(Person.class);
        List<PersonDTO> dtos=new ArrayList<>();
        people.forEach(person -> dtos.add(person.setToDTO()));
        PagedListHolder pagedListHolder=new PagedListHolder<>(dtos);
        pagedListHolder.setPageSize(Integer.valueOf(pagesize));
        pagedListHolder.setPage(Integer.valueOf(pagenum));
        return pagedListHolder.getPageList();
    }

    @PostMapping("/add")
    public PersonDTO addPerson(@RequestBody Person p){
        mongoTemplate.save(p);
        return p.setToDTO();
    }
}
