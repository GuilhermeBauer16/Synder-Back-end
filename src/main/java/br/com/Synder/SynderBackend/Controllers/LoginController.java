package br.com.Synder.SynderBackend.Controllers;

import br.com.Synder.SynderBackend.domain.client.Client;
import br.com.Synder.SynderBackend.domain.client.ClientLoginAuthentication;
import br.com.Synder.SynderBackend.infra.Security.TokenJWTDetail;
import br.com.Synder.SynderBackend.infra.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid ClientLoginAuthentication clientLoginAuthentication){
        System.out.println("chegou aqui ");
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(clientLoginAuthentication.email(), clientLoginAuthentication.password());
            var authentication = authenticationManager.authenticate(authenticationToken);
            var tokenJWT = tokenService.generateToken((Client) authentication.getPrincipal());
            return ResponseEntity.ok(new TokenJWTDetail(tokenJWT));
        } catch (AuthenticationException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

