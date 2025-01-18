package dev.jartur.pilates_system.domain.instructor.dto;

import java.time.LocalDateTime;

import dev.jartur.pilates_system.domain.instructor.Instructor;
import dev.jartur.pilates_system.domain.profile.dto.ProfileResponse;

public record InstructorResponse(
    long id,
    ProfileResponse profile,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
  public static InstructorResponse fromInstructor(Instructor instructor) {
    return new InstructorResponse(
        instructor.getId(),
        ProfileResponse.fromProfile(instructor.getProfile()),
        instructor.getCreatedAt(),
        instructor.getUpdatedAt());
  }
}
