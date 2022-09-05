package RestHibernate2.RestHibernate2.Controllers;

import RestHibernate2.RestHibernate2.Dto.TickedDTO;
import RestHibernate2.RestHibernate2.Service.TicketService;
import RestHibernate2.RestHibernate2.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        super();
        this.ticketService = ticketService;
    }

    @PostMapping()
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);

    }

    @GetMapping()
    public List<Ticket> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @GetMapping("/{ticket_id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("ticket_id") long ticket_id) {
        return new ResponseEntity<>(ticketService.getTicketById(ticket_id), HttpStatus.OK);
    }

    @PutMapping("/{ticket_id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("ticket_id") long ticket_id, @RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.updateTicket(ticket, ticket_id), HttpStatus.OK);
    }

    @DeleteMapping("/{ticket_id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("ticket_id") long ticket_id) {
        ticketService.deleteTicket(ticket_id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);
    }
    @PostMapping("/ticket1")
    public ResponseEntity<TickedDTO> savePjeseToTicket(@RequestBody TickedDTO tickedDTO) {
     TickedDTO std = ticketService.addTicketToPjese(tickedDTO);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
}