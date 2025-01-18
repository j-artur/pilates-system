package dev.jartur.pilates_system.domain.registration.dto;

import java.time.LocalDateTime;

import dev.jartur.pilates_system.domain.profile.dto.ProfileResponse;
import dev.jartur.pilates_system.domain.registration.Registration;

public record RegistrationResponse(
    long id,
    ProfileResponse profile,
    String expiresAt,
    int weeklyFrequency,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
  public static RegistrationResponse fromRegistration(Registration registration) {
    return new RegistrationResponse(
        registration.getId(),
        ProfileResponse.fromProfile(registration.getProfile()),
        registration.getExpiresAt().toString(),
        registration.getWeeklyFrequency(),
        registration.getCreatedAt(),
        registration.getUpdatedAt());
  }
}
