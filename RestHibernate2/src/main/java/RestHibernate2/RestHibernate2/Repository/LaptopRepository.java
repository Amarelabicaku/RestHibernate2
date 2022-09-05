package RestHibernate2.RestHibernate2.Repository;

import RestHibernate2.RestHibernate2.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

  Laptop findByName(String name);
}
