package lamph11.blogbe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotEmpty
    @NotNull
    @NotBlank
    private String username;

    @NotEmpty
    @NotNull
    @NotBlank
    private String password;
}
