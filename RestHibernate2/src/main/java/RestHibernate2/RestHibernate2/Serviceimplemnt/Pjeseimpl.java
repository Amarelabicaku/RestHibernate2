package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Exeption.PjeseNotFound;
import RestHibernate2.RestHibernate2.Repository.PjeseRepository;
import RestHibernate2.RestHibernate2.Service.PjeseService;
import RestHibernate2.RestHibernate2.model.Pjese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pjeseimpl implements PjeseService {
@Autowired
    private PjeseRepository pjeseRepository;


    public Pjeseimpl(PjeseRepository pjeseRepository) {
        this.pjeseRepository = pjeseRepository;
    }
        @Override
                public Pjese savePjese(Pjese pjese){
            return pjeseRepository.save(pjese);
        }
        @Override
    public List<Pjese> getAllPjese(){
      return  pjeseRepository.findAll();
        }
        @Override
    public Pjese getPjeseById(long pjese_id) {
            Optional<Pjese> pjese = pjeseRepository.findById(pjese_id);
            if (pjese.isPresent()) {
                return pjese.get();
            }
            else{
                throw new PjeseNotFound("Pjese", "pjese_id",pjese_id);
            }
            }
            @Override
    public Pjese updatePjese(Pjese pjese, long pjese_id){
        Pjese existingPjese=pjeseRepository.findById(pjese_id).orElseThrow(()->new PjeseNotFound("Pjese","pjese_id",pjese_id));
                existingPjese.setPjese_name(pjese.getPjese_name());
                existingPjese.setPjese_description(pjese.getPjese_description());
                existingPjese.setPjese_cmimi(pjese.getPjese_cmimi());
             existingPjese.setStock(pjese.getStock());
                pjeseRepository.save(existingPjese);
                return existingPjese;
            }
            @Override
    public void deletePjese(long pjese_id){
        pjeseRepository.findById(pjese_id).orElseThrow(()->new PjeseNotFound("Pjese","pjese_id",pjese_id));
        pjeseRepository.deleteById(pjese_id);
            }
        }


