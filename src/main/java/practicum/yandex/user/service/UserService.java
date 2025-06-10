package practicum.yandex.user.service;

import practicum.yandex.user.dto.UserRequestDto;
import practicum.yandex.user.dto.UserRequestDtoForUpdate;
import practicum.yandex.user.dto.UserResponseDto;

import java.util.Collection;

public interface UserService {
    Collection<UserResponseDto> getAllUsers();

    UserResponseDto saveUser(UserRequestDto userDto);

    UserResponseDto findUserById(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDtoForUpdate userRequestDtoForUpdate);

    void deleteUser(Long userId);
}
