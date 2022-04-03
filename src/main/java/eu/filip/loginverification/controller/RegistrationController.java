package eu.filip.loginverification.controller;

import eu.filip.loginverification.entity.Token;
import eu.filip.loginverification.entity.User;
import eu.filip.loginverification.service.ActivationService;
import eu.filip.loginverification.service.MailService;
import eu.filip.loginverification.service.TokenService;
import eu.filip.loginverification.service.UserService;
import eu.filip.loginverification.util.RegisterCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final TokenService tokenService;
    private final MailService mailService;
    private final ActivationService activationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterCredentials registerCredentials){
        log.info(registerCredentials.toString());
        boolean created = userService.registerUser(registerCredentials);

        if(created){
            Token token = tokenService.createToken(userService.getIdByEmail(registerCredentials.getEmail()));
            try{
                mailService.sendMail(
                        registerCredentials.getEmail(),
                        "Verification",
                        "Hello " + registerCredentials.getUsername() + " activate your account here: "
                                + "http://localhost:8080/activate/" + token.getActivation_token()
                );
            } catch (Exception e){
                e.printStackTrace();
            }
            return ResponseEntity.ok("account created");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/activate/{token}")
    public ResponseEntity<?> activateAccount(@PathVariable String token){
        boolean activated = activationService.activate(UUID.fromString(token));

        if(activated){
            return ResponseEntity.ok("Activated");
        }
        return ResponseEntity.notFound().build();
    }

}
