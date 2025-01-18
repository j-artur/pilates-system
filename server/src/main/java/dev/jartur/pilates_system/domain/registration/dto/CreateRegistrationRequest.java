package dev.jartur.pilates_system.domain.registration.dto;

import java.time.LocalDateTime;

import dev.jartur.pilates_system.domain.profile.Profile;
import dev.jartur.pilates_system.domain.registration.Registration;
import jakarta.validation.constraints.NotNull;

public record CreateRegistrationRequest(
    @NotNull Long profileId,
    @NotNull LocalDateTime expiresAt,
    @NotNull Integer weeklyFrequency) {
  public Registration toRegistration() {
    var registration = new Registration();
    var profile = new Profile();
    profile.setId(profileId);
    registration.setProfile(profile);
    registration.setExpiresAt(expiresAt);
    registration.setWeeklyFrequency(weeklyFrequency);
    return registration;
  }
}
