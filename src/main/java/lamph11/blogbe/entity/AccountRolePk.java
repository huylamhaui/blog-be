package lamph11.blogbe.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountRolePk implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -6501095732464579178L;

    
    private String accountId;

    private String roleId;
}
