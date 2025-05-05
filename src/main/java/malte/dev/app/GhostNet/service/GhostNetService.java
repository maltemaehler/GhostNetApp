package malte.dev.app.GhostNet.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import malte.dev.app.GhostNet.model.GhostNet;
import malte.dev.app.GhostNet.repository.GhostNetRepository;
import malte.dev.app.GhostNet.repository.UserRepository;

import java.util.List;

@Service
public class GhostNetService {
    private final GhostNetRepository ghostNetRepository;
    private final UserRepository userRepository;
    
    public GhostNetService(GhostNetRepository ghostNetRepository, UserRepository userRepository) {
        this.ghostNetRepository = ghostNetRepository;
        this.userRepository = userRepository;
    }

    public List<GhostNet> getAllGhostNets() {
        return ghostNetRepository.findAll();
    }
    
    public GhostNet addGhostNet(GhostNet ghostnet) {
        // Get current authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Set editor based on authentication status
        if (authentication != null && authentication.isAuthenticated() && 
            !authentication.getName().equals("anonymousUser")) {
            String username = authentication.getName();
            ghostnet.setEditor(username);
            
            // Look up user's telephone number
            userRepository.findByName(username).ifPresent(user -> {
                ghostnet.setEditor_no(user.getTelephone());
            });
        } else {
            ghostnet.setEditor("anonymous");
            ghostnet.setEditor_no("N/A"); // Clear any existing number for anonymous edits
            ghostnet.setStatus("Gemeldet"); // Set status to inactive for anonymous users
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
            String username = authentication.getName();
            existingNet.setEditor(username);
            
            // Look up user's telephone number
            userRepository.findByName(username).ifPresent(user -> {
                existingNet.setEditor_no(user.getTelephone());
            });
        } else {
            existingNet.setEditor("anonymous");
            existingNet.setEditor_no(null); // Clear any existing number for anonymous edits
        }
        
        return ghostNetRepository.save(existingNet);
    }
}