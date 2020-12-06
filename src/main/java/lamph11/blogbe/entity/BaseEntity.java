package lamph11.blogbe.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.context.SecurityContextHolder;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {
    
    protected LocalDateTime createdDate;
    protected String createdBy;
    protected LocalDateTime updatedDate;
    protected String updatedBy;


    @PrePersist
    protected void beforeSave() {
        this.createdDate = LocalDateTime.now();
        this.createdBy = Optional.ofNullable(
            SecurityContextHolder.getContext().getAuthentication()
        ).get().getName();
    }


    @PreUpdate
    protected void beforeUpdate() {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = Optional.ofNullable(
            SecurityContextHolder.getContext().getAuthentication()
        ).get().getName();
    }
}
