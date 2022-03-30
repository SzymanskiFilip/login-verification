package eu.filip.loginverification.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class RegisterCredentials {

    @NotBlank(message = "username can't be blank")
    private String username;

    @NotBlank(message = "password can't be blank")
    private String password;

    @NotBlank(message = "email can't be blank")
    private String email;
}
