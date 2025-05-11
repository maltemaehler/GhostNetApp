package malte.dev.app.GhostNet.controller;

import org.springframework.web.bind.annotation.*;

import malte.dev.app.GhostNet.model.User;
import malte.dev.app.GhostNet.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        try {
            User sUser = userService.addUser(user);
            return "<div class='alert alert-success'>Nutzer " + sUser.getName() + " erfolgreich hinzugefügt!</div>";
        } catch (Exception e) {
        return "<div class='alert alert-danger'>Das Registrieren schlug fehl:" + e.getMessage() + "</div>";
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deletUser(id);
    }
}
