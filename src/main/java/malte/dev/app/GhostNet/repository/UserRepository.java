package malte.dev.app.GhostNet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import malte.dev.app.GhostNet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}