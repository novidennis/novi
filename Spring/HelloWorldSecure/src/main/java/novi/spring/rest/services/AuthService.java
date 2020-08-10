package novi.spring.rest.services;

import novi.spring.repository.RoleRepository;
import novi.spring.repository.StudentRepository;
import novi.spring.model.Role;
import novi.spring.model.Student;
import novi.spring.rest.data.response.JwtResponse;
import novi.spring.rest.data.request.LoginRequest;
import novi.spring.rest.data.request.SignupRequest;
import novi.spring.helper.RoleConverter;
import novi.spring.security.jwt.JwtUtils;
import novi.spring.security.services.AuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleConverter roleConverter;

    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));

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
        if (studentRepository.existsByName(signUpRequest.getName())) {
            throw new InvalidParameterException("Username is already taken!");
        }

        if (studentRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new InvalidParameterException("Email is already in use!");
        }

        // Create new student's account
        Student student = new Student(signUpRequest.getName(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        List<String> strRoles = signUpRequest.getRoles();
        List<Role> roles = roleConverter.stringsToRoles(strRoles);

        student.setRoles(roles);
        studentRepository.save(student);
        return "User succesfully signed up";
    }
}