package eif.viko.lt.simulith.webapp.repository;

import eif.viko.lt.simulith.webapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PersonRepository extends CrudRepository<Person, Long> { }
