package malte.dev.app.GhostNet.repository;

import malte.dev.app.GhostNet.model.GhostNet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhostNetRepository extends JpaRepository<GhostNet, Long> {
}