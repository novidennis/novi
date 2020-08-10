package novi.spring;

import novi.spring.model.users.User;
import novi.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private UserRepository users;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Dennis", "novi@test.nl", "test");
        users.save(user);
    }
}