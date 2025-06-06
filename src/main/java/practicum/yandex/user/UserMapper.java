package practicum.yandex.user;

public class UserMapper {
    public static UserResponseDto toUserResponseDto(UserDao userDao) {
        return UserResponseDto.builder()
                .id(userDao.getId())
                .email(userDao.getEmail())
                .name(userDao.getName())
                .build();
    }

    public static UserDao toUserDao (UserRequestDto userDto) {
        return UserDao.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
    }
}
