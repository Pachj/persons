package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class MainController {

    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/persons";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        ArrayList<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }

    @GetMapping("/addPerson")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/addPerson")
    public String addNewPersonOrChangePerson(@ModelAttribute @Valid Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }
}
