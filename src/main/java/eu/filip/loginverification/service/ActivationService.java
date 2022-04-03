package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.Token;
import eu.filip.loginverification.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivationService {

    private TokenService tokenService;
    private UserService userService;

    public void activate(UUID token){
        //take token Object with the token passed from controller
        Token tokenObject = tokenService.findByToken(token);
        System.out.println(tokenObject.toString());

        //if token is not expired
        //set user with the id of the id of the token to activated
    }
}
