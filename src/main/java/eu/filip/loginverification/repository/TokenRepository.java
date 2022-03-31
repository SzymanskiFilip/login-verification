package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findById(Long id);

    @Override
    <S extends Token> S save(S entity);
}
