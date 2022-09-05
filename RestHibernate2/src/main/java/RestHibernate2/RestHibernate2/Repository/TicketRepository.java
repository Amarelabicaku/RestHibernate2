package RestHibernate2.RestHibernate2.Repository;

import RestHibernate2.RestHibernate2.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
