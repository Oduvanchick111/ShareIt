package practicum.yandex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserDao> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserDao saveUser(UserDao user) {
        return repository.save(user);
    }
}
