package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.Repository.PersonRepository;
import RestHibernate2.RestHibernate2.modelsecurity.MyUserDetails;
import RestHibernate2.RestHibernate2.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private PersonRepository personRepository;

    private  ModelMapper modelMapper;
    public UserService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person =  personRepository.findByUsername(username);
        return new MyUserDetails(person);
    }

}
