package RestHibernate2.RestHibernate2.Service;

import RestHibernate2.RestHibernate2.modelsecurity.JwtRequest;
import RestHibernate2.RestHibernate2.modelsecurity.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationSerivce {
    ResponseEntity<JwtResponse> authenticate(JwtRequest jwtRequest);
}
