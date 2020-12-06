package lamph11.blogbe.service.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import lamph11.blogbe.entity.Account;
import lamph11.blogbe.entity.Account_;

public class AccountSpecification {

    public static Specification<Account> usernameLike(String username) {
        if (StringUtils.isEmpty(username))
            return (root, query, builder) -> builder.conjunction();
        return (root, query, builder) -> builder.like(
            builder.lower( root.get(Account_.USERNAME) ), 
            "%"+username.toLowerCase()+"%"
        );
    }


    public static Specification<Account> statusEqual(Integer status) {
        if(status == null)
            return (root, query, builder) -> builder.conjunction();
        return (root, query, builder) -> builder.equal(
            root.get(Account_.STATUS), 
            status
        );
    }
}
