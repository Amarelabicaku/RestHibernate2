package RestHibernate2.RestHibernate2.Controllers;

import RestHibernate2.RestHibernate2.Service.PjeseService;
import RestHibernate2.RestHibernate2.model.Pjese;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pjese")
public class PjeseController {
    private PjeseService pjeseService;

    public PjeseController(PjeseService pjeseService) {
        this.pjeseService = pjeseService;
    }

    @GetMapping()
    public List<Pjese> getAllPjese(){
        return pjeseService.getAllPjese();
    }
@GetMapping("/{pjese_id}")
    public ResponseEntity< Pjese> getPjeseById(@PathVariable("pjese_id") long pjese_id){
        return new ResponseEntity<>(pjeseService.getPjeseById(pjese_id), HttpStatus.OK);
}
@PostMapping()
    public ResponseEntity<Pjese>savePjese(@RequestBody Pjese pjese){
        return new ResponseEntity<>(pjeseService.savePjese(pjese),HttpStatus.CREATED);
}
@PutMapping("/{pjese_id}")
    public ResponseEntity<Pjese> updatePjese(@PathVariable("pjese_id") long pjese_id, @RequestBody Pjese pjese){
        return new ResponseEntity<>(pjeseService.updatePjese(pjese,pjese_id),HttpStatus.OK);
}
@DeleteMapping("/{pjeseid}")
    public ResponseEntity<String> deletePjese(@PathVariable("pjese_id")long pjese_id){
        pjeseService.deletePjese(pjese_id);
        return new ResponseEntity<>("Succes",HttpStatus.CREATED);
}
}
