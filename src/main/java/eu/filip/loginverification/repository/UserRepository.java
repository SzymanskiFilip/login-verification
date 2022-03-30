package eu.filip.loginverification.repository;

import eu.filip.loginverification.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);
}
