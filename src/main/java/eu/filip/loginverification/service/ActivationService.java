package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivationService {
    private TokenService tokenService;
    private UserService userService;

    public void activate(UUID token){
        //take token Object with the token passed from controller
        //tokenService.findByToken(token.toString());
        //if token is not expired
        //set user with the id of the id of the token to activated
    }
}
