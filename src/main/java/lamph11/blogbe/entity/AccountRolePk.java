package lamph11.blogbe.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class AccountRolePk implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -6501095732464579178L;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
}
