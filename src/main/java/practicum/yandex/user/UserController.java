package practicum.yandex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDao> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDao saveNewUser(@RequestBody UserDao user) {
        return userService.saveUser(user);
    }
}
