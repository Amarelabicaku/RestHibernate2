package RestHibernate2.RestHibernate2.Serviceimplemnt;

import RestHibernate2.RestHibernate2.Service.AuthenticationSerivce;
import RestHibernate2.RestHibernate2.Service.UserService;
import RestHibernate2.RestHibernate2.Utility.JWTUtility;
import RestHibernate2.RestHibernate2.modelsecurity.JwtRequest;
import RestHibernate2.RestHibernate2.modelsecurity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationSerivce {

    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtility jwtUtility;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<JwtResponse> authenticate(JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
            final UserDetails userDetails= userService.loadUserByUsername(jwtRequest.getUsername());

            final String jwtToken= jwtUtility.generateToken(userDetails);
            return  ResponseEntity.ok(new JwtResponse(jwtToken));

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());

        }
    }
}
