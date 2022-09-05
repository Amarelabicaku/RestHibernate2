package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.model.Laptop;

import java.util.List;

public interface LaptopService {
    Laptop saveLaptop(Laptop laptop);

    List<Laptop> getAllLaptop();


    Laptop getLaptopById(long laptopid);

    Laptop updateLaptop(Laptop laptop, long laptopid);

    void deleteLaptop(long laptopid);

}


