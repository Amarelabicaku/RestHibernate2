package RestHibernate2.RestHibernate2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


    @Data
    @Entity
    public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String username;
        private String lastname;
        private String email;
        private String password;
           @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "laptop_person",
                joinColumns = @JoinColumn(name = "person_id"),
                inverseJoinColumns = @JoinColumn(name = "laptop_laptopid")
        )
            @ToString.Exclude
        private List<Laptop> laptop = new ArrayList<>();



    }