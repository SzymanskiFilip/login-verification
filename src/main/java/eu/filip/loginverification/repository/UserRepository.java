package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);

    User findByEmail(String email);

    @Override
    boolean existsById(Long id);

    @Override
    User save(User user);

    boolean existsByEmail(String email);
}
