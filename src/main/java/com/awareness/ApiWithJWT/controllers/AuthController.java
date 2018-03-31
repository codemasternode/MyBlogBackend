package com.awareness.ApiWithJWT.controllers;


import com.awareness.ApiWithJWT.exceptions.AppException;
import com.awareness.ApiWithJWT.model.RoleName;
import com.awareness.ApiWithJWT.model.User;
import com.awareness.ApiWithJWT.model.UserRole;
import com.awareness.ApiWithJWT.payloads.ApiRespone;
import com.awareness.ApiWithJWT.payloads.JwtAuthenticationResponse;
import com.awareness.ApiWithJWT.payloads.LoginRequest;
import com.awareness.ApiWithJWT.payloads.SignUp;
import com.awareness.ApiWithJWT.repositories.UserRepo;
import com.awareness.ApiWithJWT.repositories.UserRoleRepo;
import com.awareness.ApiWithJWT.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepository;

    @Autowired
    UserRoleRepo roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUp signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiRespone(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiRespone(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(
                signUpRequest.getName(),
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword()
                );

        user.setPassword(passwordEncoder.encode(user.getPassword()));


        UserRole userRole = roleRepository.findByRole(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User role not found"));

        user.setUserRole(Collections.singleton(userRole));

        User result = userRepository.save(user);

        return ResponseEntity.ok(new ApiRespone(true, "User registered successfully"));
    }





}
