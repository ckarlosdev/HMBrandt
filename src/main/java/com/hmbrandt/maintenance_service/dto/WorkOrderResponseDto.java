package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public record WorkOrderResponseDto(
        Long id,
        Long equipmentId,
        String orderType,
        String orderStatus,
        Double totalCost,
        String createdBy,
        LocalDateTime createdAt,
        List<WorkOrderTaskResponseDto> tasks
) {}
