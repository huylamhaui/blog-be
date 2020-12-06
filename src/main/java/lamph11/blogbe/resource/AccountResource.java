package lamph11.blogbe.resource;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamph11.blogbe.common.ResponseUtils;
import lamph11.blogbe.dto.FilterAccountRequest;
import lamph11.blogbe.entity.Account;
import lamph11.blogbe.service.AccountService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountResource {

    private AccountService accountService;
    

    @GetMapping
    public ResponseEntity<?> getPageAccount(@ModelAttribute FilterAccountRequest request) {
        try {
            Page<Account> page = accountService.query(request);
            return ResponseEntity.ok(ResponseUtils.success(page));
        }catch(Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }
}
