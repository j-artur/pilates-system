package dev.jartur.pilates_system.domain.instructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
  @Autowired
  private InstructorRepository instructorRepository;

  public List<Instructor> getInstructors() {
    return instructorRepository.findAll();
  }

  public Optional<Instructor> getInstructorById(long id) {
    return instructorRepository.findById(id);
  }

  public Instructor createInstructor(Instructor instructor) {
    return instructorRepository.save(instructor);
  }

  public Instructor updateInstructor(long id, Instructor instructor) {
    Instructor existingInstructor = instructorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Instructor not found"));
    existingInstructor.setProfile(instructor.getProfile());
    return instructorRepository.save(existingInstructor);
  }

  public void deleteInstructor(long id) {
    instructorRepository.deleteById(id);
  }
}
