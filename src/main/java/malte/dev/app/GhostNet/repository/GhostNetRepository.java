package malte.dev.app.GhostNet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import malte.dev.app.GhostNet.model.GhostNet;

@Repository
public interface GhostNetRepository extends JpaRepository<GhostNet, Long> {
}