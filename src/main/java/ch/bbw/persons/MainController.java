package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    private PersonsRepository data;

    public MainController(PersonsRepository data) {this.data = data;}

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        ArrayList<Person> persons = (ArrayList<Person>) data.findAll();
        System.out.println(persons);
        model.addAttribute("persons", persons);
        return "persons";
    }
}
