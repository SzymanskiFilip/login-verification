package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET active = 1 WHERE id = ?1", nativeQuery = true)
    void activateById(Long id);
}
