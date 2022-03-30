package eu.filip.loginverification.controller;

import eu.filip.loginverification.service.UserService;
import eu.filip.loginverification.util.RegisterCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterCredentials registerCredentials){
        log.info(registerCredentials.toString());
        userService.registerUser(registerCredentials);
    }
}
