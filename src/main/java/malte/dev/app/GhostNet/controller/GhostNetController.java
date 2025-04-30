package malte.dev.app.GhostNet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GhostNetController {

    @GetMapping("/nets")
    public String listGhostNets() {
        return "/test/nets";
    }
}
