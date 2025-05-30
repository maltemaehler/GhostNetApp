package malte.dev.app.GhostNet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import malte.dev.app.GhostNet.service.GhostNetService;

@Controller
public class GhostNetController {

    private final GhostNetService ghostNetService;

    public GhostNetController(GhostNetService ghostNetService) {
        this.ghostNetService = ghostNetService;
    }

    // Endpoint for ghostnet overview
    @GetMapping("/nets")
    public String listGhostNets(Model model) {
        model.addAttribute("ghostnets", ghostNetService.getAllGhostNets());
        return "nets";
    }
}
