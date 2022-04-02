package eu.filip.loginverification.service;

import eu.filip.loginverification.entity.Token;
import eu.filip.loginverification.entity.User;
import eu.filip.loginverification.repository.TokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class TokenService {
    private TokenRepository tokenRepository;

    public void createToken(Long user_id){
        Token token = new Token();
        token.setUser_id(user_id);

        UUID uuid = UUID.randomUUID();
        token.setActivation_token(uuid);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = now.plusDays(2L);
        token.setExpiration_date(date);

        log.info(uuid.toString() + " " + date.toString());

        tokenRepository.save(token);
    }

    public Token findByToken(UUID token){
       Token tokenObj;
       try{
           tokenObj = tokenRepository.findByActivation_token(token);
           if(tokenObj != null){
               return tokenObj;
           }
       } catch (IllegalArgumentException exception){
           exception.printStackTrace();
       }
       return null;
    }

}
