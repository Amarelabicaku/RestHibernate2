package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.Dto.TickedDTO;
import RestHibernate2.RestHibernate2.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicket();



    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(long ticket_id);

    Ticket updateTicket(Ticket ticket, long ticket_id);

    void deleteTicket(long ticket_id);

    TickedDTO addTicketToPjese(TickedDTO tickedDTO);

//    TickedDTO addTicketToPjese(TickedDTO tickedDTO);


}
