package dev.jartur.pilates_system.domain.profile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
  @Autowired
  private ProfileRepository profileRepository;

  public List<Profile> getProfiles() {
    return profileRepository.findAll();
  }

  public Optional<Profile> getProfileById(long id) {
    return profileRepository.findById(id);
  }

  public Profile createProfile(Profile profile) {
    return profileRepository.save(profile);
  }

  public Profile updateProfile(long id, Profile profile) {
    Profile existingProfile = profileRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Profile not found"));
    existingProfile.setCpf(profile.getCpf());
    existingProfile.setName(profile.getName());
    return profileRepository.save(existingProfile);
  }

  public void deleteProfile(long id) {
    profileRepository.deleteById(id);
  }
}
