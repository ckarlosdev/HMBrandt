package com.hmbrandt.maintenance_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PreventiveScheduleRequestDto(
        Long preventivePlanId,
        Long equipmentId,
        LocalDate lastPerformedDate,
        BigDecimal lastPerformedMeter,
        LocalDate dueDate,
        BigDecimal dueMeter,
        String userName
) {}
