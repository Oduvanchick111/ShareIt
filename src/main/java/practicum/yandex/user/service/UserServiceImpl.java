package practicum.yandex.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicum.yandex.exceptions.EmailAlreadyExistsException;
import practicum.yandex.exceptions.NotFoundException;
import practicum.yandex.user.dto.UserRequestDto;
import practicum.yandex.user.dto.UserRequestDtoForUpdate;
import practicum.yandex.user.dto.UserResponseDto;
import practicum.yandex.user.mapper.UserMapper;
import practicum.yandex.user.model.UserDao;
import practicum.yandex.user.repo.UserRepository;

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
        if (!userDto.getEmail().isEmpty()) {
            if (repository.existsByEmail(userDto.getEmail())) {
                throw new EmailAlreadyExistsException("Такой email уже существует");
            }
        }
        UserDao dao = UserMapper.toUserDao(userDto);
        UserDao saved = repository.save(dao);
        return UserMapper.toUserResponseDto(saved);
    }

    @Override
    public UserResponseDto findUserById(Long userId) {
        return repository.findUserById(userId).map(UserMapper::toUserResponseDto).orElseThrow(() -> new NotFoundException("Такого пользователя не существует"));
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDtoForUpdate userRequestDtoForUpdate) {
        if (repository.findUserById(userId).isEmpty()) {
            throw new NotFoundException("Такого пользователя не существует");
        }
        if (userRequestDtoForUpdate.getEmail() != null) {
            if (repository.existsByEmail(userRequestDtoForUpdate.getEmail())) {
                throw new EmailAlreadyExistsException("Такой email уже существует");
            }
        }
        UserDao userDao = UserMapper.toUserDaoUpdate(userRequestDtoForUpdate);
        userDao.setId(userId);
        repository.update(userId, userDao);
        return UserMapper.toUserResponseDto(userDao);
    }

    @Override
    public void deleteUser(Long userId) {
        if (repository.findUserById(userId).isEmpty()) {
            throw new NotFoundException("Такого пользователя не существует");
        } else {
            repository.delete(userId);
        }
    }
}
