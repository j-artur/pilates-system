package dev.jartur.pilates_system.domain.appointment;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import dev.jartur.pilates_system.domain.instructor.Instructor;
import dev.jartur.pilates_system.domain.registration.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "appointments")
public class Appointment {
  public enum Status {
    PENDING,
    DONE,
    JUSTIFIED,
    MISSED,
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public long id;

  @Column
  public LocalDateTime date;

  @Column
  public Duration duration;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "instructor_id")
  public Instructor instructor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "costumer_registration_id")
  public Registration costumerRegistration;

  @Column(nullable = false)
  public Status status = Status.PENDING;

  @CreatedDate
  @Column(name = "created_at")
  public LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  public LocalDateTime updatedAt;
}
