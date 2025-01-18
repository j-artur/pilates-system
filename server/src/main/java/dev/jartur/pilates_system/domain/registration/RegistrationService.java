package dev.jartur.pilates_system.domain.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
  @Autowired
  private RegistrationRepository registrationRepository;

  public List<Registration> getRegistrations() {
    return registrationRepository.findAll();
  }

  public Optional<Registration> getRegistrationById(long id) {
    return registrationRepository.findById(id);
  }

  public Registration createRegistration(Registration registration) {
    return registrationRepository.save(registration);
  }

  public Registration updateRegistration(long id, Registration registration) {
    Registration existingRegistration = registrationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Registration not found"));
    existingRegistration.setExpiresAt(registration.getExpiresAt());
    existingRegistration.setWeeklyFrequency(registration.getWeeklyFrequency());
    existingRegistration.setProfile(registration.getProfile());
    return registrationRepository.save(existingRegistration);
  }

  public void deleteRegistration(long id) {
    registrationRepository.deleteById(id);
  }
}
