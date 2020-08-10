package novi.spring.rest.controller;


import novi.spring.rest.data.response.JwtResponse;
import novi.spring.rest.data.request.LoginRequest;
import novi.spring.rest.data.request.SignupRequest;
import novi.spring.rest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            JwtResponse jwtResponse = authService.login(loginRequest);
            return ResponseEntity.ok(jwtResponse);
        } catch (InvalidParameterException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        try {
            String response = authService.signup(signUpRequest);
            return ResponseEntity.ok(response);
        } catch (InvalidParameterException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}