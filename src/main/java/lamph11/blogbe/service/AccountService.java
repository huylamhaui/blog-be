package lamph11.blogbe.service;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lamph11.blogbe.dto.RegisterRequest;
import lamph11.blogbe.entity.Account;
import lamph11.blogbe.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AccountService {
    
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    public Account create(RegisterRequest request) {
        Account account = new Account()
            .setUsername(request.getUsername())
            .setPassword(
                passwordEncoder.encode(request.getPassword())
            )
            .setStatus(0)
            .setID(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }
}
