package RestHibernate2.RestHibernate2.Controllers;

import RestHibernate2.RestHibernate2.Dto.PersonDto;
import RestHibernate2.RestHibernate2.Service.PersonLaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Personlaptopcontroller {

    @Autowired
    private PersonLaptopService personLaptopService;

    @GetMapping("/laptopersons")
    public ResponseEntity<List<PersonDto>> getAllPersonsLaptops() {
        List<PersonDto> personDtos = personLaptopService.getAllPersonLaptop();
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }

    @GetMapping("/laptopersonsname")
    public ResponseEntity<List<PersonDto>> getAllPersonsLaptopsByname() {
        List<PersonDto> personDtos = personLaptopService.getAllPersonByFirstnameLaptop();
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }

    @GetMapping("/laptopersonsname/{laptopid}")
    public ResponseEntity<List<PersonDto>> getAllPersonsLaptopsById(@PathVariable("laptopid") long laptopid) {
        List<PersonDto> personDtos = personLaptopService.getAllPersonLaptopById(laptopid);
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }

    @GetMapping("laptop/{name}")
    public ResponseEntity<List<PersonDto>> getAllPersonsLaptopsHp(@PathVariable("name") String name) {
        List<PersonDto> personDtos = personLaptopService.getAllPersonLaptopByName(name);
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }


}
