package RestHibernate2.RestHibernate2.Controllers;

import RestHibernate2.RestHibernate2.Service.LaptopService;
import RestHibernate2.RestHibernate2.model.Laptop;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/laptops")

    public class LaptopController {

        private LaptopService laptopService;

        public LaptopController(LaptopService laptopService) {
            super();
            this.laptopService = laptopService;
        }


        @PostMapping()
        public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
            return new ResponseEntity<Laptop>(laptopService.saveLaptop(laptop), HttpStatus.CREATED);

        }

        @GetMapping
        public List<Laptop> getAllLaptop() {
            return (List<Laptop>) laptopService.getAllLaptop();
        }

        @GetMapping("/{laptopid}")
        public ResponseEntity<Laptop> getLaptopById(@PathVariable("laptopid") long laptopid) {
            return new ResponseEntity<Laptop>(laptopService.getLaptopById(laptopid), HttpStatus.OK);
        }

        @PutMapping("/{laptopid}")
        public ResponseEntity<Laptop> update(@PathVariable("laptopid") long laptopid, @RequestBody Laptop laptop) {
            return new ResponseEntity<Laptop>(laptopService.updateLaptop(laptop, laptopid), HttpStatus.OK);
        }

        @DeleteMapping("/{laptopid}")
        public ResponseEntity<String> delete(@PathVariable("laptopid") long laptopid) {
            laptopService.deleteLaptop(laptopid);
            return new ResponseEntity<String>("Sucess", HttpStatus.CREATED);
        }



        }




