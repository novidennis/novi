package novi.spring.rest.service;

import novi.spring.repository.UserRepository;
import novi.spring.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository users;

    public User getActiveUser() throws SQLDataException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> _user = users.findByUsername(authentication.getName());
        if (!_user.isPresent()) {
            throw new SQLDataException("User not present");
        }
        return _user.get();
    }
}
