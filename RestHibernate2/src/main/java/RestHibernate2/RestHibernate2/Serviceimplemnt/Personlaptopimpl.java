package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Dto.PersonDto;
import RestHibernate2.RestHibernate2.Repository.LaptopRepository;
import RestHibernate2.RestHibernate2.Repository.PersonRepository;
import RestHibernate2.RestHibernate2.Service.PersonLaptopService;
import RestHibernate2.RestHibernate2.model.Laptop;
import RestHibernate2.RestHibernate2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Personlaptopimpl implements PersonLaptopService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LaptopRepository laptopRepository;


    public Personlaptopimpl(PersonRepository personRepository, LaptopRepository laptopRepository) {
        this.personRepository = personRepository;
        this.laptopRepository = laptopRepository;
    }


    private PersonDto mapEntityToDto(Laptop laptop) {

        PersonDto responseDto = new PersonDto();
        responseDto.setName(laptop.getName());
        responseDto.setLaptopid(laptop.getLaptopid());
        responseDto.setPrice(laptop.getPrice());

        List<String> list = new ArrayList<>();
        for (Person person : laptop.getPerson()) {
            String firstname = person.getUsername();
            String lastname = person.getLastname();
            String email = person.getEmail();
            list.add(firstname);
            list.add(lastname);
            list.add(email);

        }
        responseDto.setPerson(list);
        return responseDto;
    }

    private void mapDtoToEntity(PersonDto dtoperson, Laptop laptop) {
        laptop.setName(dtoperson.getName());
        laptop.setPrice(dtoperson.getPrice());

        if (null == laptop.getPerson()) {
            laptop.setPerson(new ArrayList<>());
        }

        dtoperson.getPerson().forEach(username -> {
            Person person = personRepository.findByUsername(username);

            if (null == person) {
                person = new Person();
                person.setLaptop(new ArrayList<>());
            }
            person.setUsername(username);
            laptop.addpersonlaptop(person);
        });
    }

    @Override
    public List<PersonDto> getAllPersonLaptop() {
        List<PersonDto> personDtosDtos = new ArrayList<>();
        List<Laptop> perssss = laptopRepository.findAll();
        perssss.forEach(laptop -> {
            PersonDto personDto = mapEntityToDto(laptop);
            personDtosDtos.add(personDto);
        });
        return personDtosDtos;
    }

    @Override
    public List<PersonDto> getAllPersonByFirstnameLaptop() {
        List<PersonDto> personDtosDtos = new ArrayList<>();
        List<Laptop> persosss = laptopRepository.findAll();
        persosss.forEach(laptop -> {
            PersonDto personDto = mapEntityToDto5(laptop);
            personDtosDtos.add(personDto);
        });
        return personDtosDtos;
    }

    private PersonDto mapEntityToDto5(Laptop laptop) {
        PersonDto responseDto = new PersonDto();
        responseDto.setName(laptop.getName());
        responseDto.setLaptopid(laptop.getLaptopid());
        responseDto.setPrice(laptop.getPrice());

        List<String> list = new ArrayList<>();
        for (Person person : laptop.getPerson()) {
            String firstname = person.getUsername();


            list.add(firstname);


        }
        responseDto.setPerson(list);
        return responseDto;
    }


    @Override
    public List<PersonDto> getAllPersonLaptopById(long laptopid) {
        List<PersonDto> personDtosDtos = new ArrayList<>();
        List<Laptop> laptops = laptopRepository.findAllById(Collections.singleton(laptopid));

        laptops.forEach(laptop -> {
            PersonDto personDto = mapEntityToDto1(laptop);
            personDtosDtos.add(personDto);
        });
        return personDtosDtos;
    }

    @Override
    public List<PersonDto> getAllPersonLaptopByName(String name) {
        List<PersonDto> personDtosDtos = new ArrayList<>();
        Laptop laptop = laptopRepository.findByName(name);

//        laptops.forEach(laptop -> {
        PersonDto personDto = mapEntityToDto1(laptop);
        personDtosDtos.add(personDto);

        return personDtosDtos;
    }


    private PersonDto mapEntityToDto1(Laptop laptop) {
        PersonDto responseDto = new PersonDto();
        responseDto.setName(laptop.getName());
        responseDto.setLaptopid(laptop.getLaptopid());
        responseDto.setPrice(laptop.getPrice());


        List<String> list = new ArrayList<>();
        for (Person person : laptop.getPerson()) {
            String firstname = person.getUsername();

            list.add(firstname);

        }
        responseDto.setPerson(list);
        return responseDto;
    }


    @Override
    public List<PersonDto> getAllPersonLaptopAll() {
        List<PersonDto> personDtosDtos = new ArrayList<>();
        List<Laptop> laptopss = laptopRepository.findAll();
        laptopss.forEach(laptop -> {
            PersonDto personDto = mapEntityToDto1(laptop);
            personDtosDtos.add(personDto);
        });
        return personDtosDtos;
    }
}