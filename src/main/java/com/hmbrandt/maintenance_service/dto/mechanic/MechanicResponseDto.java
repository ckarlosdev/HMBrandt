package com.hmbrandt.maintenance_service.dto.mechanic;

public record MechanicResponseDto(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        boolean active
) {
}
