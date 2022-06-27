package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonsRepository personsRepository;

    public ArrayList<Person> getAllPersons() {
        // cast iterable to ArrayList
        return (ArrayList<Person>) personsRepository.findAll();
    }

    public Optional<Person> getPersonById(long id) {
        return personsRepository.findById(id);
    }

    public void savePerson(Person person) {
        personsRepository.save(person);
    }

    public void deletePerson(long id) {
        personsRepository.deleteById(id);
    }
}
