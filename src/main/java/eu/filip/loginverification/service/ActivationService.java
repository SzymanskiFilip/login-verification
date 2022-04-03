package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.Token;
import eu.filip.loginverification.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivationService {

    private TokenService tokenService;
    private UserService userService;

    public boolean activate(UUID token){
        //take token Object with the token passed from controller
        Token tokenObject = tokenService.findByToken(token);
        System.out.println(tokenObject.toString());


        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(tokenObject.getExpiration_date())){
            System.out.println("TOKEN IS STILL VALID");
            userService.activateAccount(tokenObject.getUser_id());
            return true;
        }
        return false;
    }
}
