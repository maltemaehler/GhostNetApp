package malte.dev.app.GhostNet.service;

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
        return ghostNetRepository.save(ghostnet);
    }
}
