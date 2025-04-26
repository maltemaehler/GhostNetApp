package malte.dev.app.GhostNet.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleOutputService {
    public String getGreeting() {
        return "Simple Output";
    }
}
