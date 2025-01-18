package dev.jartur.pilates_system.domain.profile;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import dev.jartur.pilates_system.domain.instructor.Instructor;
import dev.jartur.pilates_system.domain.registration.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "profiles")
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(columnDefinition = "serial")
  private long id;

  @Column()
  private String name;

  @Column()
  private String cpf;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToOne(mappedBy = "profile", optional = true)
  private Instructor instructor;

  @OneToMany(mappedBy = "profile")
  private List<Registration> registrations;
}
