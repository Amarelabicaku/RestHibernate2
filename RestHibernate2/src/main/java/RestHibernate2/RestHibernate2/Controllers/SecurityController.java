package RestHibernate2.RestHibernate2.Controllers;

import RestHibernate2.RestHibernate2.Service.AuthenticationSerivce;
import RestHibernate2.RestHibernate2.modelsecurity.JwtRequest;
import RestHibernate2.RestHibernate2.modelsecurity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/login")
public class SecurityController {

    @Autowired
    private AuthenticationSerivce authenticationSerivce;

    @GetMapping()
    public String home() {
        return "Hi:)";
    }
   @PostMapping("/login/authenticate")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) {
       return authenticationSerivce.authenticate(jwtRequest);
    }
}

