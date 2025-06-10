package practicum.yandex.user.mapper;

import practicum.yandex.user.dto.UserRequestDto;
import practicum.yandex.user.dto.UserRequestDtoForUpdate;
import practicum.yandex.user.dto.UserResponseDto;
import practicum.yandex.user.model.UserDao;

public class UserMapper {
    public static UserResponseDto toUserResponseDto(UserDao userDao) {
        return UserResponseDto.builder()
                .id(userDao.getId())
                .email(userDao.getEmail())
                .name(userDao.getName())
                .build();
    }

    public static UserDao toUserDao(UserRequestDto userDto) {
        return UserDao.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
    }

    public static UserDao toUserDaoUpdate(UserRequestDtoForUpdate userDto) {
        return UserDao.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
    }
}
