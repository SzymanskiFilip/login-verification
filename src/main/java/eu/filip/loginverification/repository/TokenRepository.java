package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findById(Long id);

    //TODO: SELECT * FROM verification_tokens WHERE activation_token = UUID_TO_BIN('7d74fe4e-d4e5-4118-b0bc-a140d06fd3d0'); takie query działa!!!
    @Query(value = "SELECT * FROM verification_tokens WHERE activation_token = ?1", nativeQuery = true)
    Token findByActivation_token(UUID token);

    @Override
    <S extends Token> S save(S entity);
}
