package dev.jartur.pilates_system.domain.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jartur.pilates_system.domain.registration.dto.CreateRegistrationRequest;
import dev.jartur.pilates_system.domain.registration.dto.RegistrationResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
  @Autowired
  private RegistrationService registrationService;

  @GetMapping
  public List<RegistrationResponse> getRegistrations() {
    return registrationService.getRegistrations().stream().map(RegistrationResponse::fromRegistration).toList();
  }

  @GetMapping("/{id}")
  public Optional<RegistrationResponse> getRegistrationById(long id) {
    return registrationService.getRegistrationById(id).map(RegistrationResponse::fromRegistration);
  }

  @PostMapping
  public RegistrationResponse createRegistration(@RequestBody @Valid CreateRegistrationRequest req) {
    return RegistrationResponse.fromRegistration(registrationService.createRegistration(req.toRegistration()));
  }

  @PutMapping("/{id}")
  public RegistrationResponse updateRegistration(@PathVariable("id") long id,
      @RequestBody @Valid Registration registration) {
    return RegistrationResponse.fromRegistration(registrationService.updateRegistration(id, registration));
  }

  @DeleteMapping("/{id}")
  public void deleteRegistration(@PathVariable("id") long id) {
    registrationService.deleteRegistration(id);
  }

}
