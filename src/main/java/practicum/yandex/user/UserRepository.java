package practicum.yandex.user;

import java.util.Collection;
import java.util.Optional;


interface UserRepository {
    Collection<UserDao> findAll();
    UserDao save(UserDao user);
    Optional<UserDao> findUserById(Long id);
}
