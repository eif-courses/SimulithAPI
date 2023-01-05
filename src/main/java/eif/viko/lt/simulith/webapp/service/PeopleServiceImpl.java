package eif.viko.lt.simulith.webapp.service;

import eif.viko.lt.simulith.webapp.model.Person;
import eif.viko.lt.simulith.webapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService{
    private final PersonRepository repository;

    @Autowired
    public PeopleServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Person> findAllPeople() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public long insert(Person p) {
        repository.save(p);
        return p.getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Person p) {
        repository.save(p);
    }
}
