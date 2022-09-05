package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Exeption.Laptopnotfound;
import RestHibernate2.RestHibernate2.Repository.LaptopRepository;
import RestHibernate2.RestHibernate2.Service.LaptopService;
import RestHibernate2.RestHibernate2.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Laptopimpl implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;


    public Laptopimpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @Override
    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAll();
    }


    @Override
    public Laptop getLaptopById(long laptopid) {
        Optional<Laptop> laptop = laptopRepository.findById(laptopid);
        if (laptop.isPresent()) {
            return laptop.get();
        } else {
            throw new Laptopnotfound("Laptop", "id", laptopid);
        }
    }


    @Override
    public void deleteLaptop(long laptopid) {
        laptopRepository.findById(laptopid).orElseThrow(() -> new Laptopnotfound("Laptop", "id", laptopid));
        laptopRepository.deleteById(laptopid);

    }


    @Override
    public Laptop updateLaptop(Laptop laptop, long laptopid) {
        Laptop existingLaptop = laptopRepository.findById(laptopid).orElseThrow(() -> new Laptopnotfound("Laptop", "id", laptopid));
        existingLaptop.setName(laptop.getName());
        existingLaptop.setPrice(laptop.getPrice());

        laptopRepository.save(existingLaptop);
        return existingLaptop;
    }
}



