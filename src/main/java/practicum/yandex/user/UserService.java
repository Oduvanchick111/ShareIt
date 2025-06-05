package practicum.yandex.user;

import java.util.List;

interface UserService {
    List<UserDao> getAllUsers();
    UserDao saveUser(UserDao user);
}
