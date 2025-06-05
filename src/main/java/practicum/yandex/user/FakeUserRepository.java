package practicum.yandex.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeUserRepository implements UserRepository {
    private static final List<UserDao> FAKE_USERS = createManyFakeUsers(3);

    @Override
    public List<UserDao> findAll() {
        return FAKE_USERS;
    }

    @Override
    public UserDao save(UserDao user) {
        throw new UnsupportedOperationException("Метод save() ещё не готов");
    }

    private static List<UserDao> createManyFakeUsers(int count) {
        List<UserDao> fakeUsers = new ArrayList<>();
        for (long id = 1; id <= count; id++) {
            fakeUsers.add(createFakeUser(id));
        }
        return Collections.unmodifiableList(fakeUsers);
    }

    private static UserDao createFakeUser(long id) {
        UserDao fakeUser = new UserDao();
        fakeUser.setId(id);
        fakeUser.setEmail("mail" + id + "@example.com");
        fakeUser.setName("Akakiy Akakievich #" + id);
        return fakeUser;
    }
}
