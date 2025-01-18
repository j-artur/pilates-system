package dev.jartur.pilates_system.domain.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jartur.pilates_system.domain.profile.dto.CreateProfileRequest;
import dev.jartur.pilates_system.domain.profile.dto.ProfileResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
  @Autowired
  private ProfileService profileService;

  @GetMapping
  public List<ProfileResponse> getProfiles() {
    return profileService.getProfiles().stream().map(ProfileResponse::fromProfile).toList();
  }

  @GetMapping("/{id}")
  public ProfileResponse getProfileById(long id) {
    return profileService.getProfileById(id).map(ProfileResponse::fromProfile)
        .orElseThrow(() -> new RuntimeException("Profile not found"));
  }

  @PostMapping
  public ProfileResponse createProfile(@RequestBody @Valid CreateProfileRequest req) {
    return ProfileResponse.fromProfile(profileService.createProfile(req.toProfile()));
  }

  @PutMapping("/{id}")
  public ProfileResponse updateProfile(@PathVariable("id") long id, @RequestBody @Valid CreateProfileRequest req) {
    return ProfileResponse.fromProfile(profileService.updateProfile(id, req.toProfile()));
  }

  @DeleteMapping("/{id}")
  public void deleteProfile(@PathVariable("id") long id) {
    profileService.deleteProfile(id);
  }
}
