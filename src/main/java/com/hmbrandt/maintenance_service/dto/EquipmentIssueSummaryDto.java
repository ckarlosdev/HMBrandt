package com.hmbrandt.maintenance_service.dto;

import java.time.LocalDateTime;

public record EquipmentIssueSummaryDto(
        Long id,
        Long equipmentId,
        String reportedBy,
        LocalDateTime reportedAt,
        String issueDescription,
        String severity,
        String issueStatus,
        Long workOrderId,
        String orderType,
        String orderStatus
) {
}
