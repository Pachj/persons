package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class MainController {

    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        ArrayList<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }
}
