package novi.spring.rest.services;

import novi.spring.repository.UserRepository;
import novi.spring.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLDataException;
import java.util.Optional;

@Controller
public class UserService {

    @Autowired
    private UserRepository users;

    public User getActiveUser() throws SQLDataException {
        Optional<User> _user = users.findById(1L);
        if (!_user.isPresent()) {
            throw new SQLDataException("User not present");
        }
        return _user.get();
    }
}
