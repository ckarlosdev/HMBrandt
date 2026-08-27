package com.hmbrandt.maintenance_service.dto;

public record WorkOrderTaskResponseDto(
        Long id,
        String taskDescription,
        PreventiveScheduleResponseDto schedule,
        EquipmentIssueResponseDto issue,
        Boolean isCompleted
) {
}
