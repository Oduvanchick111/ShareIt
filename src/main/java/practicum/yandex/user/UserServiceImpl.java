package practicum.yandex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public Collection<UserResponseDto> getAllUsers() {
        return repository.findAll().stream()
                .map(UserMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userDto) {
        UserDao dao = UserMapper.toUserDao(userDto);
        UserDao saved = repository.save(dao);
        return UserMapper.toUserResponseDto(saved);
    }
}
