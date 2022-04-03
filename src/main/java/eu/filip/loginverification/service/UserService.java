package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.User;
import eu.filip.loginverification.repository.UserRepository;
import eu.filip.loginverification.util.RegisterCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public boolean registerUser(RegisterCredentials registerCredentials){
        log.info("EMAIL PASSED: " + registerCredentials.getEmail());

        if(userRepository.existsByEmail(registerCredentials.getEmail())){
           return false;
        }

        User user = new User();
        user.setUsername(registerCredentials.getUsername());
        user.setPassword(registerCredentials.getPassword());
        user.setEmail(registerCredentials.getEmail());
        user.setActive(false);

        userRepository.save(user);
        return true;
    }

    public Long getIdByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user.getId();
    }

    public void activateAccount(Long id){
        userRepository.activateById(id);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }


}
