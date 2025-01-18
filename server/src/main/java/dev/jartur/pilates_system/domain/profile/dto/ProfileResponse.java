package dev.jartur.pilates_system.domain.profile.dto;

import java.time.LocalDateTime;

import dev.jartur.pilates_system.domain.profile.Profile;

public record ProfileResponse(
    long id,
    String cpf,
    String name,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
  public static ProfileResponse fromProfile(Profile profile) {
    return new ProfileResponse(
        profile.getId(),
        profile.getCpf(),
        profile.getName(),
        profile.getCreatedAt(),
        profile.getUpdatedAt());
  }
}
