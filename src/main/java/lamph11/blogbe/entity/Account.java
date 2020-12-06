package lamph11.blogbe.entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "account")
public class Account extends BaseEntity implements UserDetails {
    
    /**
     *
     */
    private static final long serialVersionUID = -7793153108971183946L;

    @Id
    private String ID;

    @Column(nullable = false, unique = true, length = 60)
    @Length(min = 3, max = 60)
    private String username;
    
    @Column(nullable = false, length = 60)
    @Length(max = 60)
    private String password;

    @Column(nullable = false)
    private Integer status = 0;

    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoles;



    // transient
    @JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAccountRoles().stream()
            .map(item -> item.getRole())
            .collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
        System.out.println(this.status == 1);
		return this.status == 1;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
