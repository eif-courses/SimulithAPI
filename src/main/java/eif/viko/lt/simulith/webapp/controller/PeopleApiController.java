package eif.viko.lt.simulith.webapp.controller;

import eif.viko.lt.simulith.webapp.model.Person;
import eif.viko.lt.simulith.webapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/people", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PeopleApiController {

    final PeopleService peopleService;

    @Autowired
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

    @PostMapping(value = "")
    public ResponseEntity<Object> addPerson(@RequestBody Person person) {
        long id = peopleService.insert(person);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
        //return "ADDED TO DB";
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") long id) {
        peopleService.delete(id);
        return "Person deleted id=" + id;
    }

    @PutMapping("")
    public String updatePerson(@RequestBody Person person) {
        if (person != null) {
            peopleService.update(person);
            return "Updated person.";
        } else {
            return "Request does not contain a body";
        }
    }
}



