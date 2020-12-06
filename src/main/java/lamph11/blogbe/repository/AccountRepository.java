package lamph11.blogbe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import lamph11.blogbe.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>, 
    JpaSpecificationExecutor<Account> {

    Optional<Account> findByUsername(String username);
}
