package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.model.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> getAllPerson();

List<Person>getAllLaptopByName(String name);

    Person updatePerson(Person person, long id);
    void deletePerson(long id);

    Person getPersonById(long id);



}
