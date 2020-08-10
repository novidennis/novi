package novi.spring.rest.data.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


public class SignupRequest {

    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private List<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    @Getter
    @Setter
    private String password;


}
