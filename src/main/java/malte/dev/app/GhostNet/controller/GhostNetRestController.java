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
        try {
            GhostNet savedNet = ghostNetService.addGhostNet(ghostnet);
            return "<div class='alert alert-success'>Ghostnet with ID "+ savedNet.getId() + " created successfully!</div>";
        } catch (Exception e) {
            return "<div class='alert alert-danger'>Error creating ghostnet: " + e.getMessage() + "</div>";
        }
    }

    @PutMapping("/status")
    public String updateGhostNetStatus(@RequestBody GhostNet ghostnet) {
        try {
            GhostNet updated = ghostNetService.updateGhostNetStatus(ghostnet.getId(), ghostnet.getStatus());
            // Fixed malformed HTML and increased timeout
            return "<div class='alert alert-success'>Ghostnet status updated successfully!</div>" + 
                   "<script>setTimeout(() => window.location.reload(), 1000);</script>";
        } catch (Exception e) {
            return "<div class='alert alert-danger'>Error updating status: " + e.getMessage() + "</div>";
        }
    }
}