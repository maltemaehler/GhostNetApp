package malte.dev.app.GhostNet.controller;

import org.springframework.web.bind.annotation.*;
import malte.dev.app.GhostNet.model.User;
import malte.dev.app.GhostNet.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
