package eif.viko.lt.simulith.webapp.service;

import eif.viko.lt.simulith.webapp.model.Person;

import java.util.Optional;

public interface PeopleService {
    Iterable<Person> findAllPeople();
    Optional<Person> findById(Long id);
    long insert(Person p);
    void delete(Long id);
    void update(Person p);
}
