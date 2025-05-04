package malte.dev.app.GhostNet.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import malte.dev.app.GhostNet.model.GhostNet;
import malte.dev.app.GhostNet.repository.GhostNetRepository;

import java.util.List;

@Service
public class GhostNetService {
    private final GhostNetRepository ghostNetRepository;
    
    public GhostNetService(GhostNetRepository ghostNetRepository) {
        this.ghostNetRepository = ghostNetRepository;
    }

    public List<GhostNet> getAllGhostNets() {
        return ghostNetRepository.findAll();
    }

    public GhostNet addGhostNet(GhostNet ghostnet) {
        // Get current authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        ghostnet.setStatus("Gemeldet");

        // Set editor based on authentication status
        if (authentication != null && authentication.isAuthenticated() && 
            !authentication.getName().equals("anonymousUser")) {
            ghostnet.setEditor(authentication.getName()); // Use authenticated username
        } else {
            ghostnet.setEditor("anonymous"); // Default value
        }
        
        return ghostNetRepository.save(ghostnet);
    }

    public GhostNet updateGhostNetStatus(Long id, String status) {
        // Get current authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        GhostNet existingNet = ghostNetRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("GhostNet not found with id: " + id));
        
        existingNet.setStatus(status);
        
        // Update editor based on who made the change
        if (authentication != null && authentication.isAuthenticated() && 
            !authentication.getName().equals("anonymousUser")) {
            existingNet.setEditor(authentication.getName());
        } else {
            existingNet.setEditor("anonymous");
        }
        
        return ghostNetRepository.save(existingNet);
    }
}