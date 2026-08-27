package com.hmbrandt.maintenance_service.dto;

import jakarta.validation.constraints.Size;

public record UpdateWorkOrderTaskDto(
        @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
        String taskDescription,
        Boolean isCompleted,
        Long preventivePlanId,
        Long equipmentIssueId,
        String updatedBy
) { }
