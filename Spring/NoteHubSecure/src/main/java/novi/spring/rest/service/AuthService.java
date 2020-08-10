package novi.spring.rest.service;

import novi.spring.repository.RoleRepository;
import novi.spring.repository.UserRepository;
import novi.spring.model.users.Role;
import novi.spring.model.users.User;
import novi.spring.rest.data.response.JwtResponse;
import novi.spring.rest.data.request.LoginRequest;
import novi.spring.rest.data.request.SignupRequest;
import novi.spring.helper.RoleConverter;
import novi.spring.security.jwt.JwtUtils;
import novi.spring.security.service.AuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleConverter roleConverter;

    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtils.generateJwtToken(authentication);

        AuthDetails userDetails = (AuthDetails) authentication.getPrincipal();
        List<String> roles = roleConverter.authoritiesToStrings(userDetails.getAuthorities());

        return new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

    public String signup(SignupRequest signUpRequest) throws InvalidParameterException {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new InvalidParameterException("Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new InvalidParameterException("Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        List<String> strRoles = signUpRequest.getRoles();
        List<Role> roles = roleConverter.stringsToRoles(strRoles);

        user.setRoles(roles);
        userRepository.save(user);
        return "User succesfully signed up";
    }
}