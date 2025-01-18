package dev.jartur.pilates_system.domain.user.dto;

import java.time.LocalDateTime;

import dev.jartur.pilates_system.domain.user.User;

public record UserResponse(
    long id,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
  public static UserResponse fromUser(User user) {
    return new UserResponse(
        user.getId(),
        user.getEmail(),
        user.getCreatedAt(),
        user.getUpdatedAt());
  }
}
