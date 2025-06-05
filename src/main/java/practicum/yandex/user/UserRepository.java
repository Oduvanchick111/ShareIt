package practicum.yandex.user;

import java.util.List;

interface UserRepository {
    List<UserDao> findAll();
    UserDao save(UserDao user);
}
