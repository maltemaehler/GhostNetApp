package malte.dev.app.GhostNet.controller;
import malte.dev.app.GhostNet.service.GhostNetService;

import org.springframework.web.bind.annotation.*;
import malte.dev.app.GhostNet.model.GhostNet;

@RestController
@RequestMapping("/api/ghostnet")

public class GhostNetRestController {
    private final GhostNetService ghostNetService;

    public GhostNetRestController(GhostNetService ghostNetService) {
        this.ghostNetService = ghostNetService;
    }

    @PostMapping
    public String createGhostNet(@RequestBody GhostNet ghostnet) {
        GhostNet gnId = ghostNetService.addGhostNet(ghostnet);
        return "<div class='alert alert-success'>Ghostnet with ID "+ gnId.getId() + " created successfully!</div>";
    }

    @PutMapping("/status")
    public String updateGhostNetStatus(@RequestBody GhostNet ghostnet) {
        ghostNetService.updateGhostNetStatus(ghostnet.getId(), ghostnet.getStatus());
        // Return HTML that includes script to reload the page
        return "</div><script>setTimeout(() => window.location.reload(), 10);</script>";
    }
}