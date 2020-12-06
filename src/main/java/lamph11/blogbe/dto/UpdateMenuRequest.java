package lamph11.blogbe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UpdateMenuRequest {
 
    @NotNull
    @NotBlank
    private String id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Length(min = 1, max = 60)
    private String name;

    @Length(min = 1, max = 1024)
    private String description;
}
