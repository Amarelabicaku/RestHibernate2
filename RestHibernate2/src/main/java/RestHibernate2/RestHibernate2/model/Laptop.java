package RestHibernate2.RestHibernate2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Data
    @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
    @Entity
    public class Laptop  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long laptopid;
        private String name;
        private long price;
   //@JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "laptop")
        private List<Person> person = new ArrayList<>();


       public void addpersonlaptop(Person person) {
           this.person.add(person);
            person.getLaptop().add(this);
        }

        public void removepersonlaptop(Person person) {
           this.getPerson().remove(person);
            person.getLaptop().remove(this);
        }

        public void removepersonssLaptops() {
           for (Person person1 : new ArrayList<>(person)) {
               removepersonlaptop(person1);
            }

        }
    }
