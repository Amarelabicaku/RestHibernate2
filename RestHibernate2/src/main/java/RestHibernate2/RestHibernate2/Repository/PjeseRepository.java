package RestHibernate2.RestHibernate2.Repository;

import RestHibernate2.RestHibernate2.model.Pjese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PjeseRepository extends JpaRepository<Pjese,Long> {

}
