package practicum.yandex.user;

import java.util.Collection;

public interface UserService {
    Collection<UserResponseDto> getAllUsers();
    UserResponseDto saveUser(UserRequestDto userDto);
}
