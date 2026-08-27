package com.hmbrandt.maintenance_service.service.mechanic;

import com.hmbrandt.maintenance_service.dto.mechanic.CreateMechanicDto;
import com.hmbrandt.maintenance_service.dto.mechanic.MechanicResponseDto;
import com.hmbrandt.maintenance_service.dto.mechanic.ValidatePinDto;
import com.hmbrandt.maintenance_service.entity.Mechanic;

import java.util.List;

public interface MechanicService {
    MechanicResponseDto createMechanic(CreateMechanicDto dto);

    List<MechanicResponseDto> getActiveMechanics();

    Mechanic validatePin(ValidatePinDto dto);
}
