package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {
}
