package lamph11.blogbe.resource;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lamph11.blogbe.common.ResponseUtils;
import lamph11.blogbe.dto.RegisterRequest;
import lamph11.blogbe.entity.Account;
import lamph11.blogbe.service.AccountService;
import lamph11.blogbe.service.JwtService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthResource {

    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;

    @RequestMapping
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username, 
                password,
                Collections.emptyList()
            );
            Authentication result = authenticationManager.authenticate(auth);
            String token = JwtService.generateToken(result);
            return ResponseEntity.ok(ResponseUtils.success(token));
        } catch (Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }

    @RequestMapping("/check-token")
    public ResponseEntity<?> checkToken(@RequestParam String token) {
        try {
            Authentication auth = JwtService.getAuthentication(token);
            return ResponseEntity.ok(ResponseUtils.success(auth));
        } catch( Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        try {
            Account registed = accountService.create(request);
            return ResponseEntity.ok(ResponseUtils.success(registed));
        } catch(Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }

}
