package dev.jartur.pilates_system.domain.instructor.dto;

import dev.jartur.pilates_system.domain.instructor.Instructor;
import dev.jartur.pilates_system.domain.profile.Profile;
import jakarta.validation.constraints.NotNull;

public record CreateInstructorRequest(@NotNull Long profileId) {
  public Instructor toInstructor() {
    var instructor = new Instructor();
    var profile = new Profile();
    profile.setId(profileId);
    instructor.setProfile(profile);
    return instructor;
  }
}
