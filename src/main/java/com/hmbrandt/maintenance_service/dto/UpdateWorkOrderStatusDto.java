package com.hmbrandt.maintenance_service.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UpdateWorkOrderStatusDto(
        @NotBlank String orderStatus,
        String userName,
        Double totalCost,
        Long mechanicId,
        String pin,
        List<NextScheduleInputDto> nextSchedules
) {
}
