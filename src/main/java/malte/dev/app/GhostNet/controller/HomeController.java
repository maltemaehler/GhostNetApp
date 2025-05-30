package malte.dev.app.GhostNet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Endpoint for landing page
    @GetMapping("/")
    public String home() {
        return "index";
    }
}