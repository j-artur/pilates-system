package dev.jartur.pilates_system.domain.instructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jartur.pilates_system.domain.instructor.dto.CreateInstructorRequest;
import dev.jartur.pilates_system.domain.instructor.dto.InstructorResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
  @Autowired
  private InstructorService instructorService;

  @GetMapping
  public List<InstructorResponse> getInstructors() {
    return instructorService.getInstructors().stream().map(InstructorResponse::fromInstructor).toList();
  }

  @GetMapping("/{id}")
  public Optional<InstructorResponse> getInstructorById(long id) {
    return instructorService.getInstructorById(id).map(InstructorResponse::fromInstructor);
  }

  @PostMapping
  public InstructorResponse createInstructor(@RequestBody @Valid CreateInstructorRequest req) {
    return InstructorResponse.fromInstructor(instructorService.createInstructor(req.toInstructor()));
  }

  @PutMapping("/{id}")
  public InstructorResponse updateInstructor(long id, @RequestBody @Valid CreateInstructorRequest req) {
    return InstructorResponse.fromInstructor(instructorService.updateInstructor(id, req.toInstructor()));
  }

  @DeleteMapping("/{id}")
  public void deleteInstructor(long id) {
    instructorService.deleteInstructor(id);
  }
}
