package RestHibernate2.RestHibernate2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pjese {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pjese_id;

    private String pjese_name;
    private String pjese_description;
    private long pjese_cmimi;
    private int stock;
    @JsonIgnore
@OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> ticket=new ArrayList<>();

public void addTicket(Ticket ticket1){
    this.ticket.add(ticket1);
//    ticket1.getPjese().add(this);
}
}
