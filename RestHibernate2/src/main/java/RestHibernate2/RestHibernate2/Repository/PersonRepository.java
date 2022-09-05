package RestHibernate2.RestHibernate2.Repository;

import RestHibernate2.RestHibernate2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
   Person findByUsername(String username);
   @Query(name = "Select p  from Person  Join  Laptop l  where l.name=:nam")

   List<Person> findByLaptop_Name(String name);
}
