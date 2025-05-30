package malte.dev.app.GhostNet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Endpoint for login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Endpoint for registration page
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}