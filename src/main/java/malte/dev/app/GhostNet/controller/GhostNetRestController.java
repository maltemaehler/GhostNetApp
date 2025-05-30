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

    // Add GhostNet
    @PostMapping
    public String createGhostNet(@RequestBody GhostNet ghostnet) {
        try {
            GhostNet savedNet = ghostNetService.addGhostNet(ghostnet);
            return "<div class='alert alert-success'>Geisternetz "+ savedNet.getId() + " erfolgreich hinzugefügt!</div>";
        } catch (Exception e) {
            return "<div class='alert alert-danger'>Es ist ein Fehler aufgetreten: " + e.getMessage() + "</div>";
        }
    }

    // Change status of a GhostNet
    @PutMapping("/status")
    public String updateGhostNetStatus(@RequestBody GhostNet ghostnet) {
        try {
            GhostNet updated = ghostNetService.updateGhostNetStatus(ghostnet.getId(), ghostnet.getStatus());
            return "<div class='alert alert-success'>Geisternetz " + updated.getId() + " erfolgreich geändert!</div>" + 
                   "<script>setTimeout(() => window.location.reload(), 2500);</script>";
        } catch (Exception e) {
            return "<div class='alert alert-danger'>Es ist ein Fehler aufgetreten: " + e.getMessage() + "</div>";
        }
    }
}