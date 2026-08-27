package com.hmbrandt.maintenance_service.dto;

public record EquipmentIssueUpdateDto(
        Long equipmentId,
        String reportedBy,
        String issueDescription,
        String severity,
        String userName
) {
}
