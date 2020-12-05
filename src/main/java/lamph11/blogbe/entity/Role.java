package lamph11.blogbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    private String ID;

    @Column(nullable = false, unique = true, length = 30)
    @Length(min = 1, max = 30)
    private String name;

    @Column(length = 1024)
    @Length(max = 1024)
    private String description;


    @PrePersist
    private void preSave() {
        this.name = this.name.toUpperCase().trim();
    }
    
}
