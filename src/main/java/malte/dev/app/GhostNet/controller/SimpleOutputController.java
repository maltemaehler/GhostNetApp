package malte.dev.app.GhostNet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import malte.dev.app.GhostNet.service.SimpleOutputService;

@RestController
public class SimpleOutputController {
    private final SimpleOutputService simpleOutputService;

    public SimpleOutputController(SimpleOutputService simpleOutputService) {
        this.simpleOutputService = simpleOutputService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return simpleOutputService.getGreeting();
    }
}
