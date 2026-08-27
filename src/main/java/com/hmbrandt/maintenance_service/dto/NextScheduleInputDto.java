package com.hmbrandt.maintenance_service.dto;

import java.math.BigDecimal;

public record NextScheduleInputDto(
        Long preventivePlanId,
        String nextDueDate,
        BigDecimal nextDueMeter
) {
}
