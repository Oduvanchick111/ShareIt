package practicum.yandex.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import practicum.yandex.user.dto.UserRequestDto;
import practicum.yandex.user.dto.UserRequestDtoForUpdate;
import practicum.yandex.user.dto.UserResponseDto;
import practicum.yandex.user.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto saveNewUser(@Valid @RequestBody UserRequestDto user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto updateUser(@PathVariable Long userId, @Valid @RequestBody UserRequestDtoForUpdate userRequestDtoForUpdate) {
        return userService.updateUser(userId, userRequestDtoForUpdate);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }
}
