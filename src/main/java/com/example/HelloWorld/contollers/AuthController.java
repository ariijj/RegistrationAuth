package com.example.HelloWorld.contollers;


import com.example.HelloWorld.Repo.StudentRepo;
import com.example.HelloWorld.Request.LoginRequest;
import com.example.HelloWorld.Response.MessageResponse;
import com.example.HelloWorld.Response.UserInfoResponse;
import com.example.HelloWorld.Security.jwt.JwtUtils;
import com.example.HelloWorld.Service.StudentService;
import com.example.HelloWorld.Service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    StudentService studentServices;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentRepo userRepository;




    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail()
                        ));
    }

   @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestParam("CV") MultipartFile CV, @RequestParam("letttre_motivation") MultipartFile lettre_motivation
           , @RequestParam("image") MultipartFile Image, @RequestParam("Name") String name
           , @RequestParam("studentaddress") String studentaddress, @RequestParam("mobile") String mobile
           , @RequestParam("studentbirth") String studentbirth, @RequestParam("studentemail") String studentemail,
                                          @RequestParam("passwod") String passwod, @RequestParam("compassword") String compassword) throws IOException {
        if (userRepository.existsByusername(name)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(studentemail)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account


      else {

            return new ResponseEntity<>(studentServices.addCandidat(CV, lettre_motivation, Image, name, studentaddress, mobile, studentbirth, studentemail, passwod, compassword), HttpStatus.OK);
        }
    }}
