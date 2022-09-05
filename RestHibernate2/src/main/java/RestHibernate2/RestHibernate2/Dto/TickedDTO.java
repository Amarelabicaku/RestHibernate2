package RestHibernate2.RestHibernate2.Dto;

import RestHibernate2.RestHibernate2.model.Laptop;
import RestHibernate2.RestHibernate2.model.Pjese;
import lombok.Data;

@Data
public class TickedDTO {
   private long ticket_id;
   private String ticket_description;
   private Pjese pjese;
   private Laptop laptop;
}
