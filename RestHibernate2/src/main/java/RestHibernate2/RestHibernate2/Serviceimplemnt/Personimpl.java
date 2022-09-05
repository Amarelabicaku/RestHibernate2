package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Exeption.Resourcenotfound;
import RestHibernate2.RestHibernate2.Repository.PersonRepository;
import RestHibernate2.RestHibernate2.Service.PersonService;
import RestHibernate2.RestHibernate2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Personimpl implements PersonService {
@Autowired
    private PersonRepository personRepository;

    public Personimpl(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;

    }
    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return  personRepository.findAll();
    }

    @Override
    public List<Person> getAllLaptopByName(String name) {
        return personRepository.findByLaptop_Name(name);
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {

            return person.get();
        } else {
            throw new Resourcenotfound("Person", "id",id);
        }
    }


    @Override
    public Person updatePerson(Person person, long id) {
        Person existingEmployee=personRepository.findById(id).orElseThrow(()->new Resourcenotfound("Person","id",id));
        existingEmployee.setUsername(person.getUsername());
        existingEmployee.setLastname(person.getLastname());
        existingEmployee.setEmail(person.getEmail());
        personRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deletePerson(long id) {
        personRepository.findById(id).orElseThrow(()->new Resourcenotfound("Person","id",id));
        personRepository.deleteById(id);

    }



}
