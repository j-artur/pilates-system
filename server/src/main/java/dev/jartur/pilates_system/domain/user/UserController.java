package dev.jartur.pilates_system.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jartur.pilates_system.domain.user.dto.CreateUserRequest;
import dev.jartur.pilates_system.domain.user.dto.UserResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserResponse> getUsers() {
    return userService.getUsers().stream().map(UserResponse::fromUser).toList();
  }

  @GetMapping("/{id}")
  public Optional<UserResponse> getUserById(long id) {
    return userService.getUserById(id).map(UserResponse::fromUser);
  }

  @PostMapping
  public UserResponse createUser(@RequestBody @Valid CreateUserRequest req) {
    return UserResponse.fromUser(userService.createUser(req.toUser()));
  }

  @PutMapping("/{id}")
  public UserResponse updateUser(@PathVariable("id") long id, @RequestBody @Valid CreateUserRequest req) {
    return UserResponse.fromUser(userService.updateUser(id, req.toUser()));
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
  }
}
