package com.hmbrandt.maintenance_service.service.mechanic;

import com.hmbrandt.maintenance_service.dto.mechanic.CreateMechanicDto;
import com.hmbrandt.maintenance_service.dto.mechanic.MechanicResponseDto;
import com.hmbrandt.maintenance_service.dto.mechanic.ValidatePinDto;
import com.hmbrandt.maintenance_service.entity.Mechanic;
import com.hmbrandt.maintenance_service.repository.MechanicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicServiceImpl implements MechanicService{

    private final MechanicRepository mechanicRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MechanicResponseDto createMechanic(CreateMechanicDto dto) {
        // Hashear el PIN antes de persistir en MySQL
        String encodedPin = passwordEncoder.encode(dto.pin());

        Mechanic mechanic = Mechanic.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .pinHash(encodedPin)
                .active(true)
                .build();

        Mechanic saved = mechanicRepository.save(mechanic);
        return mapToDto(saved);
    }

    @Transactional(readOnly = true)
    public List<MechanicResponseDto> getActiveMechanics() {
        return mechanicRepository.findByActiveTrue()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Mechanic validatePin(ValidatePinDto dto) {
        Mechanic mechanic = mechanicRepository.findByIdAndActiveTrue(dto.mechanicId())
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found or inactive"));

        // BCrypt compara el texto plano ingresado en el modal con el hash de la DB
        if (!passwordEncoder.matches(dto.pin(), mechanic.getPinHash())) {
            throw new BadCredentialsException("Invalid PIN");
        }

        return mechanic;
    }

    private MechanicResponseDto mapToDto(Mechanic mechanic) {
        return new MechanicResponseDto(
                mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName(),
                mechanic.getFullName(),
                mechanic.getEmail(),
                mechanic.isActive()
        );
    }
}
