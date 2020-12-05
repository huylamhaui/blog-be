package lamph11.blogbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
    
    @Id
    private String ID;

    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 3, max = 60)
    private String username;
    
    @Column(nullable = false, length = 60)
    @Length(max = 60)
    private String password;

}
