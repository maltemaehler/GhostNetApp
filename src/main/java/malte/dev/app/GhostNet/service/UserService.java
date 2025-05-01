package malte.dev.app.GhostNet.service;

import org.springframework.stereotype.Service;
import java.util.List;
import malte.dev.app.GhostNet.model.User;
import malte.dev.app.GhostNet.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public void deletUser(Long id) {
        userRepo.deleteById(id);
    }
}
