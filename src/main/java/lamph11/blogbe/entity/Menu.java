package lamph11.blogbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity{

    @Id
    private String ID;

    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 1, max = 60)
    private String name;

    @Column(length = 2024)
    @Length(min = 1, max = 1024)
    private String description;

}
