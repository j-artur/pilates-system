package dev.jartur.pilates_system.domain.user.dto;

import dev.jartur.pilates_system.domain.user.User;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String email, @NotBlank String password) {
  public User toUser() {
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    return user;
  }
}
