package eu.filip.loginverification.controller;

import eu.filip.loginverification.entity.Token;
import eu.filip.loginverification.service.TokenService;
import eu.filip.loginverification.service.UserService;
import eu.filip.loginverification.util.RegisterCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterCredentials registerCredentials){
        log.info(registerCredentials.toString());
        userService.registerUser(registerCredentials);
        tokenService.createToken(userService.getIdByEmail(registerCredentials.getEmail()));
    }

    @GetMapping("/activate/{token}")
    public ResponseEntity<?> activateAccount(@PathVariable String token){
        Token tokenObject = tokenService.findByToken(UUID.fromString(token));
        if(tokenObject == null){
            return ResponseEntity.notFound().build();
        } else{
            log.info(tokenObject.toString());
            userService.activateAccount(tokenObject.getUser_id());
            return ResponseEntity.ok().build();
        }
    }

}
