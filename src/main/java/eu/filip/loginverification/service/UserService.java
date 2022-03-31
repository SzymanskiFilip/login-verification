package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.User;
import eu.filip.loginverification.repository.UserRepository;
import eu.filip.loginverification.util.RegisterCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public void registerUser(RegisterCredentials registerCredentials){
        log.info("EMAIL PASSED: " + registerCredentials.getEmail());
        if(!userRepository.existsByEmail(registerCredentials.getEmail())){
            log.info("DOESNT EXIST CREATING USER!");
            User user = new User();
            user.setUsername(registerCredentials.getUsername());
            user.setPassword(registerCredentials.getPassword());
            user.setEmail(registerCredentials.getEmail());
            user.setActive(false);

            userRepository.save(user);
        }
    }

    public Long getIdByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user.getId();
    }


}
