package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Dto.TickedDTO;
import RestHibernate2.RestHibernate2.Exeption.StockNotFound;
import RestHibernate2.RestHibernate2.Exeption.TicketNotFound;
import RestHibernate2.RestHibernate2.Repository.LaptopRepository;
import RestHibernate2.RestHibernate2.Repository.PjeseRepository;
import RestHibernate2.RestHibernate2.Repository.TicketRepository;
import RestHibernate2.RestHibernate2.Service.TicketService;
import RestHibernate2.RestHibernate2.model.Laptop;
import RestHibernate2.RestHibernate2.model.Pjese;
import RestHibernate2.RestHibernate2.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class Ticketimpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PjeseRepository pjeseRepository;
    @Autowired
    private LaptopRepository laptopRepository;

    public Ticketimpl(TicketRepository ticketRepository, PjeseRepository pjeseRepository) {
        this.ticketRepository = ticketRepository;
        this.pjeseRepository = pjeseRepository;
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);


    }

    @Override
    public Ticket getTicketById(long ticket_id) {
        Optional<Ticket> ticket = ticketRepository.findById(ticket_id);
        if (ticket.isPresent()) return ticket.get();
        else throw new TicketNotFound("Ticket", "ticket_id", ticket_id);
    }

    @Override
    public Ticket updateTicket(Ticket ticket, long ticket_id) {
        Ticket existingTicket = ticketRepository.findById(ticket_id).orElseThrow(() -> new TicketNotFound("Ticket", "ticket_id", ticket_id));
        existingTicket.setTicket_description(ticket.getTicket_description());
        existingTicket.setPjese(ticket.getPjese());
        existingTicket.setLaptop(ticket.getLaptop());
        ticketRepository.save(existingTicket);
        return existingTicket;
    }

    @Override
    public void deleteTicket(long ticket_id) {
        ticketRepository.findById(ticket_id).orElseThrow(() -> new TicketNotFound("Ticket", "ticket_id", ticket_id));
        ticketRepository.deleteById(ticket_id);
    }


    @Override
    @Transactional
    public TickedDTO addTicketToPjese(TickedDTO tickedDTO) {

        Optional<Pjese> pjese= pjeseRepository.findById(tickedDTO.getPjese().getPjese_id());
        tickedDTO.setPjese(pjese.get());
        Optional<Laptop> laptop = laptopRepository.findById(tickedDTO.getLaptop().getLaptopid());
        tickedDTO.setLaptop(laptop.get());
        if (pjese == null){
throw new RuntimeException("This pjese isnt in our database");
        }
        if (pjese.get().getStock() == 0){

throw new StockNotFound("stock","pjese.get().getStock()",pjese.get().getStock());
        }
        if (laptop == null){
            throw new RuntimeException("laptop doesnt exist");

        }
        Ticket ticket = new Ticket();

         mapDtoToEntity(tickedDTO, ticket);
        Ticket savedTicket = ticketRepository.save(ticket);
        pjese.get().setStock(pjese.get().getStock()-1);
        return mapEntityToDto(savedTicket);
    }

    private TickedDTO mapEntityToDto(Ticket savedTicket) {
        TickedDTO tickedDTO = new TickedDTO();
        tickedDTO.setTicket_id(savedTicket.getTicket_id());
        tickedDTO.setTicket_description(savedTicket.getTicket_description());
        tickedDTO.setPjese(savedTicket.getPjese());
        tickedDTO.setLaptop(savedTicket.getLaptop());
    return tickedDTO;}

  private Ticket mapDtoToEntity(TickedDTO tickedDTO, Ticket ticket) {
        ticket.setTicket_description(tickedDTO.getTicket_description());
        ticket.setPjese(tickedDTO.getPjese());
        ticket.setLaptop(tickedDTO.getLaptop());
        return ticket;
    }
  }