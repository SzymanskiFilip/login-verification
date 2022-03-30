package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findByUser_id(Long id);
}
