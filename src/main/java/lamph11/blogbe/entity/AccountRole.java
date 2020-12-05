package lamph11.blogbe.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account_role")
public class AccountRole {

    @EmbeddedId
    private AccountRolePk ID;
    
}
