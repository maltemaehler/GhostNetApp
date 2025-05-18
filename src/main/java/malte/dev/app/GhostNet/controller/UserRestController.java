package malte.dev.app.GhostNet.controller;

import org.springframework.web.bind.annotation.*;

import malte.dev.app.GhostNet.model.User;
import malte.dev.app.GhostNet.service.UserService;

@RestController //Combination of @Controller and @ResponseBody
@RequestMapping("/api/user") //Base URL for this controller
public class UserRestController {
    private final UserService userService;


    //Constructor dependency injection. Auto injects UserService.
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // Creates User
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
