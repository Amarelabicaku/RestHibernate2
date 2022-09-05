package RestHibernate2.RestHibernate2.Controllers;


import RestHibernate2.RestHibernate2.Service.PersonService;
import RestHibernate2.RestHibernate2.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/person")
    public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        return new ResponseEntity<Person>(personService.updatePerson(person, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return new ResponseEntity<String>("Sucess", HttpStatus.CREATED);
    }
    @GetMapping("/personsByLaptopName")
    public ResponseEntity <List<Person>> getAllPersonByLaptopName(@RequestParam ("name") String name) {

        return new ResponseEntity<List<Person>> (personService.getAllLaptopByName(name), HttpStatus.OK);
    }
       }







