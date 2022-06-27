package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonsRepository personsRepository;

    public ArrayList<Person> getAllPersons() {
        // cast iterable to ArrayList
        return (ArrayList<Person>) personsRepository.findAll();
    }
}
