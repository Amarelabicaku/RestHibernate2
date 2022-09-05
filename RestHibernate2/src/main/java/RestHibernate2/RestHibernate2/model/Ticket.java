package RestHibernate2.RestHibernate2.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticket_id;
    private String ticket_description;
    @OneToOne( )
    private Laptop laptop;
    @ManyToOne( )
    private Pjese pjese;




}
