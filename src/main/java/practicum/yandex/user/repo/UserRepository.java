package practicum.yandex.user.repo;

import practicum.yandex.user.model.UserDao;

import java.util.Collection;
import java.util.Optional;


public interface UserRepository {
    Collection<UserDao> findAll();

    UserDao save(UserDao user);

    Optional<UserDao> findUserById(Long id);

    UserDao update(Long userId, UserDao user);

    void delete(Long userId);

    boolean existsByEmail(String email);
}
