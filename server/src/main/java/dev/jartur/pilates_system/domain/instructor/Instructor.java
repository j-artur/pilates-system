package dev.jartur.pilates_system.domain.instructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import dev.jartur.pilates_system.domain.appointment.Appointment;
import dev.jartur.pilates_system.domain.profile.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "instructors")
public class Instructor {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @OneToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "profile_id", unique = true, nullable = false)
  private Profile profile;

  @OneToMany(mappedBy = "instructor")
  private List<Appointment> appointments;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
