package com.hmbrandt.maintenance_service.controller;


import com.hmbrandt.maintenance_service.dto.mechanic.CreateMechanicDto;
import com.hmbrandt.maintenance_service.dto.mechanic.MechanicResponseDto;
import com.hmbrandt.maintenance_service.dto.mechanic.ValidatePinDto;
import com.hmbrandt.maintenance_service.entity.Mechanic;
import com.hmbrandt.maintenance_service.service.mechanic.MechanicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/maintenance/mechanic")
@RequiredArgsConstructor
public class MechanicController {
    private final MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<List<MechanicResponseDto>> getActiveMechanics() {
        return ResponseEntity.ok(mechanicService.getActiveMechanics());
    }

    // Registrar un nuevo mecánico con su PIN hasheado
    @PostMapping
    public ResponseEntity<MechanicResponseDto> createMechanic(@Valid @RequestBody CreateMechanicDto dto) {
        MechanicResponseDto created = mechanicService.createMechanic(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Endpoint opcional si deseas validar el PIN de forma independiente
    @PostMapping("/validate-pin")
    public ResponseEntity<MechanicResponseDto> validatePin(@Valid @RequestBody ValidatePinDto dto) {
        Mechanic mechanic = mechanicService.validatePin(dto);

        // Si es correcto, devolvemos los datos del mecánico verificado
        return ResponseEntity.ok(new MechanicResponseDto(
                mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName(),
                mechanic.getFullName(),
                mechanic.getEmail(),
                mechanic.isActive()
        ));
    }

}
