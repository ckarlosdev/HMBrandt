package com.hmbrandt.maintenance_service.dto;

public record EquipmentIssueParentDto(
        Long parentIssueId,
        String userName
) {
}
