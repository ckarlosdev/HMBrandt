package com.hmbrandt.maintenance_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "mechanics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "email", nullable = false, length = 50)
    private String lastName;

    @Column(name = "last_name", unique = true, length = 100)
    private String email;

    @JsonIgnore
    @Column(name = "pin_hash", nullable = false)
    private String pinHash;

    @Builder.Default
    @Column( name = "mechanic_role", nullable = false, length = 30)
    private String role = "MECHANIC";

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Helper para obtener el nombre completo que usas en los dropdowns de React
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
