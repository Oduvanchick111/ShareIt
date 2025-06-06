package practicum.yandex.user;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, UserDao> users = new HashMap<>();

    @Override
    public Collection<UserDao> findAll() {
        return users.values();
    }

    @Override
    public UserDao save(UserDao user) {
        user.setId(getNextId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<UserDao> findUserById(Long id) {
        return Optional.empty();
    }


    private Long getNextId() {
        Collection<UserDao> users = findAll();
        return users.isEmpty() ? 1L : users.stream()
                .mapToLong(UserDao::getId)
                .max()
                .orElse(0) + 1;
    }
}
