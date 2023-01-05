package eif.viko.lt.simulith.webapp.controller;

import eif.viko.lt.simulith.webapp.model.Person;
import eif.viko.lt.simulith.webapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PeopleApiController {

    final
    PeopleService peopleService;

    public PeopleApiController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("")
    public Iterable<Person> getAllPeople() {
        return peopleService.findAllPeople();
    }

    @GetMapping("{id}")
    public Optional<Person> getPerson(@PathVariable long id) {
        return peopleService.findById(id);
    }

    @PostMapping("")
    public String addPerson(@RequestBody Person person) {

        if(person != null) {
            peopleService.insert(person);
            return "Added a person";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") long id) {
        peopleService.delete(id);
        return "Person deleted id=" + id;
    }

    @PutMapping("")
    public String updatePerson(@RequestBody Person person) {
        if(person != null) {
            peopleService.update(person);
            return "Updated person.";
        } else {
            return "Request does not contain a body";
        }
    }
}



