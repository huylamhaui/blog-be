package lamph11.blogbe.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account_role")
public class AccountRole {

    @EmbeddedId
    private AccountRolePk ID;
    
    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;
}
