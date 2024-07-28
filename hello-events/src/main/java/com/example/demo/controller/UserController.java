package com.example.demo.controller;

import com.example.demo.config.JwtAuth;
import com.example.demo.model.User;
import com.example.demo.model.Erole;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        user.setRole(Erole.USER);
        userService.signUp(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User user2 = userService.findByUsername(user.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        Erole role = user2.getRole();
        String token = JwtAuth.generateToken(user.getUsername(), role);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile/{id}")
    public User updateUserProfile(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateProfile(id, user);
    }

    @GetMapping("/registres")
    public List<User> showRegisters() {
        return userService.findAllRegistre();
    }

    @DeleteMapping("/{idUser}")
    public void deleteUser(@PathVariable Integer idUser) {
        userService.deleteUser(idUser);
    }
}
