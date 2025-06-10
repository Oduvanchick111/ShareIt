package practicum.yandex.user.repo;

import org.springframework.stereotype.Component;
import practicum.yandex.user.model.UserDao;

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
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public UserDao update(Long userId, UserDao user) {
        UserDao existingUser = users.get(userId);
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        return existingUser;
    }

    @Override
    public void delete(Long userId) {
        users.remove(userId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return findAll().stream().anyMatch(userDao -> email.equals(userDao.getEmail()));
    }

    private Long getNextId() {
        Collection<UserDao> users = findAll();
        return users.isEmpty() ? 1L : users.stream()
                .mapToLong(UserDao::getId)
                .max()
                .orElse(0) + 1;
    }
}
