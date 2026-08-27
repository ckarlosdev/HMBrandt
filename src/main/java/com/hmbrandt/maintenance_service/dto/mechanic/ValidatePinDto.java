package com.hmbrandt.maintenance_service.dto.mechanic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ValidatePinDto(
        @NotNull Long mechanicId,
        @NotBlank String pin
) {

}
