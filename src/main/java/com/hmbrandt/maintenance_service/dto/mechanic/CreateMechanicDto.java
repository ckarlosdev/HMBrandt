package com.hmbrandt.maintenance_service.dto.mechanic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMechanicDto(
        @NotBlank String firstName,
        @NotBlank String lastName,
        String email,
        @NotBlank @Size(min = 4, max = 8) String pin
) {
}
