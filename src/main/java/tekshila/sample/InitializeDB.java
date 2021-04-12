package tekshila.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tekshila.sample.model.User;
import tekshila.sample.repo.UserRepository;

@Component
public class InitializeDB implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public InitializeDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"user1","user1@tekshila.com");
            userRepository.save(user1);
        User user2 = new User(null,"user2","user2@tekshila.com");
            userRepository.save(user2);
    }

}
