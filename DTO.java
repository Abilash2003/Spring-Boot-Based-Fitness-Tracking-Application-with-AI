package com.fitness.userservice.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResopnse {
    private String id;
    private  String email;
    private  String password;
    private String firstName;
    private  String lastName;
    private LocalDateTime createdAt;
    private  LocalDateTime updatedAt;
}
package com.fitness.userservice.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String userId;
    private String firstName;
    private String message;
}
package com.fitness.userservice.controller;

import com.fitness.userservice.dto.*;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResopnse> getUserProfile(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResopnse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
    @GetMapping("/{userId}/health")
    public ResponseEntity<HealthResponse> getHealth(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getHealthSummary(userId));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }

}
package com.fitness.userservice.repository;

import com.fitness.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
