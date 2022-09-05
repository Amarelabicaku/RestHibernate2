package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.Dto.PersonDto;

import java.util.List;

public interface PersonLaptopService {

    List<PersonDto> getAllPersonByFirstnameLaptop();

    List<PersonDto> getAllPersonLaptopById(long laptopid);

    List<PersonDto> getAllPersonLaptopByName(String name);

    List<PersonDto> getAllPersonLaptop();

    List<PersonDto> getAllPersonLaptopAll();
}
