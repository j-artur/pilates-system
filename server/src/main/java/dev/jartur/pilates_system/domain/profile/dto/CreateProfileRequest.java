package dev.jartur.pilates_system.domain.profile.dto;

import dev.jartur.pilates_system.domain.profile.Profile;
import jakarta.validation.constraints.NotBlank;

public record CreateProfileRequest(@NotBlank String cpf, @NotBlank String name) {
  public Profile toProfile() {
    var profile = new Profile();
    profile.setCpf(cpf);
    profile.setName(name);
    return profile;
  }
}
