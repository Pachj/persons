package ch.bbw.persons;

import ch.bbw.persons.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/editPerson")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "editPerson";
    }

    @PostMapping("/editPerson")
    public String addNewPersonOrChangePerson(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPerson";
        }

        personService.savePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/editPerson/{id}")
    public String editPerson(Model model, @PathVariable int id) {
        System.out.println(personService.getPersonById(id));
        model.addAttribute("person", personService.getPersonById(id));
        return "editPerson";
    }

    @PostMapping("/editPerson/{id}/delete")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}
