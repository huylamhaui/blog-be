package lamph11.blogbe.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lamph11.blogbe.dto.FilterAccountRequest;
import lamph11.blogbe.dto.RegisterRequest;
import lamph11.blogbe.entity.Account;
import lamph11.blogbe.repository.AccountRepository;
import lamph11.blogbe.service.specifications.AccountSpecification;
import lombok.AllArgsConstructor;

import static lamph11.blogbe.service.specifications.AccountSpecification.*;
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


    public Page<Account> query(FilterAccountRequest request) {
        Pageable pageable = request.buildPage();
        Specification<Account> spec = Specification.where(
            usernameLike(request.getUsername())
        ).and(
            statusEqual(request.getStatus())
        );
        
        return accountRepository.findAll(spec, pageable);
    }
}
